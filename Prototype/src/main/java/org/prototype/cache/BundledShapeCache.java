package org.prototype.cache;

import org.prototype.shapes.Circle;
import org.prototype.shapes.Rectangle;
import org.prototype.shapes.Shape;

import java.util.HashMap;
import java.util.Map;

public class BundledShapeCache {
    private final Map<String, Shape> cache = new HashMap<>();

    public BundledShapeCache() {
      super();
      final Circle circle = new Circle();
      circle.x = 5;
      circle.y = 7;
      circle.radius = 45;
      circle.color = "Green";

      final Rectangle rectangle = new Rectangle();
      rectangle.x = 6;
      rectangle.y = 9;
      rectangle.width = 8;
      rectangle.height = 10;
      rectangle.color = "Blue";

      cache.put("Big green circle", circle);
      cache.put("Medium blue rectangle", rectangle);
    }

    public Shape put(String key, Shape shape) {
        cache.put(key, shape);
        return shape;
    }

    public Shape get(String key) {
        final Shape cachedShape = cache.get(key);
        return cachedShape != null ? cachedShape.clone() : null;
    }
} 