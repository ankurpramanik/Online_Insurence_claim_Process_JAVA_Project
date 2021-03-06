package com.pailan.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pailan.dto.ErrorMsg;

/**
 * Servlet implementation class ShowRegistrationPage
 */
@WebServlet("/ShowRegistrationPage")
public class ShowRegistrationPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getSession().getAttribute("user") == null) {
			String errorMessage = "Session Expired! Please login again";
			ErrorMsg errorMsg = new ErrorMsg();
			errorMsg.setErrorMessage(errorMessage);
			request.setAttribute("myErrorMsg", errorMsg);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {

			request.getRequestDispatcher("registration.jsp").forward(request, response);
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

}
