package com.c3mm.client.view;

//package net.sqliteconnection.view;

import java.util.Map;

public class UserView {
	public void createAccount(Map<String,String[]> userDataBase,String userName, String[] userInformation) {
		userDataBase.put(userName, userInformation);
		System.out.println("Account created successfully");
		for (int i=0;i<6; i++) {
		System.out.println(userDataBase.get(userName)[i]);
		}
	}
}