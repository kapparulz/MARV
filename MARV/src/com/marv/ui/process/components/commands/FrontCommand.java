package com.marv.ui.process.components.commands;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.marv.persistence.core.PersistenceFacade;

public abstract class FrontCommand {

	protected ServletContext context;
	
	protected HttpServletRequest request;
	
	protected HttpServletResponse response;
	
	public abstract void process() throws ServletException, IOException;
	
	public abstract void processPost() throws ServletException, IOException;
	
	public void init(ServletContext context, HttpServletRequest request,
			HttpServletResponse response) {
		this.context = context;
		this.request = request;
		this.response = response;
	}
	
	protected void forward(String target) throws ServletException, IOException {
		RequestDispatcher dispatcher = context.getRequestDispatcher(target);
		dispatcher.forward(request, response);
	}
	
	protected PersistenceFacade getStorage() {
		return PersistenceFacade.getInstance();
	}
}
