package com.c3mm.client.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import com.c3mm.client.model.AbstractMediaModel;
import com.c3mm.client.model.BookModel;
import com.c3mm.client.model.CDModel;
import com.c3mm.client.model.MovieModel;

public class MediaTileAlt extends JPanel
{
	private int width = 300;
	private int height = 300;
	
	private int xLoc;
	private int yLoc;
	
	private int tileID;
	private boolean displayInfo;
	
	String imageURL;
	JLabel imgLabel;
	ImageIcon img;
		
	//One way
	private AbstractMediaModel item;
	
	public MediaTileAlt()
	{
		xLoc = 0;
		yLoc = 0;
		
		item = null;
		
		imageURL = "images/default_image.jpg";
		
		displayInfo = false;
		
		setupPanel();
	}
	
	public MediaTileAlt(BookModel book)
	{
		xLoc = 0;
		yLoc = 0;
		
		item = book;
		
		String img = "images/" + book.getImageURL();
		
		imageURL = img;
		
		displayInfo = false;
		
		setupPanel();
	}
	public MediaTileAlt(CDModel cd)
	{
		xLoc = 0;
		yLoc = 0;
		
		item = cd;
		
		String img = "images/" + cd.getImageURL();
		
		imageURL = img;		
		displayInfo = false;
		
		setupPanel();
	}
	public MediaTileAlt(MovieModel movie)
	{
		xLoc = 25;
		yLoc = 25;
		
		item = movie;
		
		String img = "images/" + movie.getImageURL();
		
		imageURL = img;		
		displayInfo = false;
		
		setupPanel();
	}
	
	private void setupPanel()
	{
		img = new ImageIcon(imageURL);
		imgLabel = new JLabel(img);
		
		setBorder(BorderFactory.createLineBorder(Color.black));
		
		//Add a mouse listener to this tile
		addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e)
			{
				displayAdditionalInformation();
			}
		});
		
		add(imgLabel);
		setSize(width,height);
		setLocation(xLoc, yLoc);
		setBackground(GUIConstants.darkgray);
	}
	
	private void displayAdditionalInformation()
	{
		//AdditionalInfoFrame infoFrame = new AdditionalInfoFrame(item);	
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		//image center at width/2 --> left corner at [width/2 - (imageWidth/2)]
		int width = this.getWidth();
		int xOffset = ((width/2) - (img.getIconWidth()/2));
		imgLabel.setLocation(xOffset, 20);

	}	
}	


