package org.prototype.shapes;

public class Circle extends Shape {
  public int radius;

  public Circle() {
    super();
  }

  public Circle(Circle target) {
    super(target);
    if (target != null) {
      this.radius = target.radius;
    }
  }

  @Override
  public Shape clone() {
    return new Circle(this);
  }

  @Override
  public boolean equals(Object object2) {
    if (!(object2 instanceof final Circle shape2) || !super.equals(object2)) {
      return false;
    }
    return shape2.radius == radius;
  }
}