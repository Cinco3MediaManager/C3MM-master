package com.c3mm.client.test;

public class MultiClientAccessTest 
{
	

	//BookModel book1 = new BookModel(1, "mybook1", "MyAuthor1", 5, "01-01-1999", "9879879874", "usa", "stream", "english", "1984_orwell.jpg");
	//BookModel book2 = new BookModel(1, "mybook2", "MyAuthor2", 5, "02-02-1999", "9879879874", "usa", "stream", "english", "harry_rowling.jpg");
	//AdditionalInfoFrame testFrame = new AdditionalInfoFrame();
	//testFrame.setItem(book2);
	//testFrame.setItem(book1);
	//testFrame.showInfoFrame();
	//testFrame.setItem(book2);
	//testFrame.setItem(book1);


	
	/*
	BookModel book2 = new BookModel(1, "mybook2", "MyAuthor2", 5, "01-01-1999", "9879879874", "usa", "stream", "english", "harry_rowling.jpg");
	AdditionalInfoFrame testFrame = new AdditionalInfoFrame(book2);
	
	CDModel cd2 = new CDModel(1, 5, "mycd2", "usa", "collection", "english", "MyArtist2", "1999", "dark_floyd.jpg");
	AdditionalInfoFrame testFrame2 = new AdditionalInfoFrame(cd2);
	
	MovieModel movie2 = new MovieModel(1, 5, "mymovie2", "usa", "stream", "english", "MyDirector2", "1999", "pulp_tarantino.jpg");
	AdditionalInfoFrame testFrame3 = new AdditionalInfoFrame(movie2);
	 */
	
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
}
