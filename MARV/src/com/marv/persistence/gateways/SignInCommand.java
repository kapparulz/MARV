package com.marv.persistence.gateways;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.marv.ui.process.components.commands.FrontCommand;
import com.marv.util.operationalmanagement.ApplicationException;

/**
 * A Command that implements the tokenUrl callback endpoint for Engage. Takes
 * the token returned from Engage, and makes an API call to retrieve the user's
 * profile. Displays that profile as a page of JSON in the browser.
 * 
 * @see https://github.com/janrain/Janrain-Sample-Code
 */
public class SignInCommand extends FrontCommand {
	
	private static final String API_KEY	= "f0d3cd9badfb9a79545437fc1a46a664c0798e39";

	@Override
	public void process() throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void processPost() throws ServletException, IOException {
		HttpURLConnection connection = sendAuthenticationRequest();
		String userData = getUserData(connection);
		//System.out.println("response:" + userData);
		String status;
		String identifier;
		String providerName;
		try {
			JSONParser parser = new JSONParser();
			JSONObject obj = (JSONObject) parser.parse(userData);
			status = (String) obj.get("stat");
			if(status.equals("ok")) {
				JSONObject profile = (JSONObject) obj.get("profile");
				identifier = (String) profile.get("identifier");
				providerName = (String) profile.get("providerName");
				HttpSession session = request.getSession(true);
				session.setAttribute("authenticated.identifier", identifier);
				//TODO: get more fields
				//see http://developers.janrain.com/documentation/engage/reference/user-profile-data/
				System.out.println(identifier);
				System.out.println(providerName);
				//TODO: if the authenticated user does not exist in the database
				// then create one.
			} else {
				throw new ApplicationException("Not authenticated!");
			}
		} catch (ParseException e) {
			throw new ApplicationException(e);
		}
	}

	private String getUserData(HttpURLConnection connection) throws IOException {
		Scanner scanner = new Scanner(connection.getInputStream());
		scanner.useDelimiter("\\A");
		return scanner.next();
	}

	private HttpURLConnection sendAuthenticationRequest()
			throws MalformedURLException, UnsupportedEncodingException,
			IOException, ProtocolException {
		// The user's browser will POST a token to your "token_url" you
		// specified to have them
		// redirected to after the auth process:
		String token = request.getParameter("token");
		// Do a request to the Janrain API with the token we just received.
		// see http://developers.janrain.com/documentation/api/auth_info/
		// You may wish to make this HTTP request with e.g. Apache HttpClient
		// instead.
		URL url = new URL("https://rpxnow.com/api/v2/auth_info");
		String params = String.format("apiKey=%s&token=%s",
				URLEncoder.encode(API_KEY, "UTF-8"),
				URLEncoder.encode(token, "UTF-8"));
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("POST");
		connection.setDoOutput(true);
		connection.connect();
		OutputStreamWriter writer = new OutputStreamWriter(
				connection.getOutputStream(), "UTF-8");
		writer.write(params);
		writer.close();
		return connection;
	}

}
