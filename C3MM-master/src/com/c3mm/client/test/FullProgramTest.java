
package com.c3mm.client.test;

//For writing activity to client log file
import com.c3mm.client.controller.SystemFunctions;
import com.c3mm.client.model.BookModel;
//These two are required
import com.c3mm.client.model.C3Client;
import com.c3mm.client.view.AdditionalInfoFrame;
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
		
		
		BookModel book2 = new BookModel(1, "mybook2", "MyAuthor2", 5, "01-01-1999", "9879879874", "usa", "stream", "english", "harry_rowling.jpg");
		AdditionalInfoFrame testFrame = new AdditionalInfoFrame(book2);
		
		
		/*Testing....... 
		Create server side "Singleton" class "updateStockSingleton"
		
		for(int i = 0; i < 100; i++)
		{
			int m = i%7;	//Generates range of values m = {0,1,2,3,4,5,6}
			
			Thread t = new Thread()
			{
				public void run()
				{
					C3Client client = new C3Client();
					client.updateBook("in_stock", Integer.toString(m), "5");
				}
			};
			
			t.start();
			
			/*Important Note: The client-side console for "FullProgramTest" may show outputs that appear to be out of order and/or
			 *disagree with the values in the book table of c3db. This is caused by the client-side switching between threads
			 *and print tasks.
			 *
			 *HOWEVER, the Server console "C3MultiServer" will be in order AND, will agree exactly with the values in c3db! 
			 *This is why a Singleton type class is used to control updates to the stock of items.
			 *
			 *Also Note: In the C3MultiServer console, although 100 separate clients are connected, ONLY ONE stockUpdateSingleton is created!
			 *To see this, note the println(...) statement in the stockUpdateSingleton constructor. C3MultiServer console shows that this
			 *line was printed only once. Therefore, only 1 stockUpdateSingleton exists.
			 */
			//System.out.println("Number in Stock: " + testClient.getBook("book_id", "5").getInStock());
		//}
		//End testing
		
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
