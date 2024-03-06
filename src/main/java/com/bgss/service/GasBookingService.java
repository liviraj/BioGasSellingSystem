package com.bgss.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bgss.connection.DbConnection;
import com.bgss.model.Booking;


public class GasBookingService {
	Connection con = null;
	Statement st = null;
	ResultSet rs = null;

	public int insertBooking(Booking booking) {
		int status = 0;
		try {
			con = DbConnection.getConnection();
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement("insert into gasbooking(customerNumber,gasType,serviceProvider,address1,address2,city,pincode,contactNo) values(?,?,?,?,?,?,?,?)");
			ps.setString(1, booking.getCustomerNumber());
			ps.setString(2, booking.getGasType());
			ps.setString(3, booking.getServiceProvider());
			ps.setString(4, booking.getAddress1());
			ps.setString(5, booking.getAddress2());
			ps.setString(6, booking.getCity());
			ps.setString(7, booking.getPincode());
			ps.setString(8, booking.getContactNo());

			status = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public List<Booking> getBookingHistory() {
		List<Booking> details = new ArrayList<Booking>();
		try {
			con = DbConnection.getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(
					"select * from gasbooking;");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Booking model = new Booking();
				model.setCustomerNumber(rs.getString("customerNumber"));
				model.setGasType(rs.getString("gasType"));
				model.setServiceProvider(rs.getString("serviceProvider"));
				model.setAddress1(rs.getString("address1"));
				model.setAddress2(rs.getString("address2"));
				model.setCity(rs.getString("city"));
				model.setPincode(rs.getString("pincode"));
				model.setContactNo(rs.getString("contactNo"));
				model.setBookingId(rs.getInt("bookingId"));

				details.add(model);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return details;
	}
}
