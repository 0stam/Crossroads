package simulation;

import java.util.List;

public interface CarStrategy {
	void makeAccelerationDecision(Car controlledCar, List<Road> roads, List<Car> cars);
}
