package Assignment;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/addCrServlet")
public class addCrServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve form parameters
    	 String title = request.getParameter("title");
         String description = request.getParameter("description");
         String status = request.getParameter("status");
         String priority = request.getParameter("priority");
         String requestedBy = request.getParameter("requestedBy");
         String assignedTo = request.getParameter("assignedTo");
         String startDate = request.getParameter("startDate");
         String endDate = request.getParameter("endDate");
         String comments = request.getParameter("comments");
         String attachments = request.getParameter("attachments");
         String approvalStatus = request.getParameter("approvalStatus");
         
         addChangeRequestToDatabase(title, description, status, priority, requestedBy, assignedTo,
                 startDate, endDate, comments, attachments, approvalStatus);
         
      
         response.sendRedirect("CRs.jsp");
    }
         private void addChangeRequestToDatabase(String title, String description, String status, String priority,
                 String requestedBy, String assignedTo, String startDate, String endDate, String comments,
                 String attachments, String approvalStatus) {
             try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cr_management", "root", "password")) {
                 String query = "INSERT INTO ChangeRequest (title, description, status, priority, requested_by, assigned_to, start_date, end_date, comments, attachments, approval_status) "
                         + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                 try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                     preparedStatement.setString(1, title);
                     preparedStatement.setString(2, description);
                     preparedStatement.setString(3, status);
                     preparedStatement.setString(4, priority);
                     preparedStatement.setString(5, requestedBy);
                     preparedStatement.setString(6, assignedTo);
                     preparedStatement.setString(7, startDate);
                     preparedStatement.setString(8, endDate);
                     preparedStatement.setString(9, comments);
                     preparedStatement.setString(10, attachments);
                     preparedStatement.setString(11, approvalStatus);

                     
                     preparedStatement.executeUpdate();
                 }
        } catch (Exception e) {
            System.out.println("Connection Error");
        }
    }

	
}
