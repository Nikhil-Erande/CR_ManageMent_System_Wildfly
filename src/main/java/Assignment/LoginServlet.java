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

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String enteredUsername = request.getParameter("username");
        String enteredPassword = request.getParameter("password");

        try {
          
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cr_management", "root",
                    "password")) {
                
                String query = "SELECT * FROM Users WHERE username = ? AND password = ?";
                try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                    preparedStatement.setString(1, enteredUsername);
                    preparedStatement.setString(2, enteredPassword);

                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                      
                        boolean isValid = resultSet.next();

                        response.setContentType("text/html;charset=UTF-8");
                        PrintWriter out = response.getWriter();

                        out.println("<html>");
                        out.println("<head><title>Login Result</title></head>");
                        out.println("<body>");

                        if (isValid) {
                           
                            HttpSession session = request.getSession(true);

                            
                            session.setAttribute("username", enteredUsername);
                            session.setMaxInactiveInterval(10 * 60); 

                            out.println("<script type=\"text/javascript\">");
                            out.println("alert('Login Successful!');");
                           // out.println("<h2>Login Successful!</h2>");
                            response.sendRedirect("Home.jsp?enteredUsername="+enteredUsername);
                            
                        } else {
                           // out.println("<h2>.</h2>");
                            out.println("<script type=\"text/javascript\">");
                            out.println("alert('Login Failed. Invalid username or password');");
                            response.sendRedirect("login.jsp?status="+"L");
                        }

                        out.println("</body>");
                        out.println("</html>");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
                
                throw new ServletException("Database error", e);
            }
        } catch (Exception e) {
            System.out.println("Connection Error");
        }
    }
}
