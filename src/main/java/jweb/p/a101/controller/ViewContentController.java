package jweb.p.a101.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jweb.p.a101.connectdb.ConnectDB;
import jweb.p.a101.dao.ContentDAO;
import jweb.p.a101.model.Content;


@WebServlet(name="/ViewContentController",urlPatterns = {"/viewContent"})
public class ViewContentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewContentController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Content> contentList=ContentDAO.getAllContent(request);
		
		request.setAttribute("listContents", contentList);
		request.getRequestDispatcher("ViewContent.jsp").forward(request, response);
	}

}
