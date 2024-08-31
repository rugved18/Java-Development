package com.anicare;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/form")
public class Forms extends HttpServlet {

    private Connection conn;

    @Override
    public void init() throws ServletException {
        try {
            // Load the JDBC driver
        	Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection to the database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/forms_jdbc_connect", "root", "dbms");
        } catch (ClassNotFoundException | SQLException e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String mail = req.getParameter("mail");

        try {
            // Prepare the SQL statement
            String sql = "INSERT INTO users (name, password, email) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, password);
            ps.setString(3, mail);

            // Execute the SQL statement
            ps.executeUpdate();
            ps.close();

            // Respond to the client
            res.getWriter().println("Data inserted successfully");
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

//    @Override
//    public void destroy() {
//        try {
//            if (conn != null && !conn.isClosed()) {
//                conn.close();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}
