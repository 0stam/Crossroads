package simulation;

import java.util.ArrayList;
import java.util.List;

public class World {
	// Fields
	List<Road> roads;
	List<Car> cars;
	TrafficStrategy trafficStrategy;
	
	// Constructor
	public World() {
		roads = new ArrayList<Road>();
		cars = new ArrayList<Car>();
	}
	
	public World(TrafficStrategy trafficStrategy) {
		this();
		
		this.trafficStrategy = trafficStrategy;
	}
	
	public World(List<Road> roads, List<Car> cars, TrafficStrategy trafficStrategy) {
		this(trafficStrategy);
		
		this.roads = roads;
		this.cars = cars;
	}
	
	// Getters
	public List<Road> getRoads() {
		return roads;
	}
	
	public List<Car> getCars() {
		return cars;
	}
	
	public TrafficStrategy getTrafficStrategy() {
		return trafficStrategy;
	}
	
	// Setters
	public void setRoads(List<Road> roads) {
		this.roads = roads;
	}
	
	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
	
	public void setTrafficStrategy(TrafficStrategy trafficStrategy) {
		this.trafficStrategy = trafficStrategy;
	}
	
	// Other methods
	public String toString() {
		String result = "Roads:\n";
		
		for (int i = 0; i < roads.size(); i++) {
			result += roads.get(i) + "\n";
		}
		
		result += "Cars:\n";
		
		for (int i = 0; i < cars.size(); i++) {
			result += cars.get(i) + "\n";
		}
		
		result += "Strategy: " + trafficStrategy;
		
		return result;
	}
	
	public void process(double delta) {
		for (Car car : cars) {
			car.makeAccelerationDecision(roads, cars);
		}
		
		for (int i = 0; i < cars.size(); i++) {
			Car car = cars.get(i);
			
			// Update position
			double position = car.getPosition();
			position += car.getVelocity() * delta;
			position += car.getAcceleration() * delta * delta / 2;
			
			car.setPosition(position);
			
			if (car.getPosition2D() == null) { // If car left the road, remove it
				cars.remove(i);
				i--;
			}
			
			// Update velocity
			car.setVelocity(car.getVelocity() + car.getAcceleration() * delta);
			
			if (car.getVelocity() < 0) { // Make sure car velocity is in bounds
				car.setVelocity(0);
			} else if (car.getVelocity() > car.getMaxVelocity()) {
				car.setVelocity(car.getMaxVelocity());
			}
		}
	}
}
