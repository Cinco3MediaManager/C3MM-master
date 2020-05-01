package com.c3mm.client.controller;

//package net.sqliteconnection.controller;

import com.c3mm.client.model.Admin;
import com.c3mm.client.view.AdminView;

public class AdminController {
	private Admin model;
	private AdminView view;
	
	public AdminController(Admin model, AdminView view) {
		this.model = model;
		this.view = view;
	}
	
	public int getAdminID() {
		return model.getID();
	}
	
	public void setAdminID(int adminID) {
		model.setID(adminID);
	}
	
	public String getAdminUsername() {
		return model.getUsername();
	}
	
	public void setAdminUserName(String adminUsername) {
		model.setUsername(adminUsername);
	}
	
	public String getAdminPassword() {
		return model.getPassword();
	}
	
	public void setAdminPassword(String adminPassword) {
		model.setPassword(adminPassword);
	}
}