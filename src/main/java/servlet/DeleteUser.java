package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conn.MySQLConnUtils;

/**
 * Servlet implementation class DeleteUser
 */
@WebServlet("/DeleteUser")
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sql = "delete from user where masinhvien = '" + request.getParameter("id")+"'";
		PrintWriter out = response.getWriter();
		
		try {
			Connection con = MySQLConnUtils.getMyConnection();
			PreparedStatement ps = con.prepareStatement(sql);

			ps.executeUpdate();
			out.print("Xóa thành công!!");
		} catch (Exception e2) {
			e2.printStackTrace();
		} finally {
			out.close();
		}			

}}
