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
 * Servlet implementation class Approve
 */
@WebServlet("/Approve")
public class Approve extends HttpServlet {
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

			boolean resp;
			int Id = Integer.parseInt(request.getParameter("pId"));
			String Name = (request.getParameter("pName"));

			PatientsDetails patient = PatientDao.updatePatient(Id, Name);
			resp = PatientDao.savePatient(patient);

			request.setAttribute("updatepatient", patient);

			request.getRequestDispatcher("continue.jsp").forward(request, response);
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
