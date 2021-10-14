package com.s.pkg;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Transfer
 */
@WebServlet("/Transfer")
public class Transfer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Transfer() {
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
		
		double transferAmount = Double.parseDouble(request.getParameter("transferAmount"));
		String destinationAccountId = request.getParameter("transferAccountId");
		HttpSession session = request.getSession();
		String sourceAccountId = (String) session.getAttribute("accountId");
		
		AccountService accountService = new AccountService();
		int res = accountService.transfer(sourceAccountId, destinationAccountId, transferAmount);
		Account acc = null;
		if (res > 0)
		{
			acc = accountService.getAccountByAccountId(sourceAccountId);
			session.setAttribute("firstName", acc.getFirstName());
			session.setAttribute("lastName", acc.getLastName());
			session.setAttribute("emailId", acc.getEmailId());
			session.setAttribute("accountId", acc.getAccountId());
			session.setAttribute("balance", acc.getBalance());
			
			session.setAttribute("status", "Transferred Successfully");
		    response.sendRedirect("welcome2.jsp");
		}else{
			System.out.println("fail----");
		    session.setAttribute("status", "Failed to transfer");
		    response.sendRedirect("welcome2.jsp");
		}
		
	}

}
