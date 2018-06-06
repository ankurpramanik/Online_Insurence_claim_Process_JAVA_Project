package com.pailan.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pailan.dao.PatientDao;
import com.pailan.dto.Description;
import com.pailan.dto.ErrorMsg;
import com.pailan.dto.PatientName;

/**
 * Servlet implementation class AmountServlet
 */
@WebServlet("/AmountServlet")
public class AmountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		{
			if (request.getSession().getAttribute("user") == null) {
				String errorMessage = "Session Expired! Please login again";
				ErrorMsg errorMsg = new ErrorMsg();
				errorMsg.setErrorMessage(errorMessage);
				request.setAttribute("myErrorMsg", errorMsg);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			} else {
				int description_id = Integer.parseInt(request.getParameter("description"));
				String patientName = request.getParameter("patientName");

				Description description = PatientDao.getFullDescription(description_id);
				PatientName name = new PatientName();
				name.setPatientName(patientName);
				request.setAttribute("mydescription", description);

				request.setAttribute("patientname", name);
				request.getRequestDispatcher("approval.jsp").forward(request, response);

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

	public String getServletInfo() {
		return "Short description";
	}
}
