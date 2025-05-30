package org.builder.cars;

import org.builder.components.Engine;
import org.builder.components.GPSNavigator;
import org.builder.components.Transmission;
import org.builder.components.TripComputer;

/**
 * Car is a product class.
 */
public class Car {
  private final CarType carType;
  private final int seats;
  private final Engine engine;
  private final Transmission transmission;
  private final TripComputer tripComputer;
  private final GPSNavigator gpsNavigator;
  private double fuel = 0;

  public Car(CarType carType, int seats, Engine engine, Transmission transmission,
      TripComputer tripComputer, GPSNavigator gpsNavigator) {
    super();

    this.carType = carType;
    this.seats = seats;
    this.engine = engine;
    this.transmission = transmission;
    this.tripComputer = tripComputer;
    if (this.tripComputer != null) {
      this.tripComputer.setCar(this);
    }
    this.gpsNavigator = gpsNavigator;
  }

  public CarType getCarType() {
    return carType;
  }

  public double getFuel() {
    return fuel;
  }

  public void setFuel(double fuel) {
    this.fuel = fuel;
  }

  public int getSeats() {
    return seats;
  }

  public Engine getEngine() {
    return engine;
  }

  public Transmission getTransmission() {
    return transmission;
  }

  public TripComputer getTripComputer() {
    return tripComputer;
  }

  public GPSNavigator getGpsNavigator() {
    return gpsNavigator;
  }

  public String print() {
    String info = "CAR\n";
    info += "Type of car: " + carType + "\n";
    info += "Count of seats: " + seats + "\n";
    info += "Engine: volume - " + engine.getVolume() + "; mileage - " + engine.getMileage() + "\n";
    info += "Transmission: " + transmission + "\n";
    if (this.tripComputer != null) {
      info += "Trip Computer: Functional" + "\n";
    } else {
      info += "Trip Computer: N/A" + "\n";
    }
    if (this.gpsNavigator != null) {
      info += "GPS Navigator: Functional" + "\n";
    } else {
      info += "GPS Navigator: N/A" + "\n";
    }
    return info;
  }
}
