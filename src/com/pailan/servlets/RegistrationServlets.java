package com.pailan.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pailan.dao.PatientDao;
import com.pailan.dto.ErrorMsg;
import com.pailan.dto.PatientsDetails;

/**
 * Servlet implementation class RegistrationServlets
 */
@WebServlet("/RegistrationServlets")
public class RegistrationServlets extends HttpServlet {
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
			int smartcard = Integer.parseInt(request.getParameter("smartcard"));
			String name = request.getParameter("name");
			String contact = request.getParameter("contact");
			double amount = 0.0;
			double claim = 0.0;
			double balance = 500000;
			String email = request.getParameter("email");

			PatientsDetails patientsDetails = new PatientsDetails();
			patientsDetails.setSmartCard(smartcard);
			patientsDetails.setName(name);
			patientsDetails.setContact(contact);
			patientsDetails.setAmount(amount);
			patientsDetails.setClaim(claim);
			patientsDetails.setBalance(balance);
			patientsDetails.setEmail(email);

			boolean result = PatientDao.addPatient(patientsDetails);

			if (result) {
				String errorMessage = "Data added successfuly";
				ErrorMsg errorMsg = new ErrorMsg();
				errorMsg.setErrorMessage(errorMessage);
				request.setAttribute("myErrorMsg", errorMsg);

				request.getRequestDispatcher("HomeServlet").forward(request, response);
			} else {
				String errorMessage = "Addition failed";
				ErrorMsg errorMsg = new ErrorMsg();
				errorMsg.setErrorMessage(errorMessage);
				request.setAttribute("myErrorMsg", errorMsg);

				request.getRequestDispatcher("homepage.jsp").forward(request, response);
			}
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
