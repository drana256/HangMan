import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

class GUI implements ActionListener
{
    static JFrame frame = new JFrame("Hang Man");           //creating a frame
    JPanel panel = new JPanel(new GridBagLayout());         //creating a panel
    GridBagConstraints gbc = new GridBagConstraints();      //creating a GridBagConstraints

    JLabel hangmanLabel = new JLabel("Hang Man");           //creating a label
    static JTextArea _dash = new JTextArea();               //creating a text area for the dashes


    JButton enter = new JButton(new ImageIcon("PlayButton.png"));      //play button
    JButton exit = new JButton(new ImageIcon("ExitButton.png"));        //exit button
	GUI()
    {
		enter.addActionListener(this);
        exit.addActionListener(this);

        gbc.fill = GridBagConstraints.HORIZONTAL;           //setting the label to fill the grid
        panel.add(hangmanLabel, gbc);                       //adding the elements
        Font font = new Font("RAVIE", Font.BOLD, 50);       //setting the font type and font size of hangman label
        hangmanLabel.setFont(font);
        gbc.gridx = 0;              //setting the position of the label
        gbc.gridy = 1;     
        gbc.gridwidth = 3;

        Font dashFont = new Font("GOUDYSTO", Font.BOLD, 30);    //setting the font type and font size of _dash text area
        _dash.setFont(dashFont);
        _dash.setEditable(false);           //making the text area uneditable
        _dash.setOpaque(false);             
        panel.add(_dash, gbc);              //adding the elements
        gbc.gridx = 0;  
        gbc.gridy = 2;
        gbc.ipadx = 20;
        gbc.ipady = 50;
        gbc.gridwidth = 1;

        panel.add(enter, gbc);              //adding the elements
        enter.setOpaque(false);             //making the button transparent
        enter.setContentAreaFilled(false);  //removing the filled content of button
        enter.setBorderPainted(false);      //removing the border of the button
        gbc.gridx = 0;  
        gbc.gridy = 3;
        gbc.gridwidth = 3;

        panel.add(exit, gbc);  
        exit.setOpaque(false);              //making the button transparent
        exit.setContentAreaFilled(false);   //removing the filled content of button
        exit.setBorderPainted(false);       //removing the border of the button
        gbc.gridx = 0;  
        gbc.gridy = 7;
        gbc.gridwidth = 3;      

        WindowListener wndCloser = new WindowAdapter()  //setting the window listner so that the program closes when close button is pressed
        {
            public void windowClosing(WindowEvent e)
            {
                // exit the system
                System.exit(0);
            }
        };
        frame.addWindowListener(wndCloser);
        //add the content
        frame.getContentPane().add(panel);
        // Function to set size of JFrame.
        frame.setSize(500, 600);
        // Function to set visiblity of JFrame.
        frame.setVisible(true);
        
    }
    public static char returnIput() 
    {
        
        String text = JOptionPane.showInputDialog(frame, "Enter a letter: ");    // get the value of the JTextField in all caps    
        String upperText = text.toUpperCase();      //changing the user input into all caps 
        char ch = upperText.charAt(0);       // get the first letter as char
        return ch;
    }
    
    public static void set_dash(String text)        //method to set the text of _dash text area
    {
        _dash.setText(text);
    }

    public static void failedAttempt()      //method to display pop up when there is a worng entry
    {
        JOptionPane.showMessageDialog(frame, "Try Again");   
    }

    public void actionPerformed(ActionEvent e) 
    {

		if (e.getSource() == exit)      //exits the program when the exit button is pressed
        {
			frame.dispose();
		} 
        else if ((e.getSource() == enter))      //executes the following code when enter button is pressed
        {
			int wordNumer=0;
            int continueGame=0;
            int attempt = 3;
           
            Check.checking(wordNumer,attempt);  //running the game

            continueGame = JOptionPane.showConfirmDialog(frame,"Do You want to continue? ");    //asking user if they want to continue
            while(continueGame==JOptionPane.YES_OPTION)
            {   
                attempt = 3;
                wordNumer ++;
                
                Check.checking(wordNumer, attempt);
            }
		}
	}
}
