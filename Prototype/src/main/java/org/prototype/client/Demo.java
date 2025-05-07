package org.prototype.client;

import org.prototype.shapes.Circle;
import org.prototype.shapes.Rectangle;
import org.prototype.shapes.Shape;

import java.util.ArrayList;
import java.util.List;

public final class Demo {
  private Demo() {
    super();
  }

  public static void main(String[] args) {
    final List<Shape> shapes = new ArrayList<>();
    final List<Shape> shapesCopy = new ArrayList<>();

    final Circle circle = new Circle();
    circle.x = 10;
    circle.y = 20;
    circle.radius = 15;
    circle.color = "red";
    shapes.add(circle);

    final Circle anotherCircle = (Circle) circle.clone();
    shapes.add(anotherCircle);

    final Rectangle rectangle = new Rectangle();
    rectangle.width = 10;
    rectangle.height = 20;
    rectangle.x = 30;
    rectangle.y = 40;
    rectangle.color = "blue";
    shapes.add(rectangle);

    cloneAndCompare(shapes, shapesCopy);
  }

  private static void cloneAndCompare(List<Shape> shapes, List<Shape> shapesCopy) {
    for (Shape shape : shapes) {
      shapesCopy.add(shape.clone());
    }

    for (int i = 0; i < shapes.size(); i++) {
      if (shapes.get(i) != shapesCopy.get(i)) {
        System.out.println(i + ": Shapes are different objects (yay!)");
        if (shapes.get(i).equals(shapesCopy.get(i))) {
          System.out.println(i + ": And they are identical (yay!)");
        } else {
          System.out.println(i + ": But they are not identical (booo!)");
        }
      } else {
        System.out.println(i + ": Shape objects are the same (booo!)");
      }
    }
  }
} 