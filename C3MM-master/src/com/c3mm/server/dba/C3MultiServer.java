
package com.c3mm.server.dba;

import java.net.*;
import java.io.*;

public class C3MultiServer
{
	//Any unreserved port can be used. If changed, port in C3Client should be changed to match
	private final static int PORT = 1234; 
	private final static String START_MSG = "New C3Thread Started...";
	private final static String LISTENING = "Server Listening in port " + PORT;
	private final static String IO_ERROR = "Could not listen on port " + PORT;
	
	public static void main(String[] args) throws IOException
	{
		boolean listening = true;
		int clientId = 0;
		
		try (ServerSocket serverSocket = new ServerSocket(PORT))
		{
			System.out.println(LISTENING);
			
			while (listening)
			{
				//Create a client socket by accepting the request
				Socket clientSocket = serverSocket.accept();
				
				//New client accepted, increment clientId
				clientId++;
				
				//Dispatch a thread to handle each incoming request
				new C3ServerThread(clientSocket).start();

				System.out.println(START_MSG);
				
				//Write information to the server log
				ServerActivityLog.writeToServerLog(START_MSG + "Client ID: " + clientId + clientSocket.getInetAddress());
			}
		}
		catch (IOException e)
		{
			System.err.println(IO_ERROR);
			System.exit(-1);
		}
	}
}
