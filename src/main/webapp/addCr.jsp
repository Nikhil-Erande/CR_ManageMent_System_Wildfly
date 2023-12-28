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
            max-width: 600px;
            margin: 20px auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        label {
            display: block;
            margin-bottom: 8px;
        }

        input, textarea {
            width: 100%;
            padding: 8px;
            margin-bottom: 12px;
            box-sizing: border-box;
        }

        input[type="date"] {
            width: calc(100% - 16px); /* Adjust for date input width */
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
	<%
        String user = (String)request.getParameter("enteredUsername");
        if(user!=null)
        session.setAttribute("username", user);
        else
            user = (String)session.getAttribute("username");
        %>
        
    <!-- Header -->
    <header>
        <h2>CR Management System</h2>
    </header>

    <!-- Navbar -->
    <nav>
    	<h2>Hello <%= user %>,</h2>
    
        <a href="Home.jsp">Home</a>
        <a href="CRs.jsp">CRs</a>
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
    <div style="max-width: 600px; margin: auto; padding: 20px; border: 1px solid #ccc; border-radius: 5px;">
        
        

<!-- Add a hyperlink for new user signup -->
<h2>Add Change Request</h2>
    <form action="addCrServlet" method="post">
        <!-- Add input fields for each attribute -->
        Title: <input type="text" name="title" required><br>
        Description: <textarea name="description"></textarea><br>
        Status: <input type="text" name="status"><br>
        Priority: <input type="text" name="priority"><br>
        Requested By: <input type="text" name="requestedBy"><br>
        Assigned To: <input type="text" name="assignedTo"><br>
        Start Date: <input type="date" name="startDate"><br>
        End Date: <input type="date" name="endDate"><br>
        Comments: <textarea name="comments"></textarea><br>
        Attachments: <input type="text" name="attachments"><br>
        Approval Status: <input type="text" name="approvalStatus"><br>
        <input type="submit" value="Submit">
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
