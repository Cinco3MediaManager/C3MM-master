package com.c3mm.server.dba;

import java.sql.SQLException;

/*"Singleton" pattern class for updating the "in_stock" field in media database
* Needs to be called after a user submits their checkout list.
* Uses double locking to prevent multiple thread access */
public class StockUpdateSingleton 
{
	private static StockUpdateSingleton stockUpdater;
	    
	private StockUpdateSingleton()
	{
	    System.out.println("Instance of StockUpdateSingleton Created");	
	}
	    
	public static StockUpdateSingleton getStockUpdater()
	{
		if(stockUpdater == null)
		{
			synchronized (StockUpdateSingleton.class)
			{
				if(stockUpdater == null)
				{
					stockUpdater = new StockUpdateSingleton();
				}
			}
	    }   
		
		return stockUpdater;   
	}
	
	public void updateStock(String sql, String value, String id) throws SQLException
	{
		C3DBA c3dba = new C3DBA();
		c3dba.stockUpdate(sql, value, id);
	}
}
