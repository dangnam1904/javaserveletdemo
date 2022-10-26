package jweb.p.a101.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jweb.p.a101.dao.UserDao;
import jweb.p.a101.model.Member;

@WebServlet(name="/editProfile", urlPatterns = "/editProfile")
public class EditProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public EditProfileController() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member member= new Member();
		request.setCharacterEncoding("UTF-8");
		member=UserDao.getInfoMember(request);
		request.setAttribute("m", member);
		request.getRequestDispatcher("EditProfile.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if( UserDao.updateProfile(request)) {
			request.setAttribute("msg","Sửa thành công");
			RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
			rd.forward(request,response);
		};
	}

}
