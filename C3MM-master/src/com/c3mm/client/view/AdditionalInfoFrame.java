package com.c3mm.client.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import com.c3mm.client.model.AbstractMediaModel;
import com.c3mm.client.model.BookModel;
import com.c3mm.client.model.CDModel;
import com.c3mm.client.model.CheckoutList;
import com.c3mm.client.model.MovieModel;
import com.c3mm.client.model.User;

//To Do: fix this. (I have an idea but dont have time right now)
public class AdditionalInfoFrame extends JFrame implements ActionListener
{
	private static final int MAX_FIELDS = 9;		//The maximum number of fields to display
	
	private JButton close;
	private JButton add;
	
	private JLabel[] fieldNames;
	private JLabel[] fieldContents;
	
	private AbstractMediaModel item;
	
	private CheckoutList list;
	private static User user;
	
	
	public AdditionalInfoFrame()
	{
		//To Do: Enclose in a generateLabels() method with a loop
		fieldNames = new JLabel[MAX_FIELDS];
		
		JPanel holder = new JPanel();
		holder.setLayout(new BoxLayout(holder, BoxLayout.Y_AXIS));
		
		close = new JButton("Close");
		add = new JButton("Checkout");
		
		holder.add(close);
		holder.add(add);
		
		close.addActionListener(this);
		add.addActionListener(this);
			
		setLocationByPlatform(true);
		setBackground(Color.white);
		setTitle("Additional Information");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().add(holder);
		pack();
		setVisible(true);
		setSize(300,500);
		
	}
	
	
	//To Do: Fix this class. It is a mess.
	public AdditionalInfoFrame(AbstractMediaModel item)
	{
		this.item = item;
		
		//To Do: Create fields into array using specific media items (below)
		JLabel field1;
		JLabel field2;
		JLabel field3;
		JLabel field4;
		JLabel field5;
		JLabel field6;
		JLabel field7;
		JLabel field8;
		JLabel field9;
		JLabel imgLabel;
		
		JPanel holder = new JPanel();
		holder.setLayout(new BoxLayout(holder, BoxLayout.Y_AXIS));
		

		
		//This is a Mess. To Do: Rewrite/Rework
		if(item instanceof BookModel)
		{
			BookModel book = (BookModel) item;
			
			int inStock = book.getInStock();
			String title = book.getTitle();
			String author= book.getAuthor();
			String pubDate = book.getPubDate();
			String isbn = book.getIsbn();
			String country = book.getCountry();
			String type = book.getType();
			String language = book.getLanguage();
			String imageURL = book.getImageURL();
			
			//To Do: Loop through fields and create/assign to labels
			field1 = new JLabel(Integer.toString(inStock));
			field2 = new JLabel(title);
			field3 = new JLabel(author);
			field4 = new JLabel(pubDate);
			field5 = new JLabel(isbn);
			field6 = new JLabel(country);
			field7 = new JLabel(type);
			field8 = new JLabel(language);
			
			field9 = new JLabel();
			ImageIcon img = new ImageIcon("images/"+imageURL);
			field9.setIcon(img);
			
			holder.add(field1);
			holder.add(field2);
			holder.add(field3);
			holder.add(field4);
			holder.add(field5);
			holder.add(field6);
			holder.add(field7);
			holder.add(field8);
			holder.add(field9);
		}
		
		else if(item instanceof CDModel)
		{
			CDModel cd = (CDModel) item;
			
			int inStock = cd.getInStock();
			String title = cd.getTitle();
			String author= cd.getArtist();
			String pubDate = cd.getYear();
			String country = cd.getCountry();
			String type = cd.getType();
			String language = cd.getLanguage();
			String imageURL = cd.getImageURL();
			
			//To Do: Loop through fields and create/assign to labels
			field1 = new JLabel(Integer.toString(inStock));
			field2 = new JLabel(title);
			field3 = new JLabel(author);
			field4 = new JLabel(pubDate);
			field6 = new JLabel(country);
			field7 = new JLabel(type);
			field8 = new JLabel(language);
			
			field9 = new JLabel();
			ImageIcon img = new ImageIcon("images/"+imageURL);
			field9.setIcon(img);
			
			holder.add(field1);
			holder.add(field2);
			holder.add(field3);
			holder.add(field4);
			holder.add(field6);
			holder.add(field7);
			holder.add(field8);
			holder.add(field9);
			
		}
		else if(item instanceof MovieModel)
		{
			MovieModel movie = (MovieModel) item;
			
			int inStock = movie.getInStock();
			String title = movie.getTitle();
			String author= movie.getDirector();
			String pubDate = movie.getYear();
			String country = movie.getCountry();
			String type = movie.getType();
			String language = movie.getLanguage();
			String imageURL = movie.getImageURL();
			
			//To Do: Loop through fields and create/assign to labels
			field1 = new JLabel(Integer.toString(inStock));
			field2 = new JLabel(title);
			field3 = new JLabel(author);
			field4 = new JLabel(pubDate);
			field6 = new JLabel(country);
			field7 = new JLabel(type);
			field8 = new JLabel(language);

			field9 = new JLabel();
			ImageIcon img = new ImageIcon("images/"+imageURL);
			field9.setIcon(img);
			
			holder.add(field1);
			holder.add(field2);
			holder.add(field3);
			holder.add(field4);
			holder.add(field6);
			holder.add(field7);
			holder.add(field8);
			holder.add(field9);
		}
		
		close = new JButton("Close");
		add = new JButton("Checkout");
		
		holder.add(close);
		holder.add(add);
		
		close.addActionListener(this);
		add.addActionListener(this);
			
		setLocationByPlatform(true);
		setBackground(Color.white);
		setTitle("Additional Information");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().add(holder);
		pack();
		setVisible(true);
		setSize(300,500);
	}
	
	/*The proper setItem(SomeMediaModel item) will be called 
	 *Automatically without this class needing to know/determine what type it is. 
	*/ 
	public void setItem(BookModel item)
	{
		//Called when item is a book
		
		fieldNames[0] = new JLabel("In Stock: ");
		fieldNames[1] = new JLabel("Title: ");
		fieldNames[2] = new JLabel("Author: ");
		fieldNames[3] = new JLabel("Published: ");
		fieldNames[4] = new JLabel("ISBN: ");
		fieldNames[5] = new JLabel("Country: ");
		fieldNames[6] = new JLabel("Format: ");
		fieldNames[7] = new JLabel("");
		//fieldNames[8] = new JLabel("Cover Image");
		
	}
	public void setItem(CDModel item)
	{
		//Called when item is a cd
		
	}
	public void setItem(MovieModel item)
	{
		//Called when item is a movie
		
	}
	
	public static void registerUser(User u)
	{
		user = u;
	}
	private void checkoutItem()
	{	
		//list = new CheckoutList(user.getUsername());
		
		list = user.getCheckoutList();

		if(list.addToCheckoutList(item) == 1)
		{
			System.out.println("Added: " + item.getTitle());
			dispose();
		}
		else
		{
			JOptionPane.showMessageDialog(this, "Checkout Limit Reached");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(close))
		{
			System.out.println("The close button was pressed. Closing Additional information frame");
			dispose();
		}
		if(e.getSource().equals(add))
		{
			checkoutItem();
		}
	}

}

