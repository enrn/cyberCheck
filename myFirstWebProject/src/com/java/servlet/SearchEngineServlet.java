package com.java.servlet;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchEngineServlet
 */
@WebServlet("/SearchEngineServlet")
public class SearchEngineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchEngineServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String searchText = request.getParameter("search");

		if (searchText.length() == 0 || searchText == null) {

			reportProblem(response, "missing somtext");
			return;
		}
		String searchEngine = request.getParameter("name");

		if (searchEngine == null) {

			reportProblem(response, "missing search engine");
			return;
		}
		
		SearchSpec[] searchSpec=SearchSpec.getCommonSpec();
		for (SearchSpec commonurl:searchSpec) {
			
			if(commonurl.getName().equals(searchEngine)){
				
				String url=commonurl.getBaseUrl()+searchText;
				response.sendRedirect(url);
			}
			
		}

	}

	protected void reportProblem(HttpServletResponse response, String message) throws IOException {

		response.sendError(response.SC_NOT_FOUND, message);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
