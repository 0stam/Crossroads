package simulation;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import misc.Position;

public class Setup {
	public static World getWorld() {
		World world = new World();
		
		// Straight roads
		List<Position> westEast = new ArrayList<Position>(Arrays.asList(
				new Position(0, 105), new Position(200, 105)
			));
		
		List<Position> eastWest = new ArrayList<Position>(Arrays.asList(
				new Position(200, 95), new Position(0, 95)
			));
		
		List<Position> northSouth = new ArrayList<Position>(Arrays.asList(
				new Position(95, 0), new Position(95, 200)
			));
		
		List<Position> southNorth = new ArrayList<Position>(Arrays.asList(
				new Position(105, 200), new Position(105, 0)
			));
		
		// Turns to the right
		List<Position> westSouth = new ArrayList<Position>(Arrays.asList(
				new Position(0, 105), new Position(95, 105), new Position(95, 200)
			));
		
		List<Position> eastNorth = new ArrayList<Position>(Arrays.asList(
				new Position(200, 95), new Position(105, 95), new Position(105, 0)
			));
		
		List<Position> northWest = new ArrayList<Position>(Arrays.asList(
				new Position(95, 0), new Position(95, 95), new Position(0, 95)
			));
		
		List<Position> southEast = new ArrayList<Position>(Arrays.asList(
				new Position(105, 200), new Position(105, 105), new Position(200, 105)
			));
		
		// Turns to the left
		List<Position> westNorth = new ArrayList<Position>(Arrays.asList(
				new Position(0, 105), new Position(95, 105), new Position(95, 95), new Position(105, 95), new Position(105, 0)
			));
		
		List<Position> eastSouth = new ArrayList<Position>(Arrays.asList(
				new Position(200, 95), new Position(105, 95), new Position(105, 105), new Position(95, 105), new Position(95, 200)
			));
		
		List<Position> northEast = new ArrayList<Position>(Arrays.asList(
				new Position(95, 0), new Position(95, 95), new Position(105, 95), new Position(105, 105), new Position(200, 105)
			));
		
		List<Position> southWest = new ArrayList<Position>(Arrays.asList(
				new Position(105, 200), new Position(105, 105), new Position(95, 105), new Position(95, 95), new Position(0, 95)
			));
		
		List<Road> roads = new ArrayList<Road>(Arrays.asList(
				new Road(westEast), new Road(eastWest), new Road(northSouth), new Road(southNorth),
				new Road(westSouth), new Road(eastNorth), new Road(northWest), new Road(southEast),
				new Road(westNorth), new Road(eastSouth), new Road(northEast), new Road(southWest)
			));
		
		world.setRoads(roads);
		
		
		List<Car> cars = new ArrayList<Car>(Arrays.asList(
				new Car(0, 13.9, 0, 5, 0, roads.get(8), new AIDriver(), Color.white),
				new Car(0, 13.9, 0, 5, 0, roads.get(9), new AIDriver(), Color.yellow),
				new Car(0, 13.9, 0, 5, 0, roads.get(10), new AIDriver(), Color.red),
				new Car(0, 13.9, 0, 5, 0, roads.get(11), new AIDriver(), Color.blue)
			));
		
		world.setCars(cars);
		
		return world;
	}
}
