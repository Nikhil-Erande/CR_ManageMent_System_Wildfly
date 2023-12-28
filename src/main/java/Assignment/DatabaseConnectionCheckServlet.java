package Assignment;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DatabaseConnectionCheckServlet")
public class DatabaseConnectionCheckServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>Database Connection Check</title></head>");
        out.println("<body>");

        Connection connection = null;

        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            
            String jdbcUrl = "jdbc:mysql://localhost:3306/cr_management";
            String username = "root";
            String password = "password";

           
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            out.println("<h2>Database Connection Successful!</h2>");
        } catch (ClassNotFoundException e) {
            out.println("<h2>MySQL JDBC Driver not found!</h2>");
            out.println("<p>Error: " + e.getMessage() + "</p>");
        } catch (SQLException e) {
            out.println("<h2>Database Connection Failed!</h2>");
            out.println("<p>Error: " + e.getMessage() + "</p>");
        } finally {
            
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        out.println("</body>");
        out.println("</html>");
    }
}
