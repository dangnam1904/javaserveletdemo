package jweb.p.a101.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jweb.p.a101.connectdb.ConnectDB;
import jweb.p.a101.dao.LoginDAO;
import jweb.p.a101.model.Member;

@WebServlet(name="/LoginController", urlPatterns ={"/login"})
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member member=null;
		request.setCharacterEncoding("UTF-8");
		member= LoginDAO.authenticationMenber(request);
		if(member.getId()!=0) {
			HttpSession session= request.getSession();
			session.setAttribute("sessionName",member.getUseName());
			session.setAttribute("sessionID",member.getId());
			session.setMaxInactiveInterval(7200);
			request.getRequestDispatcher("Home.jsp").forward(request, response);
		}
		else{
			request.setAttribute("msglogin","Tên hoặc mật khẩu sai");
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request,response);
		}
		

	}
}
