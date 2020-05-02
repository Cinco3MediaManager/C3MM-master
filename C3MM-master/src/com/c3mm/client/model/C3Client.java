package com.c3mm.client.model;
import java.io.*;
import java.net.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import com.c3mm.client.controller.SystemFunctions;
import com.c3mm.client.model.Props.Comms;
import com.c3mm.client.model.Props.Msg;
import com.c3mm.client.model.Props.Table;

public class C3Client
{
	/* Constants for program configuration */
	private static final String SERVER = "Server-> ";
	private static final String CLIENT = "Client-> ";
	private static final String UNKNOWN_HOST = "The specified host could not be found: ";
	private static final String IO_HOST = "Couldn't get I/O for the connection to ";
	private static final String HOST = "localhost"; //change to connect across computers
	private static final int PORT = 1234; //change to connect across computers
	
	Vector<String> results = null;
	
	private void sendRequest(String message)
	{
		//For My Machine
		String local = "192.168.1.7";
		
		try (Socket socket = new Socket(InetAddress.getLocalHost(), PORT); // connect to the server socket. 
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true); // use this to send requests to server
				BufferedReader in = new BufferedReader( new InputStreamReader(socket.getInputStream()) ); ) // use this to read response from server 
		{
			results = new Vector<String>();
			String fromServer;
			String fromClient;
			
			// This loop executes every time the server sends a response
			while ((fromServer = in.readLine()) != null) // read from the server
			{
				System.out.println(SERVER + fromServer); // tell me what the server said
				
				if ( fromServer.contains(Comms.DONE) ) // if the server sends "done.", exit the loop and close connection
					break;
				
				if( fromServer.contains(Comms.NOT_FOUND) ) // if the query returns no results skip to get the server's last response
					continue;
				
				if( fromServer.contains(Comms.DELIM) ) // the delimiter indicates we received something back
				{
					results.add(fromServer);
					continue; // skip to read the next server response
				}
				
				if( fromServer.contains(Comms.ROW_UPD) || fromServer.contains(Comms.ROW_INS))
				{
					results.add(fromServer);
					continue;
				}
				
				fromClient = message;
				
				if (fromClient != null)
				{
					System.out.println(CLIENT + fromClient); // show me what I am sending to the server
					out.println(fromClient); // send it to the server
				}
			}
		}
		catch (UnknownHostException e)
		{
			//Document the error and action taken in the activity log
			SystemFunctions.writeToClientLog(UNKNOWN_HOST + HOST + "\n" + "Exiting Program");
			
			System.err.println(UNKNOWN_HOST + HOST);
			System.exit(1);
		}
		catch (IOException e)
		{
			//Document the error and action taken in the activity log
			SystemFunctions.writeToClientLog(IO_HOST + HOST + "\n" + "Exiting Program");

			System.err.println(IO_HOST + HOST);
			System.exit(1);
		}
	}
	
	public BookModel getBook(String field, String param)
	{
		select(Table.BOOKS, field, param);
		String[] values; 
		BookModel book = null;
		try
		{
			values = results.get(0).split(Comms.DELIM);
			book = new BookModel(Integer.parseInt(values[0]), // id
					values[1], // title
					values[2], // author
					Integer.parseInt(values[3]), // in-stock
					values[4], // publication date
					values[5], // ISBN
					values[6], // country
					values[7], // type
					values[8],  // language
					values[9]	//image url
			);
		}
		catch (Exception e)
		{
			System.err.println("getBook-> " + Msg.BOOK_NF );
		}
		return book;
	}
	
	/*ORIGINAL
	public List<BookModel> getAllBooks()
	{
		select(Table.BOOKS);
		List<BookModel> books = new LinkedList<>();
		
		for (String row : results)
		{
			String[] values = row.split(Comms.DELIM);
			books.add(
				new BookModel(Integer.parseInt(values[0]), // id
					values[1], // title
					values[2], // author
					Integer.parseInt(values[3]), // in-stock
					values[4], // publication date
					values[5], // ISBN
					values[6], // country
					values[7], // type
					values[8]  // language
				)
			);
		}
		
		return books;
	}
	*/
	
	//Testing done with copy...works fine
	//Note: addition of imageURL field (here and in c3db.db
	public List<BookModel> getAllBooks()
	{
		select(Table.BOOKS);
		List<BookModel> books = new LinkedList<>();
		
		for (String row : results)
		{
			String[] values = row.split(Comms.DELIM);
			books.add(
				new BookModel(Integer.parseInt(values[0]), // id
					values[1], // title
					values[2], // author
					Integer.parseInt(values[3]), // in-stock
					values[4], // publication date
					values[5], // ISBN
					values[6], // country
					values[7], // type
					values[8],  // language
					values[9]	//image url
				)
			);
		}
		
		return books;
	}
	
	public boolean updateBook(String colToUpdate, String updValue, String recId) 
	{
		update(Table.BOOKS, colToUpdate, updValue, "book_id", recId);
		return results.get(0).contains(Comms.ROW_UPD);
	}
	
	public CDModel getCD(String field, String param)
	{
		select(Table.CDS, field, param);
		String[] values;
		CDModel cd = null;
		try 
		{
			values = results.get(0).split(Comms.DELIM);
			cd = new CDModel(Integer.parseInt(values[0]), // id
					Integer.parseInt(values[1]), // in-stock
					values[2], // title
					values[3], // country 
					values[4], // type
					values[5], // language
					values[6], // country
					values[7],  // type
					values[8]	//image url
			);
		}
		catch (Exception e)
		{
			System.err.println("getCD-> " + Msg.CD_NF);
		}
		
		return cd;
	}
	
	public List<CDModel> getAllCDs()
	{
		select(Table.CDS);
		List<CDModel> cds = new LinkedList<>();
		
		for (String row : results)
		{
			String[] values = row.split(Comms.DELIM);
			cds.add(
				new CDModel(Integer.parseInt(values[0]), // id
					Integer.parseInt(values[1]), // in-stock
					values[2], // title
					values[3], // country 
					values[4], // type
					values[5], // language
					values[6], // artist
					values[7],  // year
					values[8]	//image url
					)
			);
		}
		
		return cds;
	}
	
	public boolean updateCD(String colToUpdate, String updValue, String recId) 
	{
		update(Table.CDS, colToUpdate, updValue, "cd_id", recId);
		return results.get(0).contains(Comms.ROW_UPD);
	}
	
	public MovieModel getMovie(String field, String param)
	{
		select(Table.MOVIES, field, param);
		String[] values;
		MovieModel movie = null;
		try
		{
			values = results.get(0).split(Comms.DELIM);
			movie = new MovieModel(Integer.parseInt(values[0]), // id
					Integer.parseInt(values[1]), // in-stock
					values[2], // title
					values[3], // country 
					values[4], // type
					values[5], // language
					values[6], // director
					values[7], // year
					values[8]	//image url
					);
			
		}
		catch (Exception e)
		{
			System.err.println("getMovie-> " + Msg.MOVIE_NF);
		}
		return movie;
	}
	
	public List<MovieModel> getAllMovies()
	{
		select(Table.MOVIES);
		List<MovieModel> movies = new LinkedList<>();
		
		for (String row : results)
		{
			String[] values = row.split(Comms.DELIM);
			movies.add(
					new MovieModel(Integer.parseInt(values[0]), // id
							Integer.parseInt(values[1]), // in-stock
							values[2], // title
							values[3], // country 
							values[4], // type
							values[5], // language
							values[6], // director
							values[7],  // year
							values[8]	//image url
							)
					);
		}
		
		return movies;
	}
	
	private void select(String table)
	{
		String msg = Msg.SEL_ALL + table;
		sendRequest(msg);
	}
	
	private void select(String table, String field, String param)
	{
		String msg = Msg.SEL_ALL + table + " where " + field + Msg.Q_MARK + param;
		sendRequest(msg);
	}
	
	public boolean updateMovie(String colToUpdate, String updValue, String recId) 
	{
		update(Table.MOVIES, colToUpdate, updValue, "movie_id", recId);
		return results.get(0).contains(Comms.ROW_UPD);
	}

	private void update(String table, String colToUpd, String value, String idCol, String idVal)
	{
		String qType = "u;";
		String sql = "update " + table + " set " + colToUpd + " = ? where " + idCol + Msg.Q_MARK + value + ";" + idVal;
		String msg = qType + sql;
		sendRequest(msg);
	}
	
	public void insert(Map<String, String> map, String table)
	{
		map.remove(Props.ID);
		String qType = "i;";
		StringBuffer cols = new StringBuffer();
		StringBuffer vals = new StringBuffer();
		StringBuffer marks = new StringBuffer();
		
		Set<String> colsToUpd = map.keySet();
		
		for (String s: colsToUpd)
		{
			cols.append(s + ",");
			vals.append(map.get(s) + "%");
			marks.append("?,");
		}
		
		// Trim last char
		cols.deleteCharAt(cols.length()-1);
		vals.deleteCharAt(vals.length()-1);
		marks.deleteCharAt(marks.length()-1);
		
		String sql = "insert into " +  table + " (" + cols + ") VALUES (" + marks + ");";
		String msg = qType + sql + vals;
		System.out.println(msg);
		
		String[] args = msg.split(Comms.DELIM);
		
		for (String s : args)
			System.out.println(s);
		String [] args2 = args[args.length-1].split("%");
		
		for (String s: args2)
			System.out.println(s);
		
		sendRequest(msg);
	}
	
	//Testing...so far works fine
	public User getUser(String field, String param)
	{
		select(Table.USERS, field, param);
		String[] values; 
		User user = null;
		try
		{
			values = results.get(0).split(Comms.DELIM);	
			user = new User(values[0], values[1], values[2], values[3], values[4], values[5], values[6]);
		}
		catch (Exception e)
		{
			System.err.println("getUser-> " + Msg.USER_NF );
		}
		return user;
	}
	
	//Testing. Currently works fine
	public boolean isNameAvailable(String name)
	{
		boolean available = false;
		
		select(Table.USERS, "username", name);
		String[] values; 
		try
		{
			values = results.get(0).split(Comms.DELIM);
		}
		catch (Exception e)
		{
			System.err.println("HERE>>>HERE " + Msg.USER_NF );
			
			//If a user was not found, then the username is available
			//To Do: Alter approash to not rely on an error being thrown to 
			//know a user with that name does not exist
			available = true;
		}
		
		return available;
	}
	
}

























