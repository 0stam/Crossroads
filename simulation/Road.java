package simulation;

import java.util.List;

import misc.Position;

public class Road {
	// Fields
	private List<Position> path;
	
	// Constructor
	public Road(List<Position> path) {
		this.path = path;
	}
	
	// Getters
	public List<Position> getPath() {
		return path;
	}
	
	// Setters
	public void setPath(List<Position> path) {
		this.path = path;
	}
	
	// Other methods
	public String toString() {
		String result = "Path:";
		
		for (int i = 0; i < path.size(); i++) {
			result += " " + path.get(i).toString();
		}
		
		return result;
	}
	
	// Convert position from meters along the road to 2D coordinates
	public Position getPosition2D(double position) {
		for (int i = 0; i < path.size() - 1; i++) {
			double distanceX = -(path.get(i).getX() - path.get(i + 1).getX());
			double distanceY = -(path.get(i).getY() - path.get(i + 1).getY());
			
			double distance = Math.sqrt(distanceX * distanceX + distanceY * distanceY);
			
			if (position > distance) {
				position -= distance;
			} else {
				Position result = new Position();
				
				result.setX(path.get(i).getX() + distanceX * (position / distance));
				result.setY(path.get(i).getY() + distanceY * (position / distance));
				
				return result;
			}
		}
		
		return null;
	}
}
