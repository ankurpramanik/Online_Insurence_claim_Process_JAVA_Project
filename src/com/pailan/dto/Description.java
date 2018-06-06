package com.pailan.dto;

public class Description {

	private int description_id;
	/**
	 * @return the description_id
	 */
	public int getDescription_id() {
		return description_id;
	}
	/**
	 * @param description_id the description_id to set
	 */
	public void setDescription_id(int description_id) {
		this.description_id = description_id;
	}
	/**
	 * @return the description_name
	 */
	public String getDescription_name() {
		return description_name;
	}
	/**
	 * @param description_name the description_name to set
	 */
	public void setDescription_name(String description_name) {
		this.description_name = description_name;
	}
	/**
	 * @return the description_amount
	 */
	public int getDescription_amount() {
		return description_amount;
	}
	/**
	 * @param description_amount the description_amount to set
	 */
	public void setDescription_amount(int description_amount) {
		this.description_amount = description_amount;
	}
	private String description_name;
	private int description_amount;

}
