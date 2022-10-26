package jweb.p.a101.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jweb.p.a101.connectdb.ConnectDB;
import jweb.p.a101.dao.RegisterDAO;
import jweb.p.a101.model.Member;

@WebServlet(name = "/RegisterController", urlPatterns = { "/register" })
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection con = ConnectDB.getConnection();
		Member member = new Member();
		request.setCharacterEncoding("UTF-8");
		member.setUseName(request.getParameter("uname"));

		if (RegisterDAO.checkUseName(request, con, member) == "succes") {
			request.setAttribute("msgregister", "Tài khoản đã tồn tại");
			RequestDispatcher rd = request.getRequestDispatcher("Register.jsp");
			rd.forward(request, response);
		} else {
			if (RegisterDAO.registerAcc(request, con) ) {
				request.setAttribute("msgregister", "Đăng ký thành công");
				RequestDispatcher rd = request.getRequestDispatcher("Register.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("msgregister", "Đăng ký không thành công");
				RequestDispatcher rd = request.getRequestDispatcher("Register.jsp");
				rd.forward(request, response);
			}
		}
		ConnectDB.CloseConnection(con);
	}

}
