package com.c3mm.client.model;

import java.util.HashMap;

/** 
 * Movie Entity Definition in  DB
 *  movie_id INTEGER PRIMARY KEY AUTOINCREMENT
 *                   NOT NULL
 *                   UNIQUE,
 *  in_stock INTEGER NOT NULL,
 *  title    TEXT    NOT NULL,
 *  country  TEXT,
 *  type             CONSTRAINT chk_type CHECK (type IN ('dvd', 'blue-ray', 'stream', 'tape') ) 
 *                   NOT NULL,
 *  language TEXT    NOT NULL,
 *  director TEXT    NOT NULL,
 *  year     TEXT
 *  
 * @author S3ry0u5
 */
public class MovieModel extends AbstractMediaModel
{
	private String director;
	private String year; // released year
	
	//Testing
	private String imageURL;
	
	/**
	 * Initialize the model variables
	 */
	public MovieModel()
	{
		super();
		this.director = "";
		this.year = "";
		
		//Testing 
		this.imageURL = "images/default_image";

	}
	
	public MovieModel(int rec_id, int inStock, String title, String country, String type, String language, String director,
			String year, String imageURL)
	{
		super(rec_id, inStock, title, country, type, language);
		this.director = director;
		this.year = year;
		
		//Testing
		this.imageURL = imageURL;
	}
	
	public String getYear()
	{
		return year;
	}
	
	public void setYear(String year)
	{
		this.year = year;
	}

	public String getDirector()
	{
		return director;
	}

	public void setDirector(String director)
	{
		this.director = director;
	}
	
	//Testing
	public void setImageURL(String imageURL)
	{
		this.imageURL = imageURL;
	}
	
	public String getImageURL()
	{
		return imageURL;
	}
	
	public HashMap<String, String> getProperties()
	{
		//Movie Order id, stock, title, country, type, lang, director, year
		//Book Order: id, stock, title, author, date, isbn, country, type, lang

		HashMap<String, String>	props = new HashMap<String, String>();
		props.put(Props.ID, String.valueOf(this.getRecId()));
		props.put(Props.STOCK, String.valueOf(this.getInStock()));
		props.put(Props.TITLE, this.getTitle());
		props.put(Props.COUNTRY, this.getCountry());
		props.put(Props.TYPE, this.getType());
		props.put(Props.LANG, this.getLanguage());
		props.put(Props.DIRECTOR, this.getDirector());
		props.put(Props.YEAR, this.getYear());
		
		//Testing
		props.put(Props.IMAGEURL, this.getImageURL());
		
		return props;
	}
	
}
