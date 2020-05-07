//SY
package com.c3mm.client.model;

public class Props
{	
	//Constants for Media
	public static final String ID = "id";
	public static final String TITLE = "title";
	public static final String AUTHOR = "author";
	public static final String STOCK = "in_stock";
	public static final String DATE = "pub_date";
	public static final String ISBN = "isbn";
	public static final String COUNTRY = "country";
	public static final String TYPE = "type";
	public static final String LANG = "language";
	public static final String YEAR = "year";
	public static final String ARTIST = "artist";
	public static final String DIRECTOR = "director";
	
	//Constants for Users
	public static final String USERNAME = "username";
	public static final String PASSWORD ="password";
	public static final String FIRSTNAME ="firstname";
	public static final String LASTNAME ="lastname";
	public static final String ADDRESS ="address";
	public static final String EMAIL =	"email";
	public static final String IMAGEURL = "image_url";

	public static class Comms
	{
		/**
		 * String delimiter to break the server's response into an array
		 */
		public static final String DELIM = ";";
		
		public static final String FOUND = "found";
		public static final String NOT_FOUND = "no results found";
		public static final String DONE = "done.";
		public static final String ROW_UPD = "Rows Updated";
		public static final CharSequence ROW_INS = "Rows Inserted";
		
		public static final String SEL = "s";
		public static final String UPD = "u";
		public static final String INS = "i";

		//Testing
		public static final String VER = "v";
		
	}
	
	public static class Table
	{
		//Media table names
		public static final String BOOKS = "books";
		public static final String CDS = "cds";
		public static final String MOVIES = "movies";
		
		//user table name
		public static final String USERS = "user";
	}
	
	public static class Msg
	{
		//Message System Constants
		public static final String SEL_ALL = "s;select * from ";
		public static final String Q_MARK = " = ?;";
		
		//Media Query Constants
		private static final String CHK_QUERY = " not found. Please check your query.";	//Private?
		public static final String BOOK_NF = "Book" + CHK_QUERY;
		public static final String CD_NF = "CD" + CHK_QUERY;
		public static final String MOVIE_NF = "Movie" + CHK_QUERY;
		
		//User Query Constants
		public static final String USER_NF = "User" + CHK_QUERY;
		
	}
	
	//Testing
	public static class Log
	{
		public static final String LOG_FILE_CLIENT = "activity_logs/client_log.txt";
		public static final String LOG_FILE_SERVER = "activity_logs/server_log.txt";
	}
}

