package com.c3mm.server.dba;

import java.sql.SQLException;
import java.util.Vector;

import com.c3mm.client.model.Props.Comms;

public class DBAProtocol
{
	private static final int WAITING = 0;
	private static final int TRY_QUERY = 1;
	private static final int QUERY_DONE = 2;
	
	private static final String CONNECTING = "Connecting to server...";
	
	private int state = WAITING; // we always start waiting
	
	private Vector<String> results = new Vector<String>();
	
	public String processInput(String theInputs)
	{
		String theOutput = "";
		String[] args = null;
		
		String queryType = "";
		String sql = "";
		String value = "";
		
		if (state == WAITING)
		{
			theOutput = CONNECTING;
			state = TRY_QUERY;
		}
		else if (state == TRY_QUERY)
		{
			C3DBA query = new C3DBA();
			
			String recId = "";
			
			if (theInputs != null)
			{
				args = theInputs.split(";");	//args is a string array holding the input recieved
				queryType = args[0];			//queryType is the type of request being made
				sql = args[1];					//sql is the query. Ex: s;treasure Island --> s;
				
				switch (queryType)
				{
					case Comms.SEL:
						if (args.length > 2)
						{
							value = args[2];	//Value is the 3rd item in args. type;query;value
						}
						query.select(sql, value);
						results = query.getRows();
						
						if (results.get(0).contains(Comms.NOT_FOUND))
						{
							theOutput = results.get(0);
						}
						else
						{
							theOutput = Comms.FOUND;
						}
						break;
						
					case Comms.UPD:
						if (args.length > 3)
						{
							value = args[2];
							recId = args[3];
						}
						try
						{
							int n = query.update(sql, value, recId);
							theOutput = "Rows Updated: " + n;
						}
						catch (SQLException e)
						{
							theOutput = e.getMessage();
							e.printStackTrace();
						}
						break;
					
					case Comms.INS:
						String [] values = null;
						if(args.length == 3)
						{
							values = args[2].split("%");
						}
						try
						{
							int n = query.insert(sql, values);
							
							theOutput = "Rows Inserted: " + n;
						}
						catch (SQLException e)
						{
							theOutput = e.getMessage();
							e.printStackTrace();
						}
						break;
				}
			}
			state = QUERY_DONE;
		}
		else
		{
			theOutput = Comms.DONE;
			state = WAITING;
		}
		return theOutput;
	}
	
	public Vector<String> getResults()
	{
		return results;
	}
}
