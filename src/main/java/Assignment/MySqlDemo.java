package Assignment;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.*;
import javax.resource.cci.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MySqlDemo {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String enteredUsername = request.getParameter("username");
        String enteredPassword = request.getParameter("password");	
	
try{



Class.forName("com.mysql.cj.jdbc.Driver");
//Class.forName("com.mysql.cj.jdbc.Driver";)


try(Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cr_management","root","password")){
//Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/emp"rooor","");


  
    String query = "SELECT * FROM Users WHERE username = ? AND password = ?";
    try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
        preparedStatement.setString(1, enteredUsername);
        preparedStatement.setString(2, enteredPassword);

        try (ResultSet resultSet = (ResultSet) preparedStatement.executeQuery()) {
            
            boolean isValid = resultSet.next();

            
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();

            out.println("<html>");
            out.println("<head><title>Login Result</title></head>");
            out.println("<body>");

            if (isValid) {
                out.println("<h2>Login Successful!</h2>");
            } else {
                out.println("<h2>Login Failed. Invalid username or password.</h2>");
            }

            out.println("</body>");
            out.println("</html>");
        }
    }

}
//Statement st=con.createStatement();
//Write and Exceute sql Query
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

