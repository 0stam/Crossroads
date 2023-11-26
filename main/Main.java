package main;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import misc.Position;
import simulation.*;
import gui.GUI;

public class Main {
	public static void main(String args[]) {
		World world = Setup.getWorld();
		
		System.out.println(world);
		
		GUI gui = new GUI();
		gui.setup();
		gui.setWorld(world);
		gui.draw();
		
		while (true) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			world.process(0.01);
			gui.draw();
		}
	}
}
