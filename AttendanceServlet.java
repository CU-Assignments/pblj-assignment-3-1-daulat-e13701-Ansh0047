import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AttendanceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String studentId = request.getParameter("studentId");
        String subject = request.getParameter("subject");
        String date = request.getParameter("date");
        String status = request.getParameter("status");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "your_password");

            PreparedStatement pst = con.prepareStatement("INSERT INTO attendance(student_id, subject, date, status) VALUES (?, ?, ?, ?)");
            pst.setString(1, studentId);
            pst.setString(2, subject);
            pst.setString(3, date);
            pst.setString(4, status);

            int i = pst.executeUpdate();
            if (i > 0) {
                out.println("<h3>Attendance recorded successfully!</h3>");
            } else {
                out.println("<h3>Failed to record attendance.</h3>");
            }
            con.close();
        } catch (Exception e) {
            out.println("<h3>Error: " + e.getMessage() + "</h3>");
        }
    }
}
