//JW
package com.c3mm.client.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import com.c3mm.client.controller.SystemFunctions;
import com.c3mm.client.model.C3Client;
import com.c3mm.client.model.User;

public class LoginWindow extends JFrame
{
	//Declare Class Fields and Objects
	private String username;
	private String password;
	
	private JButton loginButton;
	private JButton exitButton;
	private JButton createButton;
	
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	
	private JPanel buttonPanel;
	private JPanel holder;

	private JTextField usernameTextField;
	private JTextField passwordTextField;
	
	private boolean filledOut;
	private boolean exitClicked;
	
	C3Client client;				//C3Client used to submit request for user information
			
	public LoginWindow(C3Client client)
	{	
		this.client = client;		//Register a C3Client
		
		usernameLabel = new JLabel("Username:");
		passwordLabel = new JLabel("Password:");
		
		buttonPanel = new JPanel();	//Holds the buttons
		holder = new JPanel();		//Holds the button panel, labels, text fields
		
		exitClicked = false;		//Has the exit button been clicked
		filledOut = false;			//has the form been filled out. Currently Unused

		usernameTextField = new JTextField(20);
		passwordTextField = new JTextField(20);
		
		loginButton = new JButton("Log In");
		exitButton = new JButton( "Exit  ");
		createButton = new JButton("Create Account");
		
		//Align buttons horizontally 
		loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		createButton.setAlignmentX(Component.CENTER_ALIGNMENT);
	
		//Register action listeners for buttons
		loginButton.addActionListener(new ButtonListener());
		exitButton.addActionListener(new ButtonListener());
		createButton.addActionListener(new ButtonListener());
		
		//Add items to the button panel
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		buttonPanel.add(loginButton);
		buttonPanel.add(Box.createRigidArea(new Dimension(10,0)));
		buttonPanel.add(exitButton);
		buttonPanel.add(Box.createRigidArea(new Dimension(10,0)));
		buttonPanel.add(createButton);
		buttonPanel.add(Box.createVerticalGlue());
		
		//Add items to the holder panel
		holder.setBorder(BorderFactory.createLineBorder(Color.black));
	    holder.add(Box.createRigidArea(new Dimension(0,55)));
		holder.add(usernameLabel);
		holder.add(usernameTextField);
		holder.add(passwordLabel);
		holder.add(passwordTextField);
		holder.add(buttonPanel);
		
		//Set JFrame options
		setTitle("C3 Media Manager Login");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().add(holder);
		pack();
		setVisible(true);
		setSize(800,200);
	}
	
	public String getUserName()
	{
		return username;
	}
	
	public void setClient(C3Client client)
	{
		this.client = client;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public boolean isFilledOut()
	{
		return filledOut;
	}
	
	public boolean isExitClicked()
	{
		return exitClicked;
	}
	
	private void launchCreateAccountWindow()
	{
		CreateAccountWindow caw = new CreateAccountWindow(client);
	}
	
	private void displayErrorMessage()
	{
		JOptionPane.showMessageDialog(this, "Username and/or Password is Invalid");
	}
	
	private boolean verifyLogin()
	{
		username = usernameTextField.getText();
		password = passwordTextField.getText();
		
		boolean valid = SystemFunctions.verifyLogin(username, password, client);
		
		return valid;
	}
	
	public void launchMemberGUI()
	{
		MemberGUI gui = new MemberGUI(client);
		User user = client.getUser("username", username);
		gui.registerUser(user);
	}
	
	public void launchEmployeeGUI()
	{
		EmployeeGUI gui = new EmployeeGUI(client);
		User user =  client.getUser("username", username);
	}
	
	private void launchAdminGUI()
	{
		AdminGUI gui = new AdminGUI();
	}
	
	private class ButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if(e.getSource() == loginButton)
			{
				if(verifyLogin())
				{
					String type = client.getUser("username", username).getType();
					
					if(type.equals("employee"))
					{
						//launch the member gui
						launchEmployeeGUI();
					}
					else if(type.equals("admin"))
					{
						launchAdminGUI();
					}
					else if(type.equals("member"))
					{
						//Launch the member GUI
						launchMemberGUI();
					}
					
					//Close the login window
					dispose();
				}
				else
				{ 
					//Notify the user that the login was not valid
					displayErrorMessage();
				}
			}
			
			if(e.getSource() == exitButton)
			{
				dispose();
				exitClicked = true;
			}
			
			if(e.getSource() == createButton)
			{
				launchCreateAccountWindow();
			}
		}
	}
}
