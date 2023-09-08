package org.example.mvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.example.mvc.entity.Bookings;
import org.example.mvc.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public class BookingDAO {
	
	private static String url = "jdbc:mysql://localhost:3306/gainsight";
	
	public boolean addBookingDetails(Bookings booking) {
		int count = 0;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,"root","G@1nsight");
			pst = con.prepareStatement("insert into bookings values(?,?,?,?)");
			pst.setString(1, booking.getBookingId());
			pst.setString(2, booking.getFlightId());
			pst.setString(3, booking.getPassengerId());
			pst.setString(4, booking.getDate());
			
			count = pst.executeUpdate();
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			try {
				if(rs!=null) rs.close();
				if(pst!=null) pst.close();
				if(con!=null) con.close();
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		return count == 1;
	}
	public Bookings getBookingByBookingId(String bookingId) {
		Bookings booking = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,"root","G@1nsight");
			pst = con.prepareStatement("select * from bookings where booking_id=?");
			pst.setString(1, bookingId);
			rs = pst.executeQuery();
			if(rs.next())
				booking = new Bookings(rs.getNString(1),rs.getNString(2),rs.getNString(3),rs.getNString(4));
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			try {
				if(rs!=null) rs.close();
				if(pst!=null) pst.close();
				if(con!=null) con.close();
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		return booking;
		
	}

}
