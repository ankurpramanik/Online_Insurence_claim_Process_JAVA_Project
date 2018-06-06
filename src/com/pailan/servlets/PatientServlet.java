package com.pailan.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pailan.dao.PatientDao;
import com.pailan.dto.Answer;
import com.pailan.dto.Answerr;
import com.pailan.dto.ErrorMsg;
import com.pailan.dto.PatientsDetails;

/**
 * Servlet implementation class PatientServlet
 */
@WebServlet("/PatientServlet")
public class PatientServlet extends HttpServlet {
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

			boolean validated = true;
			boolean result = false;

			int smartcard = Integer.parseInt(request.getParameter("smartcard"));
			PatientsDetails patient = PatientDao.getPatient(smartcard);
			Answer answer = new Answer();
			answer.setResult(result);

			request.setAttribute("answer", answer);
			request.setAttribute("patient", patient);
			Answerr getAnswerr = new Answerr();
			getAnswerr.setResult(validated);
			request.setAttribute("myAnswerr", getAnswerr);
			ArrayList description_id = PatientDao.getDescriptions();
			request.setAttribute("mydescription_id", description_id);

			request.getRequestDispatcher("homepage.jsp").forward(request, response);
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
