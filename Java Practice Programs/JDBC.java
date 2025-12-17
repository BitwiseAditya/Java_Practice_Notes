import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class JDBC {
    public void getFaculty(int facultyId) throws SQLException {
        Connection conn = null;
        PreparedStatement preStmt = null;
        ResultSet rsFaculty = null;

        try {
            // Loading and registering the driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
            // Create and get the connection
            conn = DriverManager.getConnection("jdbc:oracle:thin:Mark/passwd@kecmachine:1521:edford");
            // Create the statement
            preStmt = conn.prepareStatement("select faculty_id, faculty_name from faculty where faculty_id=?");
            // Set the facultyId parameter
            preStmt.setInt(1, facultyId);

            rsFaculty = preStmt.executeQuery();
            // Processing the result
            while (rsFaculty.next()) {
                String facultyName = rsFaculty.getString("faculty_name");
                System.out.println("Faculty Id is: " + facultyId);
                System.out.println("Faculty Name is: " + facultyName);
            }
        } catch (ClassNotFoundException ce) {
            System.out.print("No suitable driver for DB found");
            ce.printStackTrace();
        } catch (SQLException se) {
            System.out.print("SQL Exception occurred");
            se.printStackTrace();
        } finally {
            if (preStmt != null)
                preStmt.close();
            if (conn != null)
                conn.close();
        }
       
        PreparedStatement preStmt2 = conn.prepareStatement("Insert into Student values(?,?,?,?)")) {    // conn is the connection object
 
// Setting parameters
preStmt2.setInt(1, 1001);
preStmt2.setString(2, "John");
preStmt2.setString(3, "Mysore");
preStmt2.setLong(4, 9213456780l);
 
int rowsAffected = preStmt2.executeUpdate();                // Executing the query
 
if(rowsAffected > 0){                                      // processing the result
    System.out.println(rowsAffected + " rows inserted successfully");
}
    }
}
}