package com.c3mm.client.view;

import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JPanel;

import com.c3mm.client.model.C3Client;
import com.c3mm.client.model.User;

public class BrowserPanel extends JPanel
{
	private static final int MAX_TILES = 10;
		
	C3Client client;
	User currentUser;
	
	//Test
	static User u;
	
	MediaTileAlt[] bookTiles;
	MediaTileAlt[] musicTiles;
	MediaTileAlt[] movieTiles;
	
	public BrowserPanel(C3Client client)
	{
		this.client = client;
		
		populateTileArrays();
		
		createRibbons();
	}
	
	
	private void populateTileArrays()
	{
		//Build the media tiles using "Builder" class
		MediaTileBuilder mtb = new MediaTileBuilder(client);
		
		bookTiles = mtb.getBookTiles();
		musicTiles = mtb.getMusicTiles();
		movieTiles = mtb.getMovieTiles();
	}
	private void createRibbons()
	{
		MediaRibbon bookRibbon = new MediaRibbon(bookTiles);
		MediaRibbon musicRibbon = new MediaRibbon(musicTiles);
		MediaRibbon movieRibbon = new MediaRibbon(movieTiles);
	
		setLayout(new GridLayout(3,1));
		
		add(bookRibbon);
		add(movieRibbon);
		add(musicRibbon);
	}
	
	public void registerUser(User currentUser)
	{
		this.currentUser = currentUser;
		u = currentUser;
	}
	
	public static User getUser()
	{
		return u;
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
	}

}
