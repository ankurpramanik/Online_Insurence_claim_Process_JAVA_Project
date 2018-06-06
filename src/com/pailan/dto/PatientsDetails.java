package com.pailan.dto;

public class PatientsDetails {
	private int smartCard;
	private String name;
	private String contact;
	private String email;
	private double amount = 0.0;
	private double claim = 0.0;
	private double balance = 500000;
	/**
	 * @return the smartCard
	 */
	public int getSmartCard() {
		return smartCard;
	}
	/**
	 * @param smartCard the smartCard to set
	 */
	public void setSmartCard(int smartCard) {
		this.smartCard = smartCard;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the contact
	 */
	public String getContact() {
		return contact;
	}
	/**
	 * @param contact the contact to set
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}
	/**
	 * @return the claim
	 */
	public double getClaim() {
		return claim;
	}
	/**
	 * @param claim the claim to set
	 */
	public void setClaim(double claim) {
		this.claim = claim;
	}
	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}
	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}
}
