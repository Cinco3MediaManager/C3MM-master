//JW
package com.c3mm.client.model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import com.c3mm.client.model.Props.Comms;

public class CheckoutList
{
	private static final int MAX_ITEMS = 3;
	private int numCheckedOut;
	private FileWriter fileWriter;
	private String fileName;
	private AbstractMediaModel[] items;
	private String[] itemNames;

	public CheckoutList()
	{
		try 
		{
			//Preferable to call CheckoutList(String username) because, file name of checkout list will be unique
			fileWriter = new FileWriter("Checkout_List.txt", true);
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		items = new AbstractMediaModel[MAX_ITEMS];
		itemNames = new String[MAX_ITEMS];
		numCheckedOut = 0;
	}
	
	public CheckoutList(String userName)
	{
		try 
		{
			//Important: userName is unique, so filename will be also. filename = userName_checkout_list.txt
			fileWriter = new FileWriter("checkout_lists/" + userName + "_checkout_list.txt", true);
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		items = new AbstractMediaModel[MAX_ITEMS];
		itemNames = new String[MAX_ITEMS];
		numCheckedOut = 0;
	}
	
	public int addToCheckoutList(AbstractMediaModel item)
	{
		int successful = 0;
		
		if(numCheckedOut < MAX_ITEMS)
		{
			items[numCheckedOut] = item;	//Store the item in array

			numCheckedOut++;				//Increment number of items checked-out
			
			successful = 1;					//Set successful to 1 (true)
			writeToFile(item);				//Write the item to the file
		}
		else
		{
			System.out.println("Cannot checkout anymore books");
			successful = 0;
		}
		
		return(successful);
	}
	
	
	//Test
	public int addToCheckoutList(String itemName)
	{
		int successful = 0;
		
		if(numCheckedOut < MAX_ITEMS)
		{
			itemNames[numCheckedOut] = itemName;	//Store the item in array

			numCheckedOut++;				//Increment number of items checked-out
			
			successful = 1;					//Set successful to 1 (true)
			writeToFile(itemName);				//Write the item to the file
		}
		else
		{
			System.out.println("Cannot checkout anymore books");
			successful = 0;
		}
		
		return(successful);
	}
	
	private void writeToFile(String itemName)
	{
		try
		{
			fileWriter.write("Item # " + itemName + " is checked out by User: \n");
			fileWriter.flush();
		}
		catch(IOException e)
		{
			System.out.println("Error adding to checkout list");
		}
	}
	
	private void writeToFile(AbstractMediaModel item)
	{
		try
		{
			HashMap<String, String> properties = null;
			if(item instanceof BookModel)
			{
				properties = ((BookModel) item).getProperties();
				fileWriter.write("Item #" + numCheckedOut + "\n" + 
								  properties.get(Props.ID) + Comms.DELIM + 
								  properties.get(Props.TITLE) + Comms.DELIM +
								  properties.get(Props.AUTHOR) + Comms.DELIM  + 
								  properties.get(Props.STOCK) + Comms.DELIM + 
								  properties.get(Props.DATE) + Comms.DELIM  + 
								  properties.get(Props.COUNTRY) + Comms.DELIM  + 
								  properties.get(Props.TYPE) + Comms.DELIM  + 
								  properties.get(Props.LANG) + "\n"
								);
			}
			else if(item instanceof CDModel)
			{
				properties = ((CDModel) item).getProperties();
				fileWriter.write("Item #" + numCheckedOut + "\n" + 
								  properties.get(Props.ID) + Comms.DELIM + 
								  properties.get(Props.STOCK) + Comms.DELIM +
								  properties.get(Props.TITLE) + Comms.DELIM  + 
								  properties.get(Props.COUNTRY) + Comms.DELIM + 
								  properties.get(Props.TYPE) + Comms.DELIM  + 
								  properties.get(Props.LANG) + Comms.DELIM  + 
								  properties.get(Props.ARTIST) + Comms.DELIM  + 
								  properties.get(Props.YEAR) + "\n"
								);
			}
			else if(item instanceof MovieModel)
			{
				properties = ((MovieModel) item).getProperties();
				fileWriter.write("Item #" + numCheckedOut + "\n" + 
								  properties.get(Props.ID) + Comms.DELIM + 
								  properties.get(Props.STOCK) + Comms.DELIM +
								  properties.get(Props.TITLE) + Comms.DELIM  + 
								  properties.get(Props.COUNTRY) + Comms.DELIM + 
								  properties.get(Props.TYPE) + Comms.DELIM  + 
								  properties.get(Props.LANG) + Comms.DELIM  + 
								  properties.get(Props.DIRECTOR) + Comms.DELIM  + 
								  properties.get(Props.YEAR) + "\n"
								);
			}
			
			fileWriter.flush();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int getNumCheckedOut()
	{
		return numCheckedOut;
	}
}
