//JW
package com.c3mm.client.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import com.c3mm.client.model.BookModel;
import com.c3mm.client.model.C3Client;
import com.c3mm.client.model.CDModel;
import com.c3mm.client.model.CheckoutList;
import com.c3mm.client.model.CheckoutListModel;
import com.c3mm.client.model.MovieModel;
import com.c3mm.client.model.User;


public class AdditionalInfoFrame extends JFrame implements ActionListener
{
	/**
	 * Automatically added by Eclipse
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton close;
	private JButton add;
	
	private JLabel[] fieldNames;
	
	//private AbstractMediaModel item;
	
	//private CheckoutList list;
	//private static User user;
	
	private JLabel imgLbl;
	private ImageIcon img;
	
	private int numFields = 10;
	
	JPanel fieldCol;
	JPanel holder;
	JPanel btnHolder;
	
	private String itemTitle;
	
	public AdditionalInfoFrame()
	{
		//Note this will not show the frame. showInfoFrame() must be called by an instance
		//For the frame to contain data an instance must also call setItem(some media item)
		fieldNames = new JLabel[numFields];
		
		close = new JButton("Close");
		add = new JButton("Add Item");
		
		close.addActionListener(this);
		add.addActionListener(this);

		fieldCol = new JPanel();
		holder = new JPanel();

		btnHolder = new JPanel();
		btnHolder.setLayout(new BoxLayout(btnHolder, BoxLayout.X_AXIS));
		btnHolder.add(close);
		btnHolder.add(add);
		
		fieldCol.setLayout(new BoxLayout(fieldCol, BoxLayout.Y_AXIS));
		
		for(int i = 0; i < numFields; i++)
		{
			fieldNames[i] = new JLabel();
			fieldCol.add(fieldNames[i]);
		}
		
		imgLbl = new JLabel();
		imgLbl.setIcon(img);

		holder.add(fieldCol);
		holder.add(imgLbl);
		holder.add(btnHolder);
	}
	
	public void setItem(BookModel book)
	{
		String itemId = Integer.toString(book.getRecId());
		String inStock = Integer.toString(book.getInStock());
		String title = book.getTitle();
		String author= book.getAuthor();
		String pubDate = book.getPubDate();
		String isbn = book.getIsbn();
		String country = book.getCountry();
		String type = book.getType();
		String language = book.getLanguage();
		String imageURL = book.getImageURL();
		
		fieldNames[0].setText("Item ID: " + itemId);
		fieldNames[1].setText("In Stock: " + inStock);
		fieldNames[2].setText("Title: " + title);
		fieldNames[3].setText("Author: " + author);
		fieldNames[4].setText("Year: " + pubDate);
		fieldNames[5].setText("ISBN: " + isbn);
		fieldNames[6].setText("Country: " + country);
		fieldNames[7].setText("Type: " + type);
		fieldNames[8].setText("Language: " + language);
		fieldNames[9].setText("Cover Photo: " + imageURL);

		ImageIcon i = new ImageIcon("images/"+imageURL);
		imgLbl.setIcon(i);

		itemTitle = title;
	}
	
	public void setItem(CDModel cd)
	{
		String itemId = Integer.toString(cd.getRecId());
		String inStock = Integer.toString(cd.getInStock());
		String title = cd.getTitle();
		String artist= cd.getArtist();
		String year = cd.getYear();
		String country = cd.getCountry();
		String type = cd.getType();
		String language = cd.getLanguage();
		String imageURL = cd.getImageURL();
				
		fieldNames[0].setText("Item ID: " + itemId);
		fieldNames[1].setText("In Stock: " + inStock);
		fieldNames[2].setText("Title: " + title);
		fieldNames[3].setText("Artist: " + artist);
		fieldNames[4].setText("Year: " + year);
		fieldNames[5].setText("Country: " + country);
		fieldNames[6].setText("Type: " + type);
		fieldNames[7].setText("Language: " + language);
		fieldNames[8].setText("Cover Photo: " + imageURL);	
		
		ImageIcon i = new ImageIcon("images/"+imageURL);
		imgLbl.setIcon(i);
		
		itemTitle = title;
	}
	
	public void setItem(MovieModel movie)
	{
		String itemId = Integer.toString(movie.getRecId());
		String inStock = Integer.toString(movie.getInStock());
		String title = movie.getTitle();
		String director= movie.getDirector();
		String year = movie.getYear();
		String country = movie.getCountry();
		String type = movie.getType();
		String language = movie.getLanguage();
		String imageURL = movie.getImageURL();
						
		fieldNames[0].setText("Item ID: " + itemId);
		fieldNames[1].setText("In Stock: " + inStock);
		fieldNames[2].setText("Title: " + title);
		fieldNames[3].setText("Director: " + director);
		fieldNames[4].setText("Year: " + year);
		fieldNames[5].setText("Country: " + country);
		fieldNames[6].setText("Type: " + type);
		fieldNames[7].setText("Language: " + language);
		fieldNames[8].setText("Cover Photo: " + imageURL);	
		
		ImageIcon i = new ImageIcon("images/"+imageURL);
		imgLbl.setIcon(i);
		
		itemTitle = title;
	}
	
	public void showInfoFrame()
	{		
		holder.add(fieldCol);
		holder.add(imgLbl);
		holder.add(btnHolder);
		
		setBackground(GUIConstants.darkgray);
		setTitle("Additional Information");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().add(holder);
		pack();
		setVisible(true);
		setSize(500,400);
	}

	private void checkoutItem()
	{		
		String username = BrowserPanel.getUser().getUsername();
		C3Client client = new C3Client();

		CheckoutListModel clm = client.getCheckoutList("username", username);
		
		if(clm.getTitle(1).equals("null"))
		{
			client.updateCheckout("title1", itemTitle, username);
			client.updateCheckout("due_date1", "7 Days", username);
		}
		else if(clm.getTitle(2).equals("null"))
		{
			client.updateCheckout("title2", itemTitle, username);
			client.updateCheckout("due_date2", "7 Days", username);
		}
		else if(clm.getTitle(3).equals("null"))
		{
			client.updateCheckout("title3", itemTitle, username);
			client.updateCheckout("due_date3", "7 Days", username);
		}
		else
		{
			JOptionPane.showMessageDialog(this, "You have reached the checkout limit.\nReturn items to checkout more books");
		}

	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource().equals(close))
		{
			System.out.println("The close button was pressed. Closing Additional information frame");
			dispose();
		}
		if(e.getSource().equals(add))
		{
			checkoutItem();
			dispose();
		}
	}

}

