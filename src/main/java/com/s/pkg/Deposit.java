package com.s.pkg;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Deposit
 */
@WebServlet("/Deposit")
public class Deposit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Deposit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("inside deposit");
		
		double depositAmount = Double.parseDouble(request.getParameter("depositAmount"));
		System.out.println("amount dep = " + depositAmount);
		
		AccountService accountService = new AccountService();
		HttpSession session = request.getSession();
		String accountId = (String) session.getAttribute("accountId");
		int res = accountService.deposit(accountId, depositAmount);
		Account acc = null;
		if (res == 1) {
			acc = accountService.getAccountByAccountId(accountId);
			session.setAttribute("firstName", acc.getFirstName());
			session.setAttribute("lastName", acc.getLastName());
			session.setAttribute("emailId", acc.getEmailId());
			session.setAttribute("accountId", acc.getAccountId());
			session.setAttribute("balance", acc.getBalance());
			
			response.sendRedirect("welcome.jsp");
		} else {
			// deposit is unsuccessful
		}
	}

}
