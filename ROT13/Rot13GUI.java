import java.awt.*;
import java.io.*;
import java.util.Scanner;

import javax.swing.*;

public class Rot13GUI extends JFrame {
	private static final long serialVersionUID = 1L;
	public static final String TEXT_FROM_FILE = "Text From File...";
	public static final String CIPHER = "Encrypt/Decrypt";
	public static final String QUIT = "Quit";
	public static final String ABOUT_ROT13 = "About ROT13";
	public static final String ROT_13_INFO = 
			"ROT13 is a very simple substitution cipher where letters are encoded/decoded by\n" +
			"shifting over 13 places. Encryption/Decryption is done using the same algorithm.\n" +
			"Is it secure? Of course not. Is it fun to use? Absolutely.";
	public static final String ABOUT_AUTHOR = "About Author";
	public static final String AUTHOR_INFO = 
			"Copyright (c) 2014, Some guy who was bored during a Thursday afternoon.";
	
	private JTextArea textDisplay;
	private JFileChooser fileChooser;
	
	public Rot13GUI() {
		initialize();
	}
	
	private void initialize() {
		setTitle("ROT13 Cipher");
		setLocation(100, 100);
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		Rot13Listener listener = new Rot13Listener(this);
		createMenu(listener);
		createLayout(listener);
		
		fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
	}
	
	private void createMenu(Rot13Listener listener) {
		JMenuBar menuBar  = new JMenuBar();
		JMenu menu = new JMenu("File");

		JMenuItem item = new JMenuItem(TEXT_FROM_FILE);   
		item.addActionListener(listener);
		menu.add(item);

		menu.addSeparator();           
	    
		item = new JMenuItem(QUIT);       
		item.addActionListener(listener);
		menu.add(item);
		
		menuBar.add(menu);
		
		menu = new JMenu("About...");
		
		item = new JMenuItem(ABOUT_ROT13);
		item.addActionListener(listener);
		menu.add(item);
		
		menu.addSeparator();   
		
		item = new JMenuItem(ABOUT_AUTHOR);
		item.addActionListener(listener);
		menu.add(item);

		menuBar.add(menu);
		
		setJMenuBar(menuBar);
	}
	
	private void createLayout(Rot13Listener listener) {
		textDisplay = new JTextArea("Text to be encrypted/decrypted");
		textDisplay.setEditable(true);
		add(new JScrollPane(textDisplay), BorderLayout.CENTER);
		
		JButton cipherButton = new JButton(CIPHER);
		cipherButton.addActionListener(listener);
		add(cipherButton, BorderLayout.SOUTH);
	}
	
	public String getText() {
		return textDisplay.getText();
	}
	
	public void setText(String text) {
		textDisplay.setText(text);
	}
	
	public void importFromFile() {
		try {
			fileChooser.showOpenDialog(null);
			File filename = fileChooser.getSelectedFile();
			
			if (filename != null) {
				textDisplay.setText(null);
				Scanner reader = new Scanner(filename);
				
				while ( reader.hasNextLine() )
					textDisplay.append(reader.nextLine() + "\n");
				
				reader.close();
			}
		} catch (IOException ioe) {
			JOptionPane.showMessageDialog(this, "File Input Error", ioe.getMessage(), JOptionPane.ERROR_MESSAGE);
		}
	}
}
