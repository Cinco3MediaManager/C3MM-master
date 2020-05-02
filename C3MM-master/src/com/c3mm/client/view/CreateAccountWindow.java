package com.c3mm.client.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.c3mm.client.controller.SystemFunctions;
import com.c3mm.client.model.C3Client;
import com.c3mm.client.model.Props.Table;
import com.c3mm.client.model.User;

public class CreateAccountWindow extends JFrame implements ActionListener
{
	JButton close;
	JButton create;
	JButton reset;
	
	JTextField usernameField;
	JTextField passwordField;
	JTextField firstNameField;
	JTextField lastNameField;
	JTextField addressField;
	JTextField emailField;
	
	C3Client client;
	
	public CreateAccountWindow(C3Client client)
	{
		this.client = client;
		
		JLabel username = new JLabel("Username: ");
		JLabel password = new JLabel("Password: ");
		JLabel firstName = new JLabel("First Name: ");
		JLabel lastName = new JLabel("Last Name: ");
		JLabel address = new JLabel("Address: ");
		JLabel email = new JLabel("Email: ");
		
		usernameField = new JTextField("Username");
		passwordField = new JTextField("Password");
		firstNameField = new JTextField("First");
		lastNameField = new JTextField("Last");
		addressField = new JTextField("Address");
		emailField = new JTextField("Email");

		close = new JButton("Close");
		create = new JButton("Add");
		reset = new JButton("Reset");
		
		JPanel holder = new JPanel();
		holder.setLayout(new BoxLayout(holder, BoxLayout.Y_AXIS));
		
		holder.add(username);			//Username label and field pair
		holder.add(usernameField);
		
		holder.add(password);			//Password label and field pair
		holder.add(passwordField);
		
		holder.add(firstName);			//First name label and field pair
		holder.add(firstNameField);
		
		holder.add(lastName);			//Last name label and field pair
		holder.add(lastNameField);
		
		holder.add(address);			//Address label and field pair
		holder.add(addressField);
		
		holder.add(email);				//Email label and field pair
		holder.add(emailField);
		
		holder.add(reset);				//Add the Buttons
		holder.add(create);
		holder.add(close);
		
		reset.addActionListener(this);	//Register buttons for action events
		create.addActionListener(this);
		close.addActionListener(this);
			
		setBackground(Color.white);
		setTitle("Create Account");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().add(holder);
		pack();
		setVisible(true);
		setSize(300,600);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource().equals(close))
		{
			System.out.println("The close button was pressed. Closing Account Creation Window");
			dispose();
		}
		if(e.getSource().equals(create))
		{
			System.out.println("Create account button clicked");
			
			//To Do: Put this (below) into a method
			String userName = usernameField.getText();
			String password = passwordField.getText();
			String firstName = firstNameField.getText();
			String lastName = lastNameField.getText();
			String address = addressField.getText();
			String email = emailField.getText();
			String type = "member";
			
			String hashPassword = SystemFunctions.hashPassword(password);

			User user = new User(userName, hashPassword, firstName, lastName, address, email, type);
			
			//Check if "username" already exists before inserting because "username" must be unique
			if(client.isNameAvailable(userName) == true)
			{
				//If username is available...
				client.insert(user.getProperties(), Table.USERS);		//Insert the user
				dispose();												//Close this window
				
				JOptionPane.showMessageDialog(this, "Account Creation Successful. You may now Login");
			}
			else
			{	
				//If the username is not available, inform the user to try again
				JOptionPane.showMessageDialog(this, "Username is already taken. Pick another.");
				user = null;
			}
		}
		if(e.getSource().equals(reset))
		{
			System.out.println("Resetting fields");
			
			usernameField.setText("");
			passwordField.setText("");
			firstNameField.setText("");
			lastNameField.setText("");
			addressField.setText("");
			emailField.setText("");

		}
	}

}
