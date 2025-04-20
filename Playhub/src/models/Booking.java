package models;

import java.time.LocalDate;

public class Booking {

	private int id;
	private int userId;
	private int businessId;
	private String court;
	private LocalDate date;
	private String timeSlot;
	private double price;

	public Booking(int id, int userId, int businessId, String court, LocalDate date, String timeSlot, double price) {
		this.id = id;
		this.userId = userId;
		this.businessId = businessId;
		this.court = court;
		this.date = date;
		this.timeSlot = timeSlot;
		this.price = price;
	}

	// Constructor with no ID
	public Booking(int userId, int businessId, String court, LocalDate date, String timeSlot, double price) {
		this.userId = userId;
		this.businessId = businessId;
		this.court = court;
		this.date = date;
		this.timeSlot = timeSlot;
		this.price = price;
	}

	// Getters & Setters
	public int getId() {
		return id;
	}

	public int getUserId() {
		return userId;
	}

	public int getBusinessId() {
		return businessId;
	}

	public String getCourt() {
		return court;
	}

	public LocalDate getDate() {
		return date;
	}

	public String getTimeSlot() {
		return timeSlot;
	}

	public double getPrice() {
		return price;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setBusinessId(int businessId) {
		this.businessId = businessId;
	}

	public void setCourt(String court) {
		this.court = court;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public void setTimeSlot(String timeSlot) {
		this.timeSlot = timeSlot;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
