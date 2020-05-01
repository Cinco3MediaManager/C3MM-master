
package com.c3mm.client.test;

//For writing activity to client log file
import com.c3mm.client.controller.SystemFunctions;

//These two are required
import com.c3mm.client.model.C3Client;
import com.c3mm.client.view.MemberGUI;

public class FullProgramTest 
{
	public static void main(String[] args) 
	{	
		/*NOTE: There are the three necessary steps to start the program
		 *1. Start the C3MultiServer (Must be done First)
		 *2. Create a C3Client
		 *3. Use the Swing Event-Dispatcher to launch the login window 
		 */
		
		//Step #2
		C3Client testClient = new C3Client();
		
		//Log the client creation
		SystemFunctions.writeToClientLog("Client Launched.");
		
		//Step #3
		javax.swing.SwingUtilities.invokeLater(new Runnable() 
		{
            public void run() 
            {
            	MemberGUI.launchLoginWindow(testClient);
            }
        });
	}

}
