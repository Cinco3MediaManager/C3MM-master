package com.c3mm.client.model;

//package net.sqliteconnection.model;
import java.util.HashMap;

public class User 
{
	//Declare Class Fields
	private static final int NUM_FIELDS = 7;
	
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private String address;
	private String email;
	private String type;
	
	private String[] information;
	
	
	private HashMap<String, String[]> dataBase;
	
	private HashMap<String, String> properties;
	
	private CheckoutList checkoutList;
	
	//No-Arg constructor
	public User()
	{
		//Initialize fields to default
		userName = "";
		password = "";
		firstName = "";
		lastName = "";
		address = "";
		email = "";
		type = "";
		
		//Create Data structures
		information = new String[NUM_FIELDS];
		dataBase = new HashMap<String, String[]>();
		checkoutList = new CheckoutList(userName);
	
		//Populate array
		populateInfoArray();
	}
	
	//"Complete" constructor to set all fields at creation
	public User(String userName, String password, String firstName, String lastName, String address, String email, String type)
	{
		//Initialize fields to specified values
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = email;
		this.type = type;
		
		//Create Data Structures
		information = new String[NUM_FIELDS];
		dataBase = new HashMap<String, String[]>();
		checkoutList = new CheckoutList(this.userName);

		//Testing
		System.out.println("Inside User full field constructor");
		//Populate array
		populateInfoArray();
	}
	
	//Username Get/Set pair
	public void setUsername(String userName) 
	{
		this.userName = userName;
	}
	
	public String getUsername() 
	{
		return userName;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	/*
	 * If time, other field-specific accessors and mutators should be added so that fields can be set/returned individually if needed
	 */
	
	public String[] getInformation() 
	{
		return information;
	}
	
	public CheckoutList getCheckoutList()
	{
		return checkoutList;
	}

	private void populateInfoArray()
	{
		//Populate array elements
		information[0] = userName;
		information[1] = password;
		information[2] = firstName;
		information[3] = lastName;
		information[4] = address;
		information[5] = email;
		information[6] = type;
		
		//Assign the array "information" to Hash Map dataBase; 
		storeDataBase(userName, information);
	}
	
	public void setInformation(String userName, String password, String firstName, String lastName, String address, String email, String type)
	{
		//Set fields
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = email;
		this.type = type;
		
		
		System.out.println("Inside User setInformation(all fields)");
		checkoutList = new CheckoutList(this.userName);
		//Populate array with the new values
		populateInfoArray();
	}

	public HashMap<String, String[]> getDatabase()
	{
		return dataBase;
	}
	
	public HashMap<String, String> getProperties()
	{
		properties = new HashMap<String, String>();
		properties.put(Props.USERNAME, userName);
		properties.put(Props.PASSWORD, password);
		properties.put(Props.FIRSTNAME, firstName);
		properties.put(Props.LASTNAME, lastName);
		properties.put(Props.ADDRESS, address);
		properties.put(Props.EMAIL, email);
		properties.put(Props.TYPE, type);
		
		return properties;
	}
	
	public void storeDataBase(String userName, String[] information)
	{
		this.dataBase.put(userName, information);
	}
}