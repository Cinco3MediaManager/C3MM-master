//JW
package com.c3mm.client.view;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class AdminGUI extends JFrame
{
	/**
	 * Automatically added by Eclipse
	 */
	private static final long serialVersionUID = 1L;
	JTextArea clientDisplayArea;
	JTextArea serverDisplayArea;

	Scanner clientReader;
	Scanner serverReader;
	
	File clientLog;
	File serverLog;

	public AdminGUI()
	{
		try
		{
			clientLog = new File("activity_logs/client_log.txt");
			serverLog = new File("activity_logs/server_log.txt");
			
			clientReader = new Scanner(clientLog);
			serverReader = new Scanner(serverLog);
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Could not find actviity log file");
		}
		
		JPanel holder = new JPanel();
		clientDisplayArea = new JTextArea("Client Logs");
		clientDisplayArea.setBorder(BorderFactory.createLineBorder(Color.black));
		
		serverDisplayArea = new JTextArea("Server Logs");
		serverDisplayArea.setBorder(BorderFactory.createLineBorder(Color.black));
		
		holder.add(clientDisplayArea);
		holder.add(serverDisplayArea);
		
		while(clientReader.hasNextLine())
		{
			String in = clientReader.nextLine();
			clientDisplayArea.append(in);
			clientDisplayArea.append("\n");
		}
		
		while(serverReader.hasNextLine())
		{
			String in = serverReader.nextLine();
			serverDisplayArea.append(in);
			serverDisplayArea.append("\n");
		}
		
		
		holder.add(serverDisplayArea);
		
		//Set JFrame options
		setTitle("C3 Administrator GUI");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().add(holder);
		pack();
		setVisible(true);
		setSize(600,600);
	}
}
