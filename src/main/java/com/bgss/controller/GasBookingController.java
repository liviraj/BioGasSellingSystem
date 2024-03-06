package com.bgss.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bgss.model.Booking;
import com.bgss.service.GasBookingService;


@WebServlet("/GasBookingController")
public class GasBookingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String LOGIN = "login.jsp";
	private static final String GAS_BOOKING_PAGE = "gas-booking.jsp";
	private static final String GAS_BOOKING_HISTORY = "gas-booking-history.jsp";
	RequestDispatcher requestDispatcher = null;

	public GasBookingController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String check = (String) session.getAttribute("username");
		String action = request.getParameter("action");
		String navigation = "";
		
		if(action.equals("bookingHistory")) {
			GasBookingService bookingService = new GasBookingService();
			List<Booking> bookingHistory = bookingService.getBookingHistory();
			request.setAttribute("details", bookingHistory);
			navigation = GAS_BOOKING_HISTORY;
		}
		requestDispatcher = request.getRequestDispatcher(navigation);
		requestDispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String action = request.getParameter("submit");
		
		if (action.equals("Book Now")) {
			Booking booking = new Booking();
			
			String customerNumber = request.getParameter("customerNumber");
			String gasType = request.getParameter("gasType");
			String serviceProvider = request.getParameter("serviceProvider");
			String address1 = request.getParameter("address1");
			String address2 = request.getParameter("address2");
			String city = request.getParameter("city");
			String pincode = request.getParameter("pincode");
			String contactNo = request.getParameter("contactNo");
			
			booking.setCustomerNumber(customerNumber);
			booking.setCustomerNumber(gasType);
			booking.setServiceProvider(serviceProvider);
			booking.setAddress1(address1);
			booking.setAddress2(address2);
			booking.setCity(city);
			booking.setPincode(pincode);
			booking.setContactNo(contactNo);
			
			GasBookingService service = new GasBookingService();
			int insertBooking = service.insertBooking(booking);
			if (insertBooking > 0) {
				List<Booking> bookingHistory = service.getBookingHistory();
				request.setAttribute("msg", "Requeted gas booked successfully!!!");
				request.setAttribute("details", bookingHistory);
				requestDispatcher = request.getRequestDispatcher(GAS_BOOKING_HISTORY);
			}
		}
		requestDispatcher.forward(request, response);
	}
}
