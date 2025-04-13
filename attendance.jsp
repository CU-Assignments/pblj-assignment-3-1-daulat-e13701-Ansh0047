<%@ page language="java" contentType="text/html" %>
<html>
<head><title>Student Attendance</title></head>
<body>
    <h2>Enter Attendance</h2>
    <form action="AttendanceServlet" method="post">
        Student ID: <input type="text" name="studentId" required><br><br>
        Subject: <input type="text" name="subject" required><br><br>
        Date: <input type="date" name="date" required><br><br>
        Status: 
        <select name="status">
            <option value="Present">Present</option>
            <option value="Absent">Absent</option>
        </select><br><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
