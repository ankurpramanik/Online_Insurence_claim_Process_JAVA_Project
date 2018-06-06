package com.pailan.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pailan.dao.UserDao;
import com.pailan.dto.Answer;
import com.pailan.dto.ErrorMsg;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(value="/LoginServlet" )
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean validated = false;
		boolean result = true;

		String userName = request.getParameter("username");
		String password = request.getParameter("password");

		validated = UserDao.validateUser(userName, password);

		if (validated) {
			Answer getAnswer = new Answer();
			getAnswer.setResult(result);

			request.setAttribute("getAnswer", getAnswer);
			ArrayList menuList = UserDao.getMenues(userName);

			request.getSession().setAttribute("myMenuList", menuList);
			request.getSession().setAttribute("user", userName);
			request.getRequestDispatcher("homepage.jsp").forward(request, response);
		} else {
			String errorMessage = "Either user name or password is wrong";
			ErrorMsg errorMsg = new ErrorMsg();
			errorMsg.setErrorMessage(errorMessage);
			request.setAttribute("myErrorMsg", errorMsg);
			request.getRequestDispatcher("login.jsp").forward(request, response);
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
