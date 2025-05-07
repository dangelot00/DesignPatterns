package org.composite;

import org.composite.editor.ImageEditor;
import org.composite.shapes.Circle;
import org.composite.shapes.CompoundShape;
import org.composite.shapes.Dot;
import org.composite.shapes.Rectangle;

import java.awt.Color;

public final class Demo {
  private Demo() {
    super();
  }

  public static void main(String[] args) {
    final ImageEditor editor = new ImageEditor();

    editor.loadShapes(
        new Circle(10, 10, 10, Color.BLUE),

        new CompoundShape(
            new Circle(110, 110, 50, Color.RED),
            new Dot(160, 160, Color.RED)
        ),

        new CompoundShape(
            new Rectangle(250, 250, 100, 100, Color.GREEN),
            new Dot(240, 240, Color.GREEN),
            new Dot(240, 360, Color.GREEN),
            new Dot(360, 360, Color.GREEN),
            new Dot(360, 240, Color.GREEN)
        )
    );
  }
} 