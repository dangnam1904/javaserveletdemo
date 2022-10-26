package jweb.p.a101.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jweb.p.a101.dao.ContentDAO;
import jweb.p.a101.model.Content;


@WebServlet(name="/UpdateContentController", urlPatterns = "/update")
public class UpdateContentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public UpdateContentController() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id= Integer.parseInt(request.getParameter("id"));
		
		Content content= ContentDAO.getDataContentById(id);
		request.setAttribute("c", content);
		request.getRequestDispatcher("UpdateContent.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ContentDAO.updateContent(request);
		response.sendRedirect("viewContent");
	}
}
