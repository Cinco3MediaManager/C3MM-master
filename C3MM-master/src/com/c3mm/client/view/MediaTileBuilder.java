package com.c3mm.client.view;

import java.util.List;

import com.c3mm.client.model.BookModel;
import com.c3mm.client.model.C3Client;
import com.c3mm.client.model.CDModel;
import com.c3mm.client.model.MovieModel;

public class MediaTileBuilder 
{
	C3Client client;
	
	public MediaTileBuilder(C3Client client)
	{
		this.client = client;
	}
	
	public MediaTileAlt[] getBookTiles()
	{
		MediaTileAlt[] bookTileArray = new MediaTileAlt[GUIConstants.MAX_TILES];

		List<BookModel> books = client.getAllBooks();
		
		for(int i = 0; i < GUIConstants.MAX_TILES; i++)
		{
			MediaTileAlt tile = new MediaTileAlt(books.get(i));
			bookTileArray[i] = tile;
		}
		
		return(bookTileArray);

	}
	public MediaTileAlt[] getMusicTiles()
	{
		MediaTileAlt[] musicTileArray = new MediaTileAlt[GUIConstants.MAX_TILES];
		List<CDModel> cds = client.getAllCDs();
		
		for(int i = 0; i < GUIConstants.MAX_TILES; i++)
		{
			MediaTileAlt tile = new MediaTileAlt(cds.get(i));
			musicTileArray[i] = tile;
		}
		return(musicTileArray);

	}
	public MediaTileAlt[] getMovieTiles()
	{
		MediaTileAlt[] movieTileArray = new MediaTileAlt[GUIConstants.MAX_TILES];
		
		List<MovieModel> movies = client.getAllMovies();
		
		for(int i = 0; i < GUIConstants.MAX_TILES; i++)
		{
			MediaTileAlt tile = new MediaTileAlt(movies.get(i));
			movieTileArray[i] = tile;
		}
		return(movieTileArray);
	}
}
