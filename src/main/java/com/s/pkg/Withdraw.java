package com.s.pkg;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Withdraw
 */
@WebServlet("/Withdraw")
public class Withdraw extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Withdraw() {
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
		double withdrawAmount = Double.parseDouble(request.getParameter("withdrawAmount"));
		System.out.println("amount withdraw = " + withdrawAmount);
		
		AccountService accountService = new AccountService();
		HttpSession session = request.getSession();
		String accountId = (String) session.getAttribute("accountId");
		int res = accountService.withdraw(accountId, withdrawAmount);
		Account acc = null;
		if (res > 0)
		{
			acc = accountService.getAccountByAccountId(accountId);
			session.setAttribute("firstName", acc.getFirstName());
			session.setAttribute("lastName", acc.getLastName());
			session.setAttribute("emailId", acc.getEmailId());
			session.setAttribute("accountId", acc.getAccountId());
			session.setAttribute("balance", acc.getBalance());
			
			session.setAttribute("status", "Withdrawn Successfully");
		    response.sendRedirect("welcome2.jsp");
		}else{
		    session.setAttribute("status", "Failed to Withdraw");
		    response.sendRedirect("welcome2.jsp");
		}
	}

}
