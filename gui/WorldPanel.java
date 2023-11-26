package gui;

import java.awt.*;
import javax.swing.*;
import java.util.List;

import simulation.*;
import misc.Position;

public class WorldPanel extends JPanel {
	// Fields
	private World world;
	
	private int roadThickness = 4;
	private double zoom = 7;
	
	// Constructors
	public WorldPanel() {
		world = new World();
	}
	
	public WorldPanel(World world) {
		this.world = world;
	}
	
	// Getters
	public World getWorld() {
		return world;
	}
	
	// Setters
	public void setWorld(World world) {
		this.world = world;
	}
	
	// Other methods
	public void paintGrass(Graphics2D g) {
		g.setColor(new Color(0, 255, 0));
		g.fillRect(0, 0, getWidth(), getHeight());
	}
	
	public void paintCars(Graphics2D g) {
		List<Car> cars = world.getCars();
		
		for(Car car : cars) {
			g.setColor(car.getColor());
			
			Position pos = car.getPosition2D();
			
			int startX = (int) ((pos.getX() - (double) roadThickness / 2) * zoom);
			int startY = (int) ((pos.getY() - (double) roadThickness / 2) * zoom);
			
			g.fillOval(startX, startY, (int) (roadThickness * zoom), (int) (roadThickness * zoom));
		}
	}
	
	public void paintRoads(Graphics2D g) {
		List<Road> roads = world.getRoads();
		
		g.setColor(Color.black);
		
		for (Road road : roads) {
			List<Position> path = road.getPath();
			
			for (int i = 0; i < path.size() - 1; i++) {
				int startX = (int) Math.min(path.get(i).getX(), path.get(i + 1).getX()) - roadThickness;
				int startY = (int) Math.min(path.get(i).getY(), path.get(i + 1).getY()) - roadThickness;
				
				int width = (int) Math.abs(path.get(i).getX() - path.get(i + 1).getX()) + roadThickness * 2;
				int height = (int) Math.abs(path.get(i).getY() - path.get(i + 1).getY()) + roadThickness * 2;
				
				startX *= zoom;
				startY *= zoom;
				width *= zoom;
				height *= zoom;
				
				g.fillRect(startX, startY, width, height);
			}
		}
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		
		g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		paintGrass(g2D);
		paintRoads(g2D);
		paintCars(g2D);
	}
}
