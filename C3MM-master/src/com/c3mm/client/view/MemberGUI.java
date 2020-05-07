//JW
package com.c3mm.client.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.c3mm.client.controller.SearchManager;
import com.c3mm.client.controller.SystemFunctions;
import com.c3mm.client.model.User;
import com.c3mm.client.model.AbstractMediaModel;
import com.c3mm.client.model.C3Client;
import com.c3mm.client.model.CheckoutList;
import com.c3mm.client.model.Props.Table;

public class MemberGUI extends JFrame implements ActionListener
{
	/**
	 * Automatically added by Eclipse
	 */
	private static final long serialVersionUID = 1L;

	private JButton quitButton;
	private JButton titleButton ;
	private JButton languageButton;
	private JButton countryButton;
	private JButton logoutButton;
	
	private C3Client client;
	private User currentUser;	
	
	private String currentUserInfo;
	
	private JLabel userLabel;
	
	private BrowserPanel browserPanel;
	
	public MemberGUI()
	{
		
	}
	public MemberGUI(C3Client client)
	{	
		this.client = client;
		
		JLabel welcomeLabel = new JLabel("Welcome to C3");
		welcomeLabel.setForeground(Color.white);
		welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JLabel memberLabel = new JLabel("Member:");
		memberLabel.setForeground(Color.white);
		memberLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JLabel searchLabel = new JLabel("Search By: ");
		searchLabel.setForeground(Color.white);
		searchLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		userLabel = new JLabel();
		userLabel.setForeground(Color.white);
		userLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
								
		browserPanel = new BrowserPanel(client);
		
		JPanel buttonPanel = new JPanel();
		JPanel holder = new JPanel();
		holder.setLayout(new BoxLayout(holder, BoxLayout.X_AXIS));

		quitButton = new JButton( "Quit");
		
		titleButton = new JButton("    Title   ");
		languageButton = new JButton("Language");
		countryButton = new JButton("Country ");
		logoutButton = new JButton("Logout");

		quitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		quitButton.setBackground(Color.white);

		titleButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		titleButton.setBackground(Color.white);

		languageButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		languageButton.setBackground(Color.white);

		countryButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		countryButton.setBackground(Color.white);
		
		logoutButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		logoutButton.setBackground(Color.white);
		
		logoutButton.addActionListener(this);
		quitButton.addActionListener(this);
		titleButton.addActionListener(this);
		languageButton.addActionListener(this);
		countryButton.addActionListener(this);

		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
		buttonPanel.add(welcomeLabel);
		
		buttonPanel.add(Box.createRigidArea(new Dimension(0,25)));
		buttonPanel.add(memberLabel);
		buttonPanel.add(userLabel);
		
		buttonPanel.add(Box.createRigidArea(new Dimension(0,25)));
		buttonPanel.add(searchLabel);
		
		buttonPanel.add(Box.createRigidArea(new Dimension(0,5)));
		buttonPanel.add(titleButton);
		
		buttonPanel.add(Box.createRigidArea(new Dimension(0,5)));
		buttonPanel.add(languageButton);
		
		buttonPanel.add(Box.createRigidArea(new Dimension(0,5)));
		buttonPanel.add(countryButton);
		
		buttonPanel.add(Box.createRigidArea(new Dimension(0,5)));
		buttonPanel.add(logoutButton);
		
		buttonPanel.add(Box.createVerticalGlue());
		
		buttonPanel.add(quitButton);
		
		buttonPanel.setBackground(GUIConstants.darkgray);
		
		browserPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		buttonPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		holder.add(buttonPanel);
		holder.add(Box.createRigidArea(new Dimension(10,0)));
		holder.add(browserPanel);
		
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

		browserPanel.registerUser(currentUser);		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource().equals(quitButton))
		{
			System.out.println("The close button was pressed. Closing Account Creation Window");
			dispose();
		}
		if(e.getSource().equals(titleButton))
		{
			String searchTerm = JOptionPane.showInputDialog(this, "Enter Search Term: ");
			System.out.println("Searching for: " + searchTerm);		
	
			SearchManager sm = new SearchManager(client);
			
			sm.searchByTitle(searchTerm);
		}
		if(e.getSource().equals(languageButton))
		{
			String searchTerm = JOptionPane.showInputDialog(this, "Enter Search Term: ");
			System.out.println("Searching for: " + searchTerm);		
	
			SearchManager sm = new SearchManager(client);
			
			sm.searchByLanguage(searchTerm);
		}
		if(e.getSource().equals(countryButton))
		{
			String searchTerm = JOptionPane.showInputDialog(this, "Enter Search Term: ");
			System.out.println("Searching for: " + searchTerm);		
	
			SearchManager sm = new SearchManager(client);
			
			sm.searchByCountry(searchTerm);
		}
		
		if(e.getSource().equals(logoutButton))
		{
			launchLoginWindow(client);
			dispose();
		}
		
	}
	
}

