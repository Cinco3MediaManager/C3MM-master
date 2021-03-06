//SY
package com.c3mm.server.dba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import org.sqlite.SQLiteException;

import com.c3mm.client.model.Props.Comms;

public class C3DBA
{
	private static final String C3DB = "jdbc:sqlite:c3db.db"; 	// database url
	
	private Vector<String> rows = new Vector<String>();			//Rows contains the entries selected. Each element in rows is a ";"-delimited string of that items fields.
	Connection con = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	
	public void select(String sql, String value)
	{
		try
		{
			con = DriverManager.getConnection(C3DB);
			stmt = con.prepareStatement(sql);
			
			if (!value.isEmpty())
				stmt.setString(1, value);
			
			rs = stmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int numberOfColumns = rsmd.getColumnCount();

			if (rs.next() == false)
			{
				rows.add(Comms.NOT_FOUND + " | sql: " + sql + ", " + value);
			}
			else
			{
				do
				{
					String row = "";
					for (int i = 1; i <= numberOfColumns; i++)
					{
						row = row + rs.getString(i) + ";";
					}
					rows.add(row);
				}
				while (rs.next());
			}
			
			if (stmt != null)
			{
				stmt.close();
			}
			
			if (con != null)
			{
				con.close();
			}
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public int update(String sql, String value, String recId) throws SQLException, SQLiteException
	{
		//Testing
		if(sql.contains("in_stock"))
		{
			StockUpdateSingleton stockUpdater = StockUpdateSingleton.getStockUpdater();
			stockUpdater.updateStock(sql, value, recId);
			return 1;
		}
		//End Testing
		
		int n = 0;
		if (value.isEmpty())
			return n;
		try
		{
			con = DriverManager.getConnection(C3DB);
			con.setAutoCommit(false);
			stmt = con.prepareStatement(sql);
			stmt.setString(1, value);
			stmt.setString(2, recId);
			n = stmt.executeUpdate();
			con.commit();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			if (con != null)
			{
				try
				{
					System.err.print("Transaction is being rolled back");
					con.rollback();
				}
				catch (SQLException excep)
				{
					excep.printStackTrace();
				}
			}
		}
		finally
		{
			if (stmt != null)
			{
				stmt.close();
			}
			con.setAutoCommit(true);
		}
		return n;
	}
	
	public int insert(String sql, String[] values) throws SQLException
	{
		int n = 0;
		try
		{
			con = DriverManager.getConnection(C3DB);
			con.setAutoCommit(false);
			stmt = con.prepareStatement(sql);
			for (int i=1; i <= values.length;i++)
			{
				stmt.setString(i, values[i-1]);
			}
			
			n = stmt.executeUpdate();
			con.commit();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			if (con != null)
			{
				try
				{
					System.err.print("Transaction is being rolled back");
					con.rollback();
				}
				catch (SQLException excep)
				{
					excep.printStackTrace();
				}
			}
		}
		finally
		{
			if (stmt != null)
			{
				stmt.close();
			}
			con.setAutoCommit(true);
		}
		return n;
	}
	
	public Vector<String> getRows()
	{
		return rows;
	}
	
	//Testing...Unused?
	public void getUser(String sql, String value)
	{
		try
		{
			System.out.println("Inside C3DBA getUser()");
			con = DriverManager.getConnection(C3DB);
			stmt = con.prepareStatement(sql);
			
			if (!value.isEmpty())
				stmt.setString(1, value);
			
			rs = stmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int numberOfColumns = rsmd.getColumnCount();
			
			if (rs.next() == false)
			{
				rows.add(Comms.NOT_FOUND + " | sql: " + sql + ", " + value);
			}
			else
			{
				do
				{
					String row = "";
					for (int i = 1; i <= numberOfColumns; i++)
					{
						row = row + rs.getString(i) + ";";
					}
					rows.add(row);
				}
				while (rs.next());
			}
			
			if (stmt != null)
			{
				stmt.close();
			}
			
			if (con != null)
			{
				con.close();
			}
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	
	
	}
	
	//Not to be called except by StockUpdateSingleton
	public void stockUpdate(String sql, String value, String recId) throws SQLException
	{
		int n = 0;
		
		System.out.println("in stockUpdate method sql = " + sql + " value = " + value + " recId = " + recId);
		
		try
		{
			con = DriverManager.getConnection(C3DB);
			con.setAutoCommit(false);
			stmt = con.prepareStatement(sql);
			stmt.setString(1, value);
			stmt.setString(2, recId);
			n = stmt.executeUpdate();
			con.commit();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			if (con != null)
			{
				try
				{
					System.err.print("Transaction is being rolled back");
					con.rollback();
				}
				catch (SQLException excep)
				{
					excep.printStackTrace();
				}
			}
		}
		finally
		{
			if (stmt != null)
			{
				stmt.close();
			}
			con.setAutoCommit(true);
		}
	
	}
}
