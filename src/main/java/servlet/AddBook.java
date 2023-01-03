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
 * Servlet implementation class AddBook
 */
@WebServlet("/AddBook")
public class AddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sql = "Insert into book (MaSach,TenSach,TacGia,NhaXuatBan,Soluong) values ('"
				+ request.getParameter("txtMaSach") + "','"
				+ request.getParameter("txtTenSach") + "','"
				+ request.getParameter("txtTacGia") + "','"
				+ request.getParameter("txtNXB") + "',"
				+ request.getParameter("txtSoLuong") + ")";
		PrintWriter out = response.getWriter();
		out.println(sql);
		try {
			Connection con = MySQLConnUtils.getMyConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.executeUpdate();
			out.print("Thêm thành công!!!");
		} catch (Exception e2) {
			e2.printStackTrace();
		} finally {
			out.close();
		}		
	}

}
