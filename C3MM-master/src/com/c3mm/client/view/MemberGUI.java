package com.c3mm.client.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.c3mm.client.controller.SystemFunctions;
import com.c3mm.client.model.User;
import com.c3mm.client.model.AbstractMediaModel;
import com.c3mm.client.model.C3Client;
import com.c3mm.client.model.CheckoutList;
import com.c3mm.client.model.Props.Table;

public class MemberGUI extends JFrame implements ActionListener
{
	Color gray2 = new Color(105,105,105);
	
	private int ribbonSizeBook = 3;
	private int ribbonSizeMusic = 3;
	private int ribbonSizeMovie = 3;

	JButton searchButton;
	JButton quitButton;
	JButton bookButton ;
	JButton musicButton;
	JButton movieButton;
	
	C3Client client;
	User currentUser;	
	//CheckoutList checkoutList;
	
	private String currentUserInfo;
	
	JLabel userLabel;
	
	public MemberGUI()
	{
		
	}
	public MemberGUI(C3Client client)
	{	
		this.client = client;
				
		JLabel menuLabel = new JLabel("Menu");
		menuLabel.setForeground(Color.white);
		menuLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JLabel welcomeLabel = new JLabel("Welcome to C3");
		welcomeLabel.setForeground(Color.white);
		welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JLabel memberLabel = new JLabel("Member");
		memberLabel.setForeground(Color.white);
		memberLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		userLabel = new JLabel();
		userLabel.setForeground(Color.white);
		userLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
								
		BrowserPanel browserPanel = new BrowserPanel(client);
		
		JPanel buttonPanel = new JPanel();
		JPanel holder = new JPanel();
		holder.setLayout(new BoxLayout(holder, BoxLayout.X_AXIS));

		searchButton = new JButton("Search");
		quitButton = new JButton( "Quit");
		
		bookButton = new JButton("Books");
		musicButton = new JButton("Music");
		movieButton = new JButton("Movies");

		searchButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		searchButton.setBackground(Color.white);
		
		quitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		quitButton.setBackground(Color.white);

		bookButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		bookButton.setBackground(Color.white);

		musicButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		musicButton.setBackground(Color.white);

		movieButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		movieButton.setBackground(Color.white);
		
		searchButton.addActionListener(this);
		quitButton.addActionListener(this);
		bookButton.addActionListener(this);
		musicButton.addActionListener(this);
		movieButton.addActionListener(this);

		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
		buttonPanel.add(menuLabel);
		
		buttonPanel.add(Box.createRigidArea(new Dimension(0,25)));
		buttonPanel.add(searchButton);
		
		buttonPanel.add(Box.createRigidArea(new Dimension(0,25)));
		buttonPanel.add(bookButton);
		
		buttonPanel.add(Box.createRigidArea(new Dimension(0,25)));
		buttonPanel.add(musicButton);
		
		buttonPanel.add(Box.createRigidArea(new Dimension(0,25)));
		buttonPanel.add(movieButton);
		
		buttonPanel.add(Box.createRigidArea(new Dimension(0,25)));
		buttonPanel.add(quitButton);
		
		buttonPanel.add(Box.createRigidArea(new Dimension(0,25)));
		buttonPanel.add(welcomeLabel);
		
		buttonPanel.add(Box.createRigidArea(new Dimension(0,25)));
		buttonPanel.add(memberLabel);
		buttonPanel.add(userLabel);
		
		buttonPanel.add(Box.createVerticalGlue());
		
		buttonPanel.setBackground(GUIConstants.darkgray);
		
		browserPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		buttonPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		holder.add(buttonPanel);
		holder.add(Box.createRigidArea(new Dimension(10,0)));
		holder.add(browserPanel);
		
//		setLocationByPlatform(true);
		setBackground(Color.white);
		setTitle("Library Catalog");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().add(holder);
		pack();
		setVisible(true);
		setSize(1500,1000);
	}
	
	public static void launchLoginWindow(C3Client client)
	{
		LoginWindow login = new LoginWindow(client);
	}
	
	public void registerUser(User currentUser)
	{
		this.currentUser = currentUser;
		//checkoutList = this.currentUser.getCheckoutList();
		
		currentUserInfo = this.currentUser.getUsername();
		userLabel.setFont(new Font("Arial", Font.BOLD, 14));
		userLabel.setText(currentUserInfo);
		
		AdditionalInfoFrame.registerUser(this.currentUser);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource().equals(quitButton))
		{
			System.out.println("The close button was pressed. Closing Account Creation Window");
			dispose();
		}
		if(e.getSource().equals(searchButton))
		{
			String searchTerm = JOptionPane.showInputDialog(this, "Enter Search Term: ");
			System.out.println("Searching for: " + searchTerm);		
			
			/*To Do: Implement search function to find items associated with the input search term
			 *Ex: client.searchFor(searchTerm);
			 *When returning from a search, update the display to show the items found...where? In one of the ribbons?
			 *On a new screen (ex: Create a UI window ResultsScreen?)
			*/
		}
		if(e.getSource().equals(bookButton))
		{
			//To Do: Update the window to show only books instead of 1 book, 1 music, and 1 movie
		}
		if(e.getSource().equals(musicButton))
		{
			//To Do: Update the window to show only audio items instead of 1 book, 1 music, and 1 movie
		}
		if(e.getSource().equals(movieButton))
		{
			//To Do: Update the window to show only movies instead of 1 book, 1 music, and 1 movie
		}
	}
	
}

