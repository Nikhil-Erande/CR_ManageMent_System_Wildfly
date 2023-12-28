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
   			 
   			 bottom: 0;
   			 width: 100%;
    		 background-color: #333;
   			 color: #fff;
 		     text-align: center;
             padding: 10px;
        }
        
    
    /* Adjustments for form styling */
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
        <a href="#">Courses</a>
    </nav>

    <!-- Line separation -->
    <hr>

    <!-- Page Content -->
    <div>
			<!-- Page Content -->
<div>
    <div style="max-width: 300px; margin: auto; padding: 20px; border: 1px solid #ccc; border-radius: 5px; margin-right: 10 px">
        <h2>Sign Up</h2>
        <form action="SignUpServlet" method="post">
    <label for="username">Username:</label>
              <input type="text" id="username" name="username" required>
	<br>
    <label for="password">Password:</label>
     <input type="password" id="password" name="password" required>
    <br>
    <label for="full_name">Full Name:</label>
     <input type="text" id="full_name" name="full_name" required>
    <br>
    <label for="email">Email:</label>
     <input type="email" id="email" name="email">
    <br>
    <label for="role">Role:</label>
     <input type="text" id="role" name="role" required>
    <br>
    <button type="submit">Sign Up</button>
</form>
        
        
        
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
