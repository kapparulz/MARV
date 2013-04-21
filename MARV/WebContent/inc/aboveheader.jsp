<%@page import="com.marv.business.entities.User"%>
<div class="navbar navbar-fixed-top navbar-inverse">
  <div class="navbar-inner">
    <div class="container">
      <!-- Menu button for smallar screens -->
      <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
      </a>
      <!-- Site name for smallar screens -->
      <a href="index.html" class="brand">MARV</a>

      <!-- Navigation starts -->
      <div class="nav-collapse collapse">        

	
        <!-- Links -->
        <ul class="nav pull-right">
          <li class="dropdown pull-right">            
            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
            <% if(session.getAttribute("authenticated.user") != null) { %>
            	<% User user = (User) session.getAttribute("authenticated.user"); %>
	        	<%= user.getUsername() %>
			<b class="caret"></b>             
            </a>
            <!-- Dropdown menu -->
            <ul class="dropdown-menu">
              <li><a href="#"><i class="icon-user"></i> Profile</a></li>
              <li><a href="#"><i class="icon-cogs"></i> Settings</a></li>
              <li><a href="?command=SignOut"><i class="icon-off"></i> Logout</a></li>
            </ul>
          </li>
        </ul>
        
        <ul class="nav pull-right">
        	<li>
        		<% } else { %>
	<a class="janrainEngage" href="#">Sign-In</a>
<% } %> 
        	</li>
        </ul>

      </div>

    </div>
  </div>
</div>