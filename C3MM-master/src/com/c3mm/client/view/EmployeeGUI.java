package com.c3mm.client.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.c3mm.client.model.C3Client;

public class EmployeeGUI extends JFrame implements ActionListener
{
	JButton addBookBtn;
	JButton addCDBtn;
	JButton addMovieBtn;
	JButton exitBtn;
	
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
		
		addBookBtn = new JButton("Book");
		addCDBtn = new JButton("CD");
		addMovieBtn = new JButton("Movie");
		exitBtn = new JButton("Exit");

		btnHolder.setLayout(new BoxLayout(btnHolder, BoxLayout.X_AXIS));
		
		btnHolder.add(addBookBtn);
		btnHolder.add(addCDBtn);
		btnHolder.add(addMovieBtn);
		btnHolder.add(exitBtn);
		
		addBookBtn.addActionListener(this);
		addCDBtn.addActionListener(this);
		addMovieBtn.addActionListener(this);
		exitBtn.addActionListener(this);
		
		holder.add(btnHolder);
		
		//Set JFrame options
		setTitle("C3 Employee Interface");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().add(holder);
		pack();
		setVisible(true);
		setSize(800,200);
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
		if(e.getSource().equals(exitBtn))
		{
			dispose();
		}
	}
}
