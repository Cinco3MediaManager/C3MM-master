package com.c3mm.client.view;

import java.awt.Color;
import java.awt.GridLayout;
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
	private JLabel[] fields;
	
	private AbstractMediaModel item;
	
	private CheckoutList list;
	private static User user;
	
	private JLabel imgLbl;
	private ImageIcon img;
	
	private int numFields;
	
	public AdditionalInfoFrame()
	{
		//To Do: Enclose in a generateLabels() method with a loop
		fieldNames = new JLabel[MAX_FIELDS];
		fields = new JLabel[MAX_FIELDS];

		JPanel holder = new JPanel();
		holder.setLayout(new BoxLayout(holder, BoxLayout.Y_AXIS));
		
		close = new JButton("Close");
		add = new JButton("Checkout");
		
		holder.add(close);
		holder.add(add);
		
		close.addActionListener(this);
		add.addActionListener(this);
		
		//Moved to setupPanel
		setLocationByPlatform(true);
		setBackground(Color.white);
		setTitle("Additional Information");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().add(holder);
		pack();
		setVisible(true);
		setSize(300,500);	
	}
	
	public AdditionalInfoFrame(BookModel item)
	{
		this.item = item;
		numFields = 10;
		setItem(item);

		setupPanel();
	}
	public AdditionalInfoFrame(CDModel item)
	{
		this.item = item;
		numFields = 9;
		setItem(item);

		setupPanel();
	}
	public AdditionalInfoFrame(MovieModel item)
	{
		this.item = item;
		numFields = 9;
		setItem(item);

		setupPanel();
	}
	
	private void setupPanel()
	{	
		close = new JButton("Close");
		add = new JButton("Add Item");

		JPanel fieldCol = new JPanel();
		JPanel fieldRow = new JPanel();
		JPanel holder = new JPanel();
		
		fieldCol.setLayout(new BoxLayout(fieldCol, BoxLayout.Y_AXIS));
		fieldRow.setLayout(new BoxLayout(fieldRow, BoxLayout.X_AXIS));
		
		for(int i = 0; i < numFields; i++)
		{
			//fieldRow.add(fieldNames[i]);
			//fieldRow.add(fields[i]);
			fieldCol.add(fieldNames[i]);
		}
		
		imgLbl = new JLabel();
		imgLbl.setIcon(img);

		holder.add(fieldCol);
		holder.add(imgLbl);
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
		setSize(385,375);
	}
	/*
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
	*/
	
	/*The proper setItem(SomeMediaModel item) will be called 
	 *Automatically without this class needing to know/determine what type it is. 
	*/ 
	public void setItem(BookModel item)
	{
		//Called when item is a book
		//Book Order: id, stock, title, author, date, isbn, country, type, lang, imageURL

		//Book has 10 fields
		fieldNames = new JLabel[numFields];
		
		String itemId = Integer.toString(item.getRecId());
		String inStock = Integer.toString(item.getInStock());
		String title = item.getTitle();
		String author= item.getAuthor();
		String pubDate = item.getPubDate();
		String isbn = item.getIsbn();
		String country = item.getCountry();
		String type = item.getType();
		String language = item.getLanguage();
		String imageURL = item.getImageURL();
		
		fieldNames[0] = new JLabel("Item ID: " + itemId);
		fieldNames[1] = new JLabel("In Stock: " + inStock);
		fieldNames[2] = new JLabel("Title: " + title);
		fieldNames[3] = new JLabel("Author: " + author);
		fieldNames[4] = new JLabel("Year: " + pubDate);
		fieldNames[5] = new JLabel("ISBN: " + isbn);
		fieldNames[6] = new JLabel("Country: " + country);
		fieldNames[7] = new JLabel("Type: " + type);
		fieldNames[8] = new JLabel("Language: " + language);
		fieldNames[9] = new JLabel("Cover Photo: " + imageURL);		//Label to be assigned image
		
		img = new ImageIcon("images/"+imageURL);
	}
	public void setItem(CDModel item)
	{
		//CDModel Order: id, stock, title, country, type, lang, artist, year

		fieldNames = new JLabel[8];
		fields = new JLabel[8];
		//No id
		fieldNames[0] = new JLabel("In Stock: ");
		fieldNames[1] = new JLabel("Title: ");
		fieldNames[2] = new JLabel("Artist: ");
		fieldNames[3] = new JLabel("Year: ");
		//No isbn
		fieldNames[4] = new JLabel("Country: ");
		fieldNames[5] = new JLabel("Type: ");
		fieldNames[6] = new JLabel("Language: ");
		fieldNames[7] = new JLabel("Cover Photo: ");		//Blank label to be assigned image

		
		fields[0] = new JLabel(Integer.toString(item.getInStock()));
		fields[1] = new JLabel(item.getTitle());
		fields[2] = new JLabel(item.getArtist());
		fields[3] = new JLabel(item.getYear());
		fields[4] = new JLabel(item.getCountry());
		fields[5] = new JLabel(item.getType());
		fields[6] = new JLabel(item.getLanguage());
		fields[7] = new JLabel(item.getImageURL());
		
		img = new ImageIcon("images/"+fields[7]);
		//fields[7].setIcon(img);
	}
	public void setItem(MovieModel item)
	{
		//Called when item is a movie
		//Movie Order id, stock, title, country, type, lang, director, year

		fieldNames = new JLabel[8];
		fields = new JLabel[8];
		//no id
		fieldNames[0] = new JLabel("In Stock: ");
		fieldNames[1] = new JLabel("Title: ");
		fieldNames[2] = new JLabel("Director: ");
		fieldNames[3] = new JLabel("Year: ");
		//No isbn
		fieldNames[4] = new JLabel("Country: ");
		fieldNames[5] = new JLabel("Type: ");
		fieldNames[6] = new JLabel("Language: ");
		
		fields[0] = new JLabel(Integer.toString(item.getInStock()));
		fields[1] = new JLabel(item.getTitle());
		fields[2] = new JLabel(item.getDirector());
		fields[3] = new JLabel(item.getYear());
		fields[4] = new JLabel(item.getCountry());
		fields[5] = new JLabel(item.getType());
		fields[6] = new JLabel(item.getLanguage());
		fields[7] = new JLabel(item.getImageURL());
		
		img = new ImageIcon("images/"+fields[7]);
		fields[7].setIcon(img);
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

