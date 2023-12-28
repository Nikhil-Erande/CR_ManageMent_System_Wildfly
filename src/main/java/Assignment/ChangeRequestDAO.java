package Assignment;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Assignment.ChangeRequest;

public class ChangeRequestDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/demo?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "root";

    private static final String INSERT_CHANGE_REQUEST_SQL = "INSERT INTO ChangeRequest"
            + "  (title, description, status, priority, requested_by, assigned_to, start_date, end_date, comments, attachments, approval_status) VALUES "
            + " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

    private static final String SELECT_CHANGE_REQUEST_BY_ID = "SELECT * FROM ChangeRequest WHERE cr_id = ?";
    private static final String SELECT_ALL_CHANGE_REQUESTS = "SELECT * FROM ChangeRequest";
    private static final String DELETE_CHANGE_REQUEST_SQL = "DELETE FROM ChangeRequest WHERE cr_id = ?";
    private static final String UPDATE_CHANGE_REQUEST_SQL = "UPDATE ChangeRequest SET title = ?, description = ?, status = ?, priority = ?, requested_by = ?, assigned_to = ?, start_date = ?, end_date = ?, comments = ?, attachments = ?, approval_status = ? WHERE cr_id = ?";

    public ChangeRequestDAO() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void insertChangeRequest(ChangeRequest changeRequest) throws SQLException {
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CHANGE_REQUEST_SQL)) {
            preparedStatement.setString(1, changeRequest.getTitle());
            preparedStatement.setString(2, changeRequest.getDescription());
            preparedStatement.setString(3, changeRequest.getStatus());
            preparedStatement.setString(4, changeRequest.getPriority());
            preparedStatement.setString(5, changeRequest.getRequestedBy());
            preparedStatement.setString(6, changeRequest.getAssignedTo());
            preparedStatement.setDate(7, changeRequest.getStartDate());
            preparedStatement.setDate(8, changeRequest.getEndDate());
            preparedStatement.setString(9, changeRequest.getComments());
            preparedStatement.setString(10, changeRequest.getAttachments());
            preparedStatement.setString(11, changeRequest.getApprovalStatus());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public ChangeRequest selectChangeRequest(int id) {
        ChangeRequest changeRequest = null;
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CHANGE_REQUEST_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String title = rs.getString("title");
                String description = rs.getString("description");
                String status = rs.getString("status");
                String priority = rs.getString("priority");
                String requestedBy = rs.getString("requested_by");
                String assignedTo = rs.getString("assigned_to");
                java.sql.Date startDate = rs.getDate("start_date");
                java.sql.Date endDate = rs.getDate("end_date");
                String comments = rs.getString("comments");
                String attachments = rs.getString("attachments");
                String approvalStatus = rs.getString("approval_status");

                changeRequest = new ChangeRequest(id, title, description, status, priority, requestedBy, assignedTo,startDate, endDate, comments, attachments, approvalStatus);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return changeRequest;
    }

    public List<ChangeRequest> selectAllChangeRequests() {
        List<ChangeRequest> changeRequests = new ArrayList<>();
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CHANGE_REQUESTS)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("cr_id");
                String title = rs.getString("title");
                String description = rs.getString("description");
                String status = rs.getString("status");
                String priority = rs.getString("priority");
                String requestedBy = rs.getString("requested_by");
                String assignedTo = rs.getString("assigned_to");
                java.sql.Date startDate = rs.getDate("start_date");
                java.sql.Date endDate = rs.getDate("end_date");
                String comments = rs.getString("comments");
                String attachments = rs.getString("attachments");
                String approvalStatus = rs.getString("approval_status");

                ChangeRequest changeRequest = new ChangeRequest(id, title, description, status, priority, requestedBy,
                        assignedTo, startDate, endDate, comments, attachments, approvalStatus);
                changeRequests.add(changeRequest);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return changeRequests;
    }

    public boolean deleteChangeRequest(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(DELETE_CHANGE_REQUEST_SQL)) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateChangeRequest(ChangeRequest changeRequest) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(UPDATE_CHANGE_REQUEST_SQL)) {
            statement.setString(1, changeRequest.getTitle());
            statement.setString(2, changeRequest.getDescription());
            statement.setString(3, changeRequest.getStatus());
            statement.setString(4, changeRequest.getPriority());
            statement.setString(5, changeRequest.getRequestedBy());
            statement.setString(6, changeRequest.getAssignedTo());
            statement.setDate(7, changeRequest.getStartDate());
            statement.setDate(8, changeRequest.getEndDate());
            statement.setString(9, changeRequest.getComments());
            statement.setString(10, changeRequest.getAttachments());
            statement.setString(11, changeRequest.getApprovalStatus());
            statement.setInt(12, changeRequest.getCrId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
