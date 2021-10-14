package com.s.pkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AccountServlet
 */
@WebServlet("/AccountServlet")
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Map<String, Account> accountsDatabase = new HashMap<>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountServlet() {
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
		// TODO Auto-generated method stub
		
		String emailId = request.getParameter("emailId");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();

		
		AccountService accountService = new AccountService();
		String res = accountService.verifyAccountCredentials(emailId, password);
		System.out.println(res);
		if (res.equals("Incorrect username and/or pwd")) {
//			response.getWriter().write("Incorrect username / pwd!");
//			session.setAttribute("incorrectUsernamePwd", "true");
//			System.out.println("incorrect-----");
			response.sendRedirect("signin.jsp");
		} else {
			session.setAttribute("isVerified", "true");
			
			Account acc = accountService.getAccountByEmailId(emailId);
			session.setAttribute("firstName", acc.getFirstName());
			session.setAttribute("lastName", acc.getLastName());
			session.setAttribute("emailId", acc.getEmailId());
			session.setAttribute("accountId", acc.getAccountId());
			session.setAttribute("balance", acc.getBalance());

			response.sendRedirect("welcome.jsp");
		}
	}
	

}
