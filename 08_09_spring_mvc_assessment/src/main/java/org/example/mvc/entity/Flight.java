package org.example.mvc.entity;

public class Flight {
	private String flightId;
	private String source;
	private String destination;
	private double fare;
	private int seatAvailable;
	public Flight() {}
	public Flight(String flightId,String source, String destination,double fare, int seatAvailable) {
		this.flightId=flightId;
		this.source=source;
		this.destination=destination;
		this.fare=fare;
		this.seatAvailable=seatAvailable;
	}
	public String getFlightId() {
		return flightId;
	}
	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
	public int getSeatAvailable() {
		return seatAvailable;
	}
	public void setSeatAvailable(int seatAvailable) {
		this.seatAvailable = seatAvailable;
	}
	

}
