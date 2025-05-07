package org.builder.builders.interfaces;

import org.builder.cars.CarType;
import org.builder.components.Engine;
import org.builder.components.GPSNavigator;
import org.builder.components.Transmission;
import org.builder.components.TripComputer;

/**
 * The Builder interface defines all possible ways for constructing a product.
 * Implementations of this interface are responsible for defining the specific
 * steps required to assemble an object of a particular type.
 */
public interface Builder {
  void setCarType(CarType type);

  void setSeats(int seats);

  void setEngine(Engine engine);

  void setTransmission(Transmission transmission);

  void setTripComputer(TripComputer tripComputer);

  void setGPSNavigator(GPSNavigator gpsNavigator);
}
