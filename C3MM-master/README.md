# C3MM
To run the server code, create a run config and pass 4000 as the port, I will get rid of this soon.
you can also remove the code that checks the string args of the main class and provide the port number in the code.

#JW 4/30
What is books.csv? Its some kind of spread sheet, do we need it?

#JW 5/1
For Detailed log of changes/additions and reasons for/against see Teams + post about folder for logs (from Sergio) 

To test current state of program:
1. Run "FullProgramTest" class (in package com.c3mm.client.test)
Or, 
2. (Copied from "FullProgramTest") 
/*NOTE: There are the three necessary steps to start the program
		 *1. Start the C3MultiServer (Must be done First)
		 *2. Create a C3Client
		 *3. Use the Swing Event-Dispatcher to launch the login window with instance of C3Client as argument
     *   for MemberGUI.launchLoginWindow(testClient);
		 */


Modify IP and/or port as needed. I had to set IP to 192.168.1.7 and put port on 1234 (client and server)
