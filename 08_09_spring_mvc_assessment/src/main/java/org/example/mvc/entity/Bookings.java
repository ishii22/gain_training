package org.example.mvc.entity;

public class Bookings {
	private String bookingId;
	private String flightId;
	private String passengerId;
	private String date;
	public Bookings() {}
	public Bookings(String bookingId,String flightId,String passengerId,String date) {
		this.setBookingId(bookingId);
		this.setFlightId(flightId);
		this.setPassengerId(passengerId);
		this.setDate(date);
		
	}
	public String getBookingId() {
		return bookingId;
	}
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
	public String getFlightId() {
		return flightId;
	}
	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}
	public String getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(String passengerId) {
		this.passengerId = passengerId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

}
