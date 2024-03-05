package com.bgss.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bgss.model.LoginModel;
import com.bgss.service.LoginService;


/**
 * Servlet implementation class LoginHomeController
 */
@WebServlet("/LoginHomeController")
public class LoginHomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String homemain = "homemain.jsp";
	private static final String login = "login.jsp";
	private static final String home = "home.jsp";
	private static final String VIEW_MAIN_PAGE = "gas-booking.jsp";

	RequestDispatcher requestDispatcher = null;

	public LoginHomeController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equals("cancel")) {
			response.sendRedirect("home.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String navigation = "";

		String username = request.getParameter("uname");
		String password = request.getParameter("psw");

		LoginModel beenLogin = new LoginModel();
		beenLogin.setUsername(username);
		beenLogin.setPassword(password);

		LoginService loginCheck = new LoginService();

		String result = loginCheck.check(beenLogin);

		if (result.equals("success")) {
			int loginId = loginCheck.getUserId(beenLogin);
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			String check = (String) session.getAttribute("username");
			if (check != null) {
				request.setAttribute("loginId", loginId);
				navigation = VIEW_MAIN_PAGE;
			} else {
				requestDispatcher = request.getRequestDispatcher(login);
			}
		} else {
			request.setAttribute("msg", "Enter Valid Username/Password");
			navigation = login;
		}
		requestDispatcher = request.getRequestDispatcher(navigation);
		requestDispatcher.forward(request, response);

	}

}
