//JW
package com.c3mm.client.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.c3mm.client.model.BookModel;
import com.c3mm.client.model.C3Client;
import com.c3mm.client.model.CDModel;
import com.c3mm.client.model.MovieModel;
import com.c3mm.client.model.Props.Table;

public class AddItemWindow extends JFrame implements ActionListener
{
	JButton close;
	JButton create;
	JButton reset;
	
	JTextField usernameField;
	JTextField passwordField;
	JTextField firstNameField;
	JTextField lastNameField;
	JTextField addressField;
	JTextField emailField;
	
	JPanel fieldHolder;
	
	JTextField[] textFields;
	JLabel[] fieldLabels;
	
	int numFields;
	
	C3Client client;
	String type;
	
	public AddItemWindow(C3Client client, String type)
	{
		this.type = type;
		this.client = client;
		
		textFields = new JTextField[10];
		fieldLabels = new JLabel[10];
		
		close = new JButton("Close");
		create = new JButton("Add");
		reset = new JButton("Reset");
		
		JPanel holder = new JPanel();
		
		fieldHolder = new JPanel();
		fieldHolder.setLayout(new BoxLayout(fieldHolder, BoxLayout.Y_AXIS));
		
		if(type.equals("book"))
		{
			numFields = 10;
			populateFieldsBooks();
		}
		else if(type.equals("cd"))
		{
			numFields = 9;
			populateFieldsCDs();
		}
		else if(type.equals("movie"))
		{
			numFields = 9;
			populateFieldsMovies();
		}
		
		holder.add(fieldHolder);
		
		//test
		fieldHolder.add(reset);
		fieldHolder.add(create);
		fieldHolder.add(close);
		
		reset.addActionListener(this);	//Register buttons for action events
		create.addActionListener(this);
		close.addActionListener(this);
			
		setBackground(Color.white);
		setTitle("Add Item");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().add(holder);
		pack();
		setVisible(true);
		setSize(300,600);
	}

	private void populateFieldsBooks()
	{
		fieldLabels[0] = new JLabel("ID Number");
		fieldLabels[1] = new JLabel("Title: ");
		fieldLabels[2] = new JLabel("Author: ");
		fieldLabels[3] = new JLabel("# In Stock: ");
		fieldLabels[4] = new JLabel("Date: ");
		fieldLabels[5] = new JLabel("ISBN: ");
		fieldLabels[6] = new JLabel("Country: ");
		fieldLabels[7] = new JLabel("Type: ");
		fieldLabels[8] = new JLabel("Language: ");
		fieldLabels[9] = new JLabel("Image Name: ");

		textFields[0] = new JTextField("ID #");
		textFields[1] = new JTextField("title");
		textFields[2] = new JTextField("author");
		textFields[3] = new JTextField("stock");
		textFields[4] = new JTextField("date");
		textFields[5] = new JTextField("isbn");
		textFields[6] = new JTextField("country");
		textFields[7] = new JTextField("type");
		textFields[8] = new JTextField("language");
		textFields[9] = new JTextField("image");
		
		fieldHolder.add(fieldLabels[0]);
		fieldHolder.add(textFields[0]);
		
		fieldHolder.add(fieldLabels[1]);
		fieldHolder.add(textFields[1]);
		
		fieldHolder.add(fieldLabels[2]);
		fieldHolder.add(textFields[2]);
		
		fieldHolder.add(fieldLabels[3]);
		fieldHolder.add(textFields[3]);
		
		fieldHolder.add(fieldLabels[4]);
		fieldHolder.add(textFields[4]);
		
		fieldHolder.add(fieldLabels[5]);
		fieldHolder.add(textFields[5]);
		
		fieldHolder.add(fieldLabels[6]);
		fieldHolder.add(textFields[6]);
		
		fieldHolder.add(fieldLabels[7]);
		fieldHolder.add(textFields[7]);
		
		fieldHolder.add(fieldLabels[8]);
		fieldHolder.add(textFields[8]);
		
		fieldHolder.add(fieldLabels[9]);
		fieldHolder.add(textFields[9]);
	}
	
	private void populateFieldsCDs()
	{
		fieldLabels[0] = new JLabel("ID Number");
		fieldLabels[1] = new JLabel("Title: ");
		fieldLabels[2] = new JLabel("Artist: ");
		fieldLabels[3] = new JLabel("# In Stock: ");
		fieldLabels[4] = new JLabel("Year: ");
		fieldLabels[5] = new JLabel("Country: ");
		fieldLabels[6] = new JLabel("Type: ");
		fieldLabels[7] = new JLabel("Language: ");
		fieldLabels[8] = new JLabel("Image Name: ");

		textFields[0] = new JTextField("ID #");
		textFields[1] = new JTextField("title");
		textFields[2] = new JTextField("artist");
		textFields[3] = new JTextField("stock");
		textFields[4] = new JTextField("year");

		textFields[5] = new JTextField("country");
		textFields[6] = new JTextField("type");
		textFields[7] = new JTextField("language");
		textFields[8] = new JTextField("image");
		
		fieldHolder.add(fieldLabels[0]);
		fieldHolder.add(textFields[0]);
		
		fieldHolder.add(fieldLabels[1]);
		fieldHolder.add(textFields[1]);
		
		fieldHolder.add(fieldLabels[2]);
		fieldHolder.add(textFields[2]);
		
		fieldHolder.add(fieldLabels[3]);
		fieldHolder.add(textFields[3]);
		
		fieldHolder.add(fieldLabels[4]);
		fieldHolder.add(textFields[4]);
		
		fieldHolder.add(fieldLabels[5]);
		fieldHolder.add(textFields[5]);
		
		fieldHolder.add(fieldLabels[6]);
		fieldHolder.add(textFields[6]);
		
		fieldHolder.add(fieldLabels[7]);
		fieldHolder.add(textFields[7]);
		
		fieldHolder.add(fieldLabels[8]);
		fieldHolder.add(textFields[8]);
		
	}
	
	private void populateFieldsMovies()
	{
		fieldLabels[0] = new JLabel("ID Number");
		fieldLabels[1] = new JLabel("Title: ");
		fieldLabels[2] = new JLabel("Director: ");
		fieldLabels[3] = new JLabel("# In Stock: ");
		fieldLabels[4] = new JLabel("Year: ");
		fieldLabels[5] = new JLabel("Country: ");
		fieldLabels[6] = new JLabel("Type: ");
		fieldLabels[7] = new JLabel("Language: ");
		fieldLabels[8] = new JLabel("Image Name: ");

		textFields[0] = new JTextField("ID #");
		textFields[1] = new JTextField("title");
		textFields[2] = new JTextField("director");
		textFields[3] = new JTextField("stock");
		textFields[4] = new JTextField("year");

		textFields[5] = new JTextField("country");
		textFields[6] = new JTextField("type");
		textFields[7] = new JTextField("language");
		textFields[8] = new JTextField("image");
		
		fieldHolder.add(fieldLabels[0]);
		fieldHolder.add(textFields[0]);
		
		fieldHolder.add(fieldLabels[1]);
		fieldHolder.add(textFields[1]);
		
		fieldHolder.add(fieldLabels[2]);
		fieldHolder.add(textFields[2]);
		
		fieldHolder.add(fieldLabels[3]);
		fieldHolder.add(textFields[3]);
		
		fieldHolder.add(fieldLabels[4]);
		fieldHolder.add(textFields[4]);
		
		fieldHolder.add(fieldLabels[5]);
		fieldHolder.add(textFields[5]);
		
		fieldHolder.add(fieldLabels[6]);
		fieldHolder.add(textFields[6]);
		
		fieldHolder.add(fieldLabels[7]);
		fieldHolder.add(textFields[7]);
		
		fieldHolder.add(fieldLabels[8]);
		fieldHolder.add(textFields[8]);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource().equals(close))
		{
			System.out.println("The close button was pressed. Closing Add Item Window");
			dispose();
		}
		if(e.getSource().equals(create))
		{	
			if(type.equals("book"))
			{
				int id = Integer.parseInt(textFields[0].getText());
				String title = textFields[1].getText();
				String author = textFields[2].getText();
				int stock = Integer.parseInt(textFields[3].getText());
				String date = textFields[4].getText();
				String isbn = textFields[5].getText();
				String country = textFields[6].getText();
				String type = textFields[7].getText();
				String language = textFields[8].getText();
				String image = textFields[9].getText();
								
				BookModel temp = new BookModel(id, title, author, stock, date, isbn, country, type, language, image);
				
				client.insert(temp.getProperties(), Table.BOOKS);
			}
			
			else if(type.equals("cd"))
			{	
				int id = Integer.parseInt(textFields[0].getText());
				String title = textFields[1].getText();
				String artist = textFields[2].getText();
				int stock = Integer.parseInt(textFields[3].getText());
				String year = textFields[4].getText();
				//String isbn = textFields[5].getText();
				String country = textFields[5].getText();
				String type = textFields[6].getText();
				String language = textFields[7].getText();
				String image = textFields[8].getText();
								
				CDModel temp = new CDModel(id, stock, title, country, type, language, artist, year, image);
				
				client.insert(temp.getProperties(), Table.CDS);
			}
			
			else if(type.equals("movie"))
			{	
				int id = Integer.parseInt(textFields[0].getText());
				String title = textFields[1].getText();
				String director = textFields[2].getText();
				int stock = Integer.parseInt(textFields[3].getText());
				String year = textFields[4].getText();
				//String isbn = textFields[5].getText();
				String country = textFields[5].getText();
				String type = textFields[6].getText();
				String language = textFields[7].getText();
				String image = textFields[8].getText();
				
				MovieModel temp = new MovieModel(id, stock, title, country, type, language, director, year, image);
				
				client.insert(temp.getProperties(), Table.MOVIES);
			}
			dispose();
		}
		if(e.getSource().equals(reset))
		{
			System.out.println("Resetting fields");
			
			for(int i = 0; i < numFields; i++)
			{
				textFields[i].setText("");
			}

		}
	}
}
