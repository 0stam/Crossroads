package simulation;

import java.util.List;
import java.awt.Color;

import misc.Position;


public class Car {
	// Fields
	private double position; // In meters along the road
	private double maxVelocity;
	private double velocity;
	private double maxAcceleration;
	private double acceleration;
	
	Road road;
	CarStrategy strategy;
	
	Color color;
	
	// Constructors
	public Car() {
		position = 0;
		maxVelocity = 13.9;
		velocity = 0;
		acceleration = 0;
		
		road = null;
		strategy = null;
		
		color = Color.white;
	}
	
	public Car(double position, double maxVelocity, double velocity, double maxAcceleration, double acceleration, Road road, CarStrategy strategy, Color color) {
		this.position = position;
		this.maxVelocity = maxVelocity;
		this.velocity = velocity;
		this.maxAcceleration = maxAcceleration;
		this.acceleration = acceleration;
		this.road = road;
		this.strategy = strategy;
		this.color = color;
	}
	
	// Getters
	public double getPosition() {
		return position;
	}
	
	public double getMaxVelocity() {
		return maxVelocity;
	}
	
	public double getVelocity() {
		return velocity;
	}
	
	public double getMaxAcceleration() {
		return maxAcceleration;
	}
	
	public double getAcceleration() {
		return acceleration;
	}

	public Road getRoad() {
		return road;
	}

	public CarStrategy getStrategy() {
		return strategy;
	}
	
	public Color getColor() {
		return color;
	}
	
	public Position getPosition2D() {
		return road.getPosition2D(position);
	}
	
	// Setters
	public void setPosition(double position) {
		this.position = position;
	}
	
	public void setMaxVelocity(double maxVelocity) {
		this.maxVelocity = maxVelocity;
	}
	
	public void setVelocity(double velocity) {
		this.velocity = velocity;
	}
	
	public void setMaxAcceleration(double maxAcceleration) {
		this.maxAcceleration = maxAcceleration;
	}
	
	public void setAcceleration(double acceleration) {
		this.acceleration = acceleration;
	}

	public void setRoad(Road road) {
		this.road = road;
	}

	public void setStrategy(CarStrategy strategy) {
		this.strategy = strategy;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	// Other methods
	public String toString() {
		return "Position: " + position + " Velocity: " + velocity + " Acceleration: " + acceleration + " Road: " + road.toString() + " Strategy: " + strategy.toString();
	}
	
	public void makeAccelerationDecision(List<Road> roads, List<Car> cars) {
		strategy.makeAccelerationDecision(this, roads, cars);
	}
}
