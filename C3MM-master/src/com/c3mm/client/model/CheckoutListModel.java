package com.c3mm.client.model;

import java.util.HashMap;

public class CheckoutListModel 
{
	private String username;	//Username associated with this checkout list
	private String title1;
	private String title2;
	private String title3;
	private String dueDate1;
	private String dueDate2;
	private String dueDate3;
	
	private int numItems;
	private boolean limitReached;
	
	private String fines;
	
	public CheckoutListModel()
	{
		this.username = "";
		
		this.title1 = "";
		this.dueDate1 = "";
		
		this.title2 = "";
		this.dueDate2 = "";
		
		this.title3 = "";
		this.dueDate3 = "";
		
		this.numItems = 0;
		
		this.limitReached = false;
		
		this.fines = "0.0";
	}
	
	public CheckoutListModel(String username)
	{
		this.username = username;
		
		this.title1 = "";
		this.dueDate1 = "";
		
		this.title2 = "";
		this.dueDate2 = "";
		
		this.title3 = "";
		this.dueDate3 = "";
		
		this.numItems = 0;
		
		this.limitReached = false;
		
		this.fines = "0.0";
	}
	
	public CheckoutListModel(String username, String item1, String item2, String item3,String dueDate1, String dueDate2, String dueDate3, String fines)
	{
		this.username = username;
		
		this.title1 = item1;
		this.dueDate1 = dueDate1;
		
		this.title2 = item2;
		this.dueDate2 = dueDate2;
		
		this.title3 = item3;
		this.dueDate3 = dueDate3; 
		
		this.numItems = 3;
		
		this.limitReached = true;
		
		this.fines = fines;
	}
	
	public boolean addItem(String item, String dueDate)
	{
		if(numItems == 0)
		{
			this.title1 = item;
			this.dueDate1 = dueDate;
			limitReached = false;
			numItems++;
		}
		else if(numItems == 1)
		{
			this.title2 = item;
			this.dueDate2 = dueDate;
			limitReached = false;
			numItems++;
		}
		else if(numItems == 2)
		{
			this.title3 = item;
			this.dueDate3 = dueDate;
			limitReached = true;
			numItems++;
		}
		
		return limitReached;
	}
	
	public HashMap<String, String> getProperties()
	{
		HashMap<String, String> props = new HashMap<String, String>();
		props.put(Props.USERNAME, this.getUsername() );
		props.put("title1", this.getTitle(1));
		props.put("title2",this.getTitle(2) );
		props.put("title3",this.getTitle(3) );
		props.put("due_date1", dueDate1 );
		props.put("due_date2", dueDate2 );
		props.put("due_date3", dueDate3 );
		props.put("fines", fines );
		
		return props;
	}

	public String getTitle(int num) 
	{
		String ret = "";
		
		if(num == 1)
		{
			ret = title1;
		}
		else if(num == 2)
		{
			ret = title2;
		}
		else if(num == 3)
		{
			ret = title3;
		}
		
		return ret;
	}

	private String getUsername() 
	{
		return username;
	}
}
