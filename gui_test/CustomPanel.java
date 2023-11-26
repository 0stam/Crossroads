package gui_test;

import java.awt.*;
import javax.swing.*;

public class CustomPanel extends JPanel {
	public void paintComponent(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		GradientPaint gradient = new GradientPaint(70, 70, Color.red, 150, 150, Color.yellow);
		g2D.setPaint(gradient);
		g2D.fillRect(20,  2, 200, 200);
	}
}
