//JW
package com.c3mm.client.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.c3mm.client.model.C3Client;

public class EmployeeGUI extends JFrame implements ActionListener
{
	JButton addBookBtn;
	JButton addCDBtn;
	JButton addMovieBtn;
	JButton exitBtn;
	JButton addUserBtn;
	JButton checkInBtn;
	
	C3Client client;
	
	public EmployeeGUI()
	{
		launchWindow();
	}
	
	public EmployeeGUI(C3Client client)
	{
		this.client = client;
		launchWindow();
	}
	
	private void launchWindow()
	{
		JPanel btnHolder = new JPanel();
		JPanel holder = new JPanel();
		
		btnHolder.setLayout(new BoxLayout(btnHolder, BoxLayout.Y_AXIS));
		
		addBookBtn = new JButton("Book");
		addUserBtn = new JButton("User");
		addCDBtn = new JButton("CD");
		addMovieBtn = new JButton("Movie");
		exitBtn = new JButton("Exit");
		checkInBtn = new JButton("Check-In");
		
		btnHolder.add(new JLabel("Add a user: "));
		btnHolder.add(addUserBtn);
		btnHolder.add(Box.createRigidArea(new Dimension(0,25)));
		
		btnHolder.add(new JLabel("Add a Book: "));
		btnHolder.add(addBookBtn);
		btnHolder.add(Box.createRigidArea(new Dimension(0,25)));
		
		btnHolder.add(new JLabel("Add a CD: "));
		btnHolder.add(addCDBtn);
		btnHolder.add(Box.createRigidArea(new Dimension(0,25)));
		
		btnHolder.add(new JLabel("Add a Movie: "));
		btnHolder.add(addMovieBtn);
		btnHolder.add(Box.createRigidArea(new Dimension(0,25)));
		
		btnHolder.add(new JLabel("Return a users books: "));
		btnHolder.add(checkInBtn);
		btnHolder.add(Box.createRigidArea(new Dimension(0,25)));
		
		btnHolder.add(new JLabel("Return to login: "));
		btnHolder.add(exitBtn);
		
		addBookBtn.addActionListener(this);
		addCDBtn.addActionListener(this);
		addMovieBtn.addActionListener(this);
		exitBtn.addActionListener(this);
		addUserBtn.addActionListener(this);
		checkInBtn.addActionListener(this);
		
		holder.add(btnHolder);
		
		//Set JFrame options
		setTitle("C3 Employee Interface");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().add(holder);
		pack();
		setVisible(true);
		setSize(400,500);
	}
	
	private void launchAddItemWindow(String type)
	{
		AddItemWindow aiw = new AddItemWindow(client, type);
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource().equals(addBookBtn))
		{
			launchAddItemWindow("book");
		}
		if(e.getSource().equals(addCDBtn))
		{
			launchAddItemWindow("cd");
		}
		if(e.getSource().equals(addMovieBtn))
		{
			launchAddItemWindow("movie");
		}
		if(e.getSource().equals(addUserBtn))
		{
				CreateAccountWindow caw = new CreateAccountWindow(client);
		}
		if(e.getSource().equals(checkInBtn))
		{
			String username = JOptionPane.showInputDialog(this, "Enter the username for checkout list to reset: ");
			client.updateCheckout("title1", "null", username);
			client.updateCheckout("due_date1", "null", username);
			client.updateCheckout("title2", "null", username);
			client.updateCheckout("due_date2", "null", username);
			client.updateCheckout("title3", "null", username);
			client.updateCheckout("due_date3", "null", username);
			
		}
		if(e.getSource().equals(exitBtn))
		{
			MemberGUI.launchLoginWindow(client);
			dispose();
		}
	}
}
