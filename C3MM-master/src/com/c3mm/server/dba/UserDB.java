package com.c3mm.server.dba;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDB
{
	
    String url = "jdbc:sqlite:UserDataBase.db";

    public void storeUser(String userName, String[] userInfo)
    {
        Connection conn = null;
        try 
        {
            // db parameters for local connection
        	// change url to connect to the directory of UserDataBase.db
//            String url = "jdbc:sqlite:C:/sqlite/db/UserDataBase.db";
            
            //Testing 
            //String url = "jdbc:sqlite:UserDataBase.db";

            
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            Statement myStmt =  conn.createStatement();
            
            String sql = "insert into User "
            		+ " (username, password, firstname, lastname, address , email) " 
            		+ " values ('"+ userInfo[0] + "','" + userInfo[1] + "','" + userInfo[2] + "','"
            		+ userInfo[3]+ "','" + userInfo[4] + "','" + userInfo[5] +"')";
            
            myStmt.executeUpdate(sql);
            
            System.out.println("Account creation success.");
            
        } 
        catch (SQLException e) 
        {
            System.out.println(e.getMessage());
        }
        finally
        {
            try 
            {
                if (conn != null) 
                {
                    conn.close();
                }
            } 
            catch (SQLException ex) 
            {
                System.out.println(ex.getMessage());
            }
        }
    }
    public void getUserInfo(String userName) 
    {
        Connection conn = null;
        ResultSet myRs = null;
        try {
            // db parameters for local connection
        	// change url to connect to the directory of UserDataBase.db
          //  String url = "jdbc:sqlite:C:/sqlite/db/UserDataBase.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            Statement myStmt = conn.createStatement();
            
            String sql = "select * from User where username == '"+userName+"'";
            // can change user name to another variable ie: name, last name
            myRs = myStmt.executeQuery(sql);
            
            if (myRs.isClosed()) 
            { // no result = no users found
            	System.out.println("No users found");
            }
            else 
            {
            System.out.println("User Info:");
            
            	for (int i=1;i<=6;i++) 
            	{
            		System.out.print(myRs.getString(i));
            		System.out.print(" ");
            	}
            }
        } 
        catch (SQLException e) 
        {
            System.out.println(e.getMessage());
        } 
        finally
        {
            try
            {
                if (conn != null)
                {
                    conn.close();
                }
            }
            catch (SQLException ex)
            {
                System.out.println(ex.getMessage());
            }
        }	
    }
    public void borrowBook() 
    { // to be determined
    	
    }
    public void login(String userName, String passWord)
    {
        Connection conn = null;
        ResultSet myRs = null;
        String sql = null;
        try 
        {
            // db parameters for local connection
        	// change url to connect to the directory of UserDataBase.db
      //      String url = "jdbc:sqlite:C:/sqlite/db/UserDataBase.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            Statement myStmt = conn.createStatement();
            
            if (userName.contains("admin"))
            {
            	sql = "select * from Admin where adminusername == '"+userName+"'"+"and adminpassword == '"+passWord+"'";
            }
            else
            {
            	sql = "select * from User where username == '"+userName+"'"+"and password == '"+passWord+"'";
            }
            myRs = myStmt.executeQuery(sql);
            
            if (myRs.isClosed())
            { // no result = no users found
            	System.out.println("Account not found");
            }
            else
            {
            	System.out.println("Login successful"); // login successful, connection to servers
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        finally 
        {
            try 
            {
                if (conn != null)
                {
                    conn.close();
                }
            }
            catch (SQLException ex)
            {
                System.out.println(ex.getMessage());
            }
        }
    }
}