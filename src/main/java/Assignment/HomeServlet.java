package Assignment;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    
	    HttpSession session = request.getSession(false);
	    if (session == null || session.getAttribute("username") == null) {
	        response.sendRedirect("login.jsp");
	        return;
	    }

	    
	    List<ChangeRequest> changeRequests = fetchChangeRequestsFromDatabase();

	  
	    request.setAttribute("changeRequests", changeRequests);

	    
	    RequestDispatcher dispatcher = request.getRequestDispatcher("CRs.jsp");
	    dispatcher.forward(request, response);
	}

	
	private List<ChangeRequest> fetchChangeRequestsFromDatabase() {
	    List<ChangeRequest> changeRequests = new ArrayList<>();

	    try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cr_management", "root", "password")) {
	        String query = "SELECT * FROM ChangeRequest";
	        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                while (resultSet.next()) {
	                    ChangeRequest cr = new ChangeRequest(0, query, query, query, query, query, query, null, null, query, query, query);
	                    cr.setCrId(resultSet.getInt("cr_id"));
	                    cr.setTitle(resultSet.getString("title"));
	                    cr.setDescription(resultSet.getString("description"));
	                    cr.setStatus(resultSet.getString("status"));
	                    cr.setPriority(resultSet.getString("priority"));
	                    cr.setRequestedBy(resultSet.getString("requested_by"));
	                    cr.setAssignedTo(resultSet.getString("assigned_to"));
	                    cr.setStartDate(resultSet.getDate("start_date"));
	                    cr.setEndDate(resultSet.getDate("end_date"));
	                    cr.setComments(resultSet.getString("comments"));
	                    cr.setAttachments(resultSet.getString("attachments"));
	                    cr.setApprovalStatus(resultSet.getString("approval_status"));

	                    changeRequests.add(cr);

	                    
	                    System.out.println("Fetched ChangeRequest: " + cr);
	                }
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	      
	    }

	    return changeRequests;
	}

}
