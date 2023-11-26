package gui;

import java.awt.Color;

import javax.swing.*;
import simulation.World;

public class GUI {
	private JFrame frame;
	private WorldPanel worldPanel;
	
	public GUI() {
		worldPanel = new WorldPanel();
	}
	
	public void setWorld(World world) {
		worldPanel.setWorld(world);
	}
	
	public void setup() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 700);
		frame.getContentPane().setBackground(Color.GREEN);
		
		frame.getContentPane().add(worldPanel);
		
		frame.setVisible(true);
	}
	
	public void draw() {
		worldPanel.repaint();
	}
	
	
}
