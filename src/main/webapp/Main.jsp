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

        nav a:hover {
            background-color: #555;
        }
        
        nav h2 {
   		    margin: 0px; /* Add some margin */
   		    padding-right: 20px; /* Add some spacing between "Hello" and the links */
   		    position: absolute;
   		    left: 20; /* Align to the left */
		}

        hr {
            border: 1px solid #ccc;
            margin: 20px 0;
        }
        
		footer {
   			 position: fixed;
   			 bottom: 0;
   			 width: 100%;
    		 background-color: #333;
   			 color: #fff;
 		     text-align: center;
             padding: 10px;
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
    	<a href="login.jsp">Login</a>
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
    <div style="max-width: 300px; margin: auto; padding: 20px; border: 1px solid #ccc; border-radius: 5px;">
        <h2>Welcome to CR Portal</h2>
        Please Login to Access the CR portal
        <a href="login.jsp"><br>Login From Here</a></p>
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
