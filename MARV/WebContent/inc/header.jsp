<%@page import="com.marv.business.entities.User"%>
<script type="text/javascript">
	/* Start OpenId authentication script */
	(function() {
		if (typeof window.janrain !== 'object')
			window.janrain = {};
		if (typeof window.janrain.settings !== 'object')
			window.janrain.settings = {};

		janrain.settings.tokenUrl = 'http://localhost:8080/MARV/?command=SignIn';

		function isReady() {
			janrain.ready = true;
		}
		;
		if (document.addEventListener) {
			document.addEventListener("DOMContentLoaded", isReady, false);
		} else {
			window.attachEvent('onload', isReady);
		}

		var e = document.createElement('script');
		e.type = 'text/javascript';
		e.id = 'janrainAuthWidget';

		if (document.location.protocol === 'https:') {
			e.src = 'https://rpxnow.com/js/lib/marv/engage.js';
		} else {
			e.src = 'http://widget-cdn.rpxnow.com/js/lib/marv/engage.js';
		}

		var s = document.getElementsByTagName('script')[0];
		s.parentNode.insertBefore(e, s);
	})();
	/* End OpenId authentication script */
</script>
<% if(session.getAttribute("authenticated.user") != null) { %>
	<% User user = (User) session.getAttribute("authenticated.user"); %>
	<%= user.getUsername() %>
	<a href="?command=SignOut">Sign-Out</a>
<% } else { %>
	<a class="janrainEngage" href="#">Sign-In</a>
<% } %>
<a href="?command=Institution">Add Institution</a>
<a href="?command=ListInstitutions">List Institutions</a>
<a href="?command=User">Add User</a>
<a href="?command=ListAuctionCategories">List Auction Categories</a>