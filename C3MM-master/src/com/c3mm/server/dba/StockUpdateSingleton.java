package com.c3mm.server.dba;

import java.sql.SQLException;

/*"Singleton" pattern class for updating the "in_stock" field in media database
* Needs to be called after a user submits their checkout list.
* Uses double-checked locking to prevent multiple thread access */
public class StockUpdateSingleton 
{
	private static StockUpdateSingleton stockUpdater;
	    
	private StockUpdateSingleton()
	{
	    System.out.println("Instance of StockUpdateSingleton Created");	
	}
	    
	public static StockUpdateSingleton getStockUpdater()
	{	
		//Double-checked access
		if(stockUpdater == null)	//Check 1: If the instance does not exist...
		{
			synchronized (StockUpdateSingleton.class)	//Locked access
			{
				if(stockUpdater == null)	//Check 2: If the instance does not exist...
				{
					stockUpdater = new StockUpdateSingleton();	//Create an instance
				}
			}
	    }   
		//If check 1 or check 2 fail, then an instance already exists. 
		return stockUpdater;	//Return the instance
	}
	
	//Instance method to perform updates to the "in_stock" field of the media table in c3db.db
	public void updateStock(String sql, String value, String id) throws SQLException
	{
		C3DBA c3dba = new C3DBA();
		c3dba.stockUpdate(sql, value, id);
	}
}
