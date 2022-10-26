package jweb.p.a101.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jweb.p.a101.dao.ContentDAO;
import jweb.p.a101.model.Content;

@WebServlet(name="/AddContentController", urlPatterns = "/addContent")
public class AddContentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public AddContentController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Content content= new Content();
		request.setCharacterEncoding("UTF-8");
		if(ContentDAO.insertContent(request)) {
			request.setAttribute("msg", "Thêm thành công");
			RequestDispatcher rd = request.getRequestDispatcher("AddContent.jsp");
			rd.forward(request, response);
		}
			
	}

}
