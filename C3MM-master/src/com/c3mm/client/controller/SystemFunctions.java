package com.c3mm.client.controller;

import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.c3mm.client.model.AbstractMediaModel;
import com.c3mm.client.model.C3Client;
import com.c3mm.client.model.Props.Log;
import com.c3mm.client.model.User;

public class SystemFunctions 
{
	public static String hashPassword(String password)
	{
		String hashedPassword = "";

		try 
		{
			MessageDigest md = MessageDigest.getInstance("SHA-1"); 

			byte[] messageDigest = md.digest(password.getBytes()); 
			 
			BigInteger no = new BigInteger(1, messageDigest); 
	  
	        String hash = no.toString(16); 
	  
	 		System.out.println("Hashed password is: " + hash);
	 		
	 		while (hash.length() < 32) 
	        { 
	 			hash = "0" + hash; 
	        } 
	        
	 		hashedPassword = hash;
	 		
		}
		catch (NoSuchAlgorithmException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hashedPassword;
	}
	
	public static boolean verifyLogin(String username, String password, C3Client client)
	{
		boolean valid = false;
		
		try
		{
			User user = client.getUser("username", username);
			String hashPassword = SystemFunctions.hashPassword(password);
		
			if(user.getPassword().equals(hashPassword))
			{
				valid = true;
			}
		}
		catch(NullPointerException e)
		{
			
		}
		
		return valid;
	}
	
	public static void writeToClientLog(String message)
	{
		/*The logs written here will be available for administrators to view through the Administrator UI.
		 *To Do: Create Administrator UI
		*/
		FileWriter fileWriter = null;
		try
		{
			SimpleDateFormat hms = new SimpleDateFormat("hh:mm:ss");		//hms stands for hour, minute, second;the time format used
			
			String time = hms.format(new Date());	
			fileWriter = new FileWriter(Log.LOG_FILE_CLIENT, true);
			fileWriter.append(message + " at: " + time + "\n");
			fileWriter.flush();
		}
		catch(IOException e)
		{
			System.out.println("Problem writing to log file");
		}
		finally
		{
			try 
			{
				fileWriter.close();
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				System.out.println("Problem closing log file");
				e.printStackTrace();
			}
		}
	}
	
	public static void checkoutItem(AbstractMediaModel item, String username)
	{
		try 
		{
			FileWriter fileWriter = new FileWriter(username + "_checkout_list.txt", true);
			
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
