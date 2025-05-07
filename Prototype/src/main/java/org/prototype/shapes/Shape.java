package org.prototype.shapes;

import java.util.Objects;

public abstract class Shape {
    public int x;
    public int y;
    public String color;

    public Shape() {
      super();
    }

    public Shape(Shape target) {
      super();
      if (target != null) {
        this.x = target.x;
        this.y = target.y;
        this.color = target.color;
      }
    }

    @Override
    public abstract Shape clone();

    @Override
    public boolean equals(Object object2) {
      if (!(object2 instanceof final Shape shape2)) return false;
      return shape2.x == x && shape2.y == y && Objects.equals(shape2.color, color);
    }
} 