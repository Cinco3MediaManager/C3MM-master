package com.c3mm.client.view;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MediaRibbon extends JPanel implements ActionListener
{
	/**
	 * Automatically added by Eclipse
	 */
	private static final long serialVersionUID = 1L;

	private JButton rightArrow;
	
	private int cursor;		//Track the ribbons position (rotation)
	
	private static final int MAX_ITEMS = GUIConstants.MAX_TILES;		//MAX_TILES = 10 (Currently)
	
	private MediaTileAlt[] tiles;		//Array of MediaTiles to show in this ribbon
	
	//private AdditionalInfoFrame bookInfoFrame;
	
	//No-Arg constructor.
	public MediaRibbon()
	{
		//Nothing to do
	}
	
	//Constructor with specified array of MediaTiles (incomingTiles).
	public MediaRibbon(MediaTileAlt[] incomingTiles)
	{
		//For data safety, copy the contents of incomingTiles into tiles
		tiles = new MediaTileAlt[MAX_ITEMS];
		
		for(int i = 0; i < MAX_ITEMS; i++)
		{	//Copy the tile
			tiles[i] = incomingTiles[i];
		}
		
		//Make the ribbon
		composeRibbon();
	}
	
	public void composeRibbon()
	{
		cursor = 0;						//Start at position 0
		rightArrow = new JButton();		//Create Button to scroll through the tiles		 
		rightArrow.setBackground(GUIConstants.darkgray);				//Assign a background color
		rightArrow.setIcon(new ImageIcon("images/arrow_right.jpg"));	//Set an image for the button
		rightArrow.addActionListener(this);		//Register button for action listener

		setLayout(new GridLayout(1,4));			//Ribbon is a 1 x 4 grid with 3 tiles and a button
		
		add(tiles[0]);			//Add tiles to ribbon
		add(tiles[1]);
		add(tiles[2]);
		
		add(rightArrow);		//Add the scroll button
	}
	
	private void scrollTiles(int direction)
	{
		int leftA = 0;					//The index of tiles[] to be added
		int midA = 0;
		int rightA = 0;
		
		int leftR,midR,rightR;			//The index of tiles[] to be removed
		
		if(direction == 1)				//Scroll to the right. i.e. left tile becomes the center, center become right, right moves off-screen
		{	
			cursor++;
			
			for(int i = 0; i < MAX_ITEMS; i++)
			{
				int r = (i+cursor)%MAX_ITEMS;
				
				if(r == 1)
				{
					midA = i;
				}
				else if(r == 2)
				{
					rightA = i;
				}
				else if(r== 0)
				{
					leftA = i;
				}
			}
			
			leftR = (leftA + 1)%MAX_ITEMS; 
			midR = (midA + 1)%MAX_ITEMS; 
			rightR = (rightA + 1)%MAX_ITEMS; 
			
			remove(tiles[leftR]);
			remove(tiles[midR]);
			remove(tiles[rightR]);
	
			add(tiles[leftA]);	//Left tile
			add(tiles[midA]);	//Middle tile
			add(tiles[rightA]);	//Right tile
			
			add(rightArrow);	//Right arrow button

			revalidate();		//Important, must be called to see changes
		}
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource().equals(rightArrow))
		{
			System.out.println("Right Arrow button clicked");
			scrollTiles(1);			//1 means scroll right
		}
	}

}
