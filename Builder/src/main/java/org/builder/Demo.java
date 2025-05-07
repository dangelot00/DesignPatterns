package org.builder;

import org.builder.builders.impl.CarBuilder;
import org.builder.builders.impl.CarManualBuilder;
import org.builder.cars.Car;
import org.builder.cars.Manual;
import org.builder.director.Director;

/**
 * The Demo class.
 */
public final class Demo {

  private Demo() {
    super();
  }

  public static void main(String[] args) {
    // We use director since it may know different build steps/technologies for different constructor.
    final Director director = new Director();

    final CarBuilder builder = new CarBuilder();
    director.constructSportsCar(builder);
    final Car car = builder.getResult();
    System.out.println("Car built:\n" + car.print());

    final CarManualBuilder manualBuilder = new CarManualBuilder();
    director.constructSportsCar(manualBuilder);
    final Manual carManual = manualBuilder.getResult();
    System.out.println("\nCar manual built:\n" + carManual.print());
  }

}