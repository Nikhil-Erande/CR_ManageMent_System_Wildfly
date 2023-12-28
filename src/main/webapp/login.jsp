<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CR Management System</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }

        header {
            background-color: #333;
            color: #fff;
            padding: 10px;
            text-align: center;
        }

        nav {
            background-color: #444;
            color: #fff;
            padding: 10px;
            text-align: center;
        }

        nav a {
            color: #fff;
            text-decoration: none;
            padding: 10px;
            margin: 0 10px;
        }
        
        nav h2 {
   		    margin: 0px; /* Add some margin */
   		    padding-right: 20px; /* Add some spacing between "Hello" and the links */
   		    position: absolute;
   		    left: 20; /* Align to the left */
		}

        nav a:hover {
            background-color: #555;
        }

        hr {
            border: 1px solid #ccc;
            margin: 20px 0;
        }

        footer {
   			 
   			 bottom: 0;
   			 width: 100%;
    		 background-color: #333;
   			 color: #fff;
 		     text-align: center;
             padding: 10px;
        }
        
        form {
        max-width: 300px;
        margin: auto;
        padding: 20px;
        border: 1px solid #ccc;
        border-radius: 5px;
        }

    form label {
        display: block;
        margin-bottom: 5px;
    }

    form input {
        width: 100%;
        padding: 8px;
        margin-bottom: 10px;
        box-sizing: border-box;
    }

    form button {
        background-color: #333;
        color: #fff;
        padding: 10px;
        border: none;
        border-radius: 3px;
        cursor: pointer;
    }

    form button:hover {
        background-color: #555;
    }
       
    </style>
</head>
<body>
	<%
        String user ="Guest" ; 
        %>
    <!-- Header -->
    <header>
        <h2>CR Management System</h2>
    </header>

    <!-- Navbar -->
    <nav>
    	<h2>Hello <%= user %>,</h2>
    	<a href="Main.jsp">Login</a>
        <a href="#">Home</a>
        <a href="#">CRs</a>
        <a href="">Courses</a>
    </nav>

    <!-- Line separation -->
    <hr>

    <!-- Page Content -->
    <div>
			<!-- Page Content -->
<div>
	<%
          String status = (String)request.getParameter("status");
          if(status==null)
            status="T";
      %>
    <div style="max-width: 300px; margin: auto; padding: 20px; border: 1px solid #ccc; border-radius: 5px;">
        <h2>Login</h2>
        <form action="LoginServlet" method="post">
       
    <label for="username">Username :</label>
    <input type="text" id="username" name="username" required>
    <br>
    <br>
    <label for="password">Password :</label>
    <input type="password" id="password" name="password" required>
    <%if(status.equals("F"))
        {%>
        <font style="color: red">Username and Password do not match!!</font>
        <%}
            else if(status.equals("L"))
        {
        %>
        <font style="color: red">Invalid Login Details!!</font>
        <%}
        else{}
        %>
    <br>
    <br>
    <button type="submit">Login</button>
</form>

<!-- Add a hyperlink for new user signup -->
<p>Don't have an account? <a href="newUser.jsp"><br>Sign up for a new account</a></p>
        
    </div>
</div>
			
    </div>

    <!-- Line separation -->
    <hr>

    <!-- Footer -->
    <footer>
        <p>&copy; 2023 CR Management System Nikhil</p>
    </footer>

</body>
</html>
