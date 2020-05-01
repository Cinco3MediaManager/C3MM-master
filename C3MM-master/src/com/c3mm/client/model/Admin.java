package com.c3mm.client.model;

//package net.sqliteconnection.model;

public class Admin {
	private int adminID;
	private String adminUsername;
	private String adminPassword;
	
	public String getUsername() {
		return adminUsername;
	}
	
	public void setUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}
	
	public int getID() {
		return adminID;
	}
	
	public void setID(int adminID) {
		this.adminID = adminID;
	}
	
	public String getPassword() {
		return adminPassword;
	}
	
	public void setPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
}