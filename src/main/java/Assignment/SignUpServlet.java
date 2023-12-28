package Assignment;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve form parameters
		 String enteredUsername = request.getParameter("username");
	        String enteredPassword = request.getParameter("password");
	        String enteredFullName = request.getParameter("full_name");
	        String enteredEmail = request.getParameter("email");
	        String enteredRole = request.getParameter("role");	
	
try{


// Load the Driver
//Class.forName("com.mysql.cj.jdbc.Driver");
//Class.forName("com.mysql.cj.jdbc.Driver";)
//Establish the connection between java application with mysql database

try(Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cr_management","root","password")){
//Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/emp"rooor","");



    
	String query = "INSERT INTO Users (username, password, full_name, email, role) VALUES (?, ?, ?, ?, ?)";
    try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
    	preparedStatement.setString(1, enteredUsername);
        preparedStatement.setString(2, enteredPassword);
        preparedStatement.setString(3, enteredFullName);
        preparedStatement.setString(4, enteredEmail);
        preparedStatement.setString(5, enteredRole);

        int rowsAffected = preparedStatement.executeUpdate();

       
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head><title>Sign Up Result</title></head>");
        out.println("<body>");

        if (rowsAffected > 0) {
            
            response.sendRedirect("Main.jsp");
        } else {
            
            out.println("<h2>Sign Up Failed. Please check your details.</h2>");
        }

        out.println("</body>");
        out.println("</html>");
        
    }

}
//Statement st=con.createStatement();

catch (SQLException e) {
    e.printStackTrace();
    
    throw new ServletException("Database error", e);
}


}
catch(Exception e)
{
System.out.println("Connection Error"); 
}



}

}

