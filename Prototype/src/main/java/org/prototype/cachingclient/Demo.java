package org.prototype.cachingclient;

import org.prototype.cache.BundledShapeCache;
import org.prototype.shapes.Shape;

public final class Demo {
  private Demo() {
    super();
  }

  public static void main(String[] args) {
        final BundledShapeCache cache = new BundledShapeCache();

        final Shape shape1 = cache.get("Big green circle");
        final Shape shape2 = cache.get("Medium blue rectangle");
        final Shape shape3 = cache.get("Medium blue rectangle");

        System.out.println("Shape 1: " + shape1 + (shape1 != null ? " Color: " + shape1.color : ""));
        System.out.println("Shape 2: " + shape2 + (shape2 != null ? " Color: " + shape2.color : ""));
        System.out.println("Shape 3: " + shape3 + (shape3 != null ? " Color: " + shape3.color : ""));


        if (shape1 != null && shape2 != null) {
            if (shape1 != shape2 && !shape1.equals(shape2)) {
                System.out.println("\nBig green circle != Medium blue rectangle (yay!)");
            } else {
                System.out.println("\nBig green circle == Medium blue rectangle (booo!)");
            }
        } else {
            System.out.println("\nCould not retrieve one or both shapes for first comparison.");
        }

        if (shape2 != null && shape3 != null) {
            if (shape2 != shape3) {
                System.out.println("Medium blue rectangles are two different objects (yay!)");
                if (shape2.equals(shape3)) {
                    System.out.println("And they are identical (yay!)");
                } else {
                    System.out.println("But they are not identical (booo!)");
                }
            } else {
                System.out.println("Rectangle objects are the same (booo!)");
            }
        } else {
             System.out.println("Could not retrieve one or both shapes for second comparison (shape2, shape3).");
        }
    }
} 