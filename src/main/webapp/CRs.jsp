<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
            margin: 0 20px;
        }

        nav h2 {
            margin: 0px;
            padding-right: 20px;
            position: absolute;
            left: 20;
        }

        nav .logout {
            margin: 0 20px;
            position: absolute;
            right: 0;
            padding: 2px;
        }

        nav a:hover {
            background-color: #555;
        }

        hr {
            border: 1px solid #ccc;
            margin: 20px 0;
        }

        footer {
        	position: absoulte;
            bottom: 0;
            width: 100%;
            background-color: #333;
            color: #fff;
            text-align: center;
            padding: 10px;
        }

        /* Updated table and row styles */
        table {
            width: 70%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 8px;
            text-align: left;
            border: 1px solid #ddd;
        }

        th {
            background-color: #4CAF50;
            color: white;
        }

        tr:hover {
            background-color: #f5f5f5;
        }
         button {
        background-color: #4CAF50;
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        font-size: 16px;
    }

    button:hover {
        background-color: #45a049;
    }
    </style>

    <script>
        // Disable the back button after logout
        history.pushState(null, null, location.href);
        window.onpopstate = function () {
            history.go(1);
        };

        // Function to fetch records
        function fetchRecords() {
            // Redirect to HomeServlet to fetch records
            window.location.href = 'HomeServlet';
        }
        function redirectToAddCR() {
            window.location.href = 'addCr.jsp';
        }
    </script>
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
    <a href="login.jsp" class="logout">Logout</a>
</nav>

<!-- Line separation -->
<hr>

<!-- Page Content -->
<div>
    <!-- Page Content -->
    <div style="max-width: 1500px; margin: auto; padding: 50px; border: 1px solid #ccc; border-radius: 5px;">
        <!-- Add Fetch Button -->
        <h2>Hello <%= user %>,</h2><h4>Please Find All CRs</h4>
        <button onclick="fetchRecords()">Fetch Records</button>
         <button class="add-button" onclick="redirectToAddCR()">Add CR</button>

        <table border="1">
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Description</th>
                <th>Status</th>
                <th>Priority</th>
                <th>Requested By</th>
                <th>Assigned To</th>
                <th>Start Date</th>
                <th>End Date</th>
                <th>Comments</th>
                <th>Attachments</th>
                <th>Approval Status</th>
            </tr>
            <c:forEach var="cr" items="${changeRequests}">
                <tr>
                    <td>${cr.crId}</td>
                    <td>${cr.title}</td>
                    <td>${cr.description}</td>
                    <td>${cr.status}</td>
                    <td>${cr.priority}</td>
                    <td>${cr.requestedBy}</td>
                    <td>${cr.assignedTo}</td>
                    <td>${cr.startDate}</td>
                    <td>${cr.endDate}</td>
                    <td>${cr.comments}</td>
                    <td>${cr.attachments}</td>
                    <td>${cr.approvalStatus}</td>
                </tr>
            </c:forEach>
        </table>


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

