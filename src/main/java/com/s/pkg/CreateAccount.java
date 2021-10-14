package com.s.pkg;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CreateAccount
 */
@WebServlet("/CreateAccount")
public class CreateAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateAccount() {
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
		System.out.println("POST method entered");
		String emailId = request.getParameter("emailId");
		String password = request.getParameter("password");
		String accountId = generateAccountId();
		System.out.println("account id generated = "+accountId);
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		double balance = Double.parseDouble(request.getParameter("balance"));

		Account acc = new Account(firstName, lastName, password, accountId, emailId, balance);
		System.out.println("Account object done");
		AccountService accountService = new AccountService();
		accountService.createAccount(acc);
		HttpSession session = request.getSession();
		session.setAttribute("isVerified", "true");
		session.setAttribute("firstName", firstName);
		session.setAttribute("lastName", lastName);
		session.setAttribute("emailId", emailId);
		session.setAttribute("accountId", accountId);
		session.setAttribute("balance", balance);

		response.sendRedirect("welcome.jsp");
	}
	
	public String generateAccountId() {
  	   	String string = "0123456789";	  
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int index = (int) (string.length()* Math.random());
            sb.append(string.charAt(index));
        }
        return sb.toString();
}

}
