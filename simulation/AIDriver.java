package simulation;

import java.util.List;

public class AIDriver implements CarStrategy {
	public String toString() {
		return "AI Driver";
	}
	
	public void makeAccelerationDecision(Car controlledCar, List<Road> roads, List<Car> cars) {
		if (controlledCar.getVelocity() < controlledCar.getMaxVelocity()) {
			controlledCar.setAcceleration(controlledCar.getMaxAcceleration());
		}
	}
}
