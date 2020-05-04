package com.c3mm.client.controller;

import java.util.LinkedList;
import java.util.List;

import com.c3mm.client.model.BookModel;
import com.c3mm.client.model.C3Client;
import com.c3mm.client.model.CDModel;
import com.c3mm.client.model.MovieModel;
import com.c3mm.client.model.Props.Comms;
import com.c3mm.client.view.AdditionalInfoFrame;

public class SearchManager
{
	private String term;
	private C3Client client;
	
	public SearchManager()
	{
		
	}
	public SearchManager(C3Client client)
	{
		this.client = client;
	}
	
	/*The Most General Search method. For media data bases with many items (100+)
	 *May take a long time. Using other methods, if possible is preferred.
	 */
	public void executeSearch(String term)
	{
		//Search DB for term by looking at each table in c3db.db
		
		//search for title
		searchByTitle(term);
		
		
		//search for language
		searchByLanguage(term);
		
		//search for  country?		
		
		
		//searchByAuthor();
		//searchByDirector();
		//searchByArtist();
		//search cds
		
		//search movies
	}
	
	//Search for media by title. All media is searched and items with a matching title are stored in results.
	public void searchByTitle(String title)
	{
		//Look for a book with  a title equal to input title
		List<BookModel> books = client.getAllBooks();
		List<BookModel> results = new LinkedList<>();
		
		for(int i = 0; i < books.size(); i++)
		{
			String candidate = books.get(i).getTitle();
			
			if(candidate.equalsIgnoreCase(title))
			{
				System.out.println("\n...............FOUND........" + candidate);
				results.add(books.get(i));
				AdditionalInfoFrame aif = new AdditionalInfoFrame();
				aif.setItem(books.get(i));
				aif.showInfoFrame();
			}
		}
		
		
		//Look for a cd with  a title equal to input title
		List<CDModel> cds = client.getAllCDs();
		List<CDModel> results2 = new LinkedList<>();
				
		for(int i = 0; i < cds.size(); i++)
		{
			String candidate = cds.get(i).getTitle();
			
			if(candidate.equalsIgnoreCase(title))
			{
				System.out.println("\n...............FOUND........" + candidate);
				results2.add(cds.get(i));
				AdditionalInfoFrame aif = new AdditionalInfoFrame();
				aif.setItem(cds.get(i));
				aif.showInfoFrame();
			}
		}
		
		//Look for a moivie with  a title equal to input title
		List<MovieModel> movies = client.getAllMovies();
		List<MovieModel> results3 = new LinkedList<>();
						
		for(int i = 0; i < movies.size(); i++)
		{
			String candidate = movies.get(i).getTitle();
					
			if(candidate.equalsIgnoreCase(title))
			{
				System.out.println("\n...............FOUND........" + candidate);
				results3.add(movies.get(i));
				AdditionalInfoFrame aif = new AdditionalInfoFrame();
				aif.setItem(movies.get(i));
				aif.showInfoFrame();
			}
		}	
	}
	
	public void searchByLanguage(String language)
	{
		//Look for a book with a language equal to input language
		List<BookModel> books = client.getAllBooks();
		List<BookModel> results = new LinkedList<>();
				
		for(int i = 0; i < books.size(); i++)
		{
			String candidate = books.get(i).getLanguage();
					
			if(candidate.equalsIgnoreCase(language))
			{
				System.out.println("\n...............FOUND........" + candidate);
				results.add(books.get(i));
				AdditionalInfoFrame aif = new AdditionalInfoFrame();
				aif.setItem(books.get(i));
				aif.showInfoFrame();
			}
		}
		
		//Look for a book with a language equal to input language
		List<CDModel> cds = client.getAllCDs();
		List<CDModel> results2 = new LinkedList<>();
						
		for(int i = 0; i < cds.size(); i++)
		{
			String candidate = cds.get(i).getLanguage();
							
			if(candidate.equalsIgnoreCase(language))
			{
				System.out.println("\n...............FOUND........" + candidate);
				results2.add(cds.get(i));
				AdditionalInfoFrame aif = new AdditionalInfoFrame();
				aif.setItem(cds.get(i));
				aif.showInfoFrame();
			}
		}
				
				
		//Look for a book with a language equal to input language
		List<MovieModel> movies = client.getAllMovies();
		List<MovieModel> results3 = new LinkedList<>();
						
		for(int i = 0; i < movies.size(); i++)
		{
			String candidate = movies.get(i).getLanguage();
							
			if(candidate.equalsIgnoreCase(language))
			{
				System.out.println("\n...............FOUND........" + candidate);
				results3.add(movies.get(i));
				AdditionalInfoFrame aif = new AdditionalInfoFrame();
				aif.setItem(movies.get(i));
				aif.showInfoFrame();
			}
		}
	}
}
