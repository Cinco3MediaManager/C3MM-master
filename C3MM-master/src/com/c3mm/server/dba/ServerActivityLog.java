package com.c3mm.server.dba;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.c3mm.client.model.Props.Log;

public class ServerActivityLog 
{
	public static void writeToServerLog(String message)
	{
		/*The logs written here will be available for administrators to view from the Administrator UI. 
		 *To Do: Create Administrator UI
		 */
		
		FileWriter fileWriter = null;
		try
		{
			SimpleDateFormat hms = new SimpleDateFormat("hh:mm:ss");		//h = hour, m = minute, s = second. Ex: 11:02:32
			
			String time = hms.format(new Date());							//String form of time
			fileWriter = new FileWriter(Log.LOG_FILE_SERVER, true);			//File name defined in Props
			fileWriter.append(message + " at: " + time + "\n");				//Append message to log with time-stamp
			fileWriter.flush();												//Force FileWriter to write
		}
		catch(IOException e)
		{
			System.out.println("Problem writing to log file");
		}
		finally
		{
			try 
			{
				fileWriter.close();		//Close the file
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				System.out.println("Problem closing log file");
				e.printStackTrace();
			}
		}
	}
}
