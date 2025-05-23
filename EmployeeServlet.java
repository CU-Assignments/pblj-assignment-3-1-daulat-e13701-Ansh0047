import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class EmployeeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String empId = request.getParameter("empId");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "your_password");

            Statement stmt = con.createStatement();
            String query = empId != null && !empId.isEmpty() ?
                "SELECT * FROM employees WHERE id = " + empId :
                "SELECT * FROM employees";

            ResultSet rs = stmt.executeQuery(query);
            out.println("<h2>Employee List</h2>");
            out.println("<table border='1'><tr><th>ID</th><th>Name</th><th>Position</th></tr>");
            while (rs.next()) {
                out.println("<tr><td>" + rs.getInt("id") + "</td><td>"
                        + rs.getString("name") + "</td><td>"
                        + rs.getString("position") + "</td></tr>");
            }
            out.println("</table>");
            con.close();
        } catch (Exception e) {
            out.println("<h3>Error: " + e.getMessage() + "</h3>");
        }
    }
}
