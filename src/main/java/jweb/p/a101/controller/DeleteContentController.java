package jweb.p.a101.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jweb.p.a101.dao.ContentDAO;


@WebServlet(name="/DeleteContentController", urlPatterns = "/delete")
public class DeleteContentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteContentController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id= Integer.parseInt(request.getParameter("id"));
		ContentDAO.deleteContent(id);
		response.sendRedirect("viewContent");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
