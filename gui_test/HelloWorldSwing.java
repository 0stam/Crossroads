package gui_test;

/*
 * HelloWorldSwing.java requires no other files. 
 */
import javax.swing.*;
import java.awt.event.*;

public class HelloWorldSwing implements ActionListener {
	JFrame frame;
	JButton button;
	CustomPanel panel;
	
	public static void main(String args[]) {
		HelloWorldSwing gui = new HelloWorldSwing();
		gui.run();
	}
	
    public void run() {
    	frame = new JFrame();
    	button = new JButton("Hello");
    	panel = new CustomPanel();
    	
    	button.addActionListener(this);
    	
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	frame.getContentPane().add(button);
    	frame.getContentPane().add(panel);
    	
    	frame.setSize(300, 300);
    	
    	frame.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent event) {
    	button.setText("Clicked");
    }
}