package com.s.pkg;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete() {
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
		
		HttpSession session = request.getSession();
		String accountId = (String) session.getAttribute("accountId");
		String firstName = (String) session.getAttribute("firstName");
		String lastName = (String) session.getAttribute("lastName");

		AccountService accountService = new AccountService();
		int res = accountService.deleteAccount(accountId);
		if (res == 1) {
			session.removeAttribute("firstName");
			session.removeAttribute("lastName");
			session.removeAttribute("accountId");
			session.removeAttribute("emailId");
			session.removeAttribute("balance");
			
			session.invalidate();
			
			HttpSession session1 = request.getSession();
			session1.setAttribute("pseudoAccountId", accountId);
			session1.setAttribute("pseudofirstName", firstName);
			session1.setAttribute("pseudoLastName", lastName);
			
			response.sendRedirect("delete.jsp");
			
			
		}
	}

}
