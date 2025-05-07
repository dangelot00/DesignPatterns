package org.composite.shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompoundShape extends BaseShape {
    protected List<Shape> children = new ArrayList<>();

    public CompoundShape(Shape... components) {
        super(0, 0, Color.BLACK);
        add(components);
    }

    public void add(Shape component) {
        children.add(component);
    }

    public void add(Shape... components) {
        children.addAll(Arrays.asList(components));
    }

    public void remove(Shape component) {
        children.remove(component);
    }

    public void remove(Shape... components) {
        children.removeAll(Arrays.asList(components));
    }

    public void clear() {
        children.clear();
    }

    @Override
    public int getX() {
        if (children.isEmpty()) {
            return 0;
        }
        int minX = children.get(0).getX();
        for (Shape child : children) {
            if (child.getX() < minX) {
                minX = child.getX();
            }
        }
        return minX;
    }

    @Override
    public int getY() {
        if (children.isEmpty()) {
            return 0;
        }
        int minY = children.get(0).getY();
        for (Shape child : children) {
            if (child.getY() < minY) {
                minY = child.getY();
            }
        }
        return minY;
    }

    @Override
    public int getWidth() {
        if (children.isEmpty()) {
            return 0;
        }
        int maxX = 0;
        final int minX = getX();
        for (Shape child : children) {
            final int childRightExtent = child.getX() - minX + child.getWidth();
            if (childRightExtent > maxX) {
                maxX = childRightExtent;
            }
        }
        return maxX;
    }

    @Override
    public int getHeight() {
        if (children.isEmpty()) {
            return 0;
        }
        int maxY = 0;
        final int minY = getY();
        for (Shape child : children) {
            final int childBottomExtent = child.getY() - minY + child.getHeight();
            if (childBottomExtent > maxY) {
                maxY = childBottomExtent;
            }
        }
        return maxY;
    }

    @Override
    public void move(int x, int y) {
        for (Shape child : children) {
            child.move(x, y);
        }
    }

    @Override
    public boolean isInsideBounds(int x, int y) {
        for (Shape child : children) {
            if (child.isInsideBounds(x, y)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void select() {
        super.select();
    }

    @Override
    public void unSelect() {
        super.unSelect();
        for (Shape child : children) {
            child.unSelect();
        }
    }

    public boolean selectChildAt(int x, int y) {
        for (Shape child : children) {
            if (child.isInsideBounds(x, y)) {
                if (child instanceof CompoundShape) {
                    if (((CompoundShape) child).selectChildAt(x,y)){
                        return true;
                    }
                }
                child.select();
                return true;
            }
        }
        return false;
    }

    @Override
    public void paint(Graphics graphics) {
        if (isSelected()) {
            enableSelectionStyle(graphics);
            graphics.drawRect(getX() - 1, getY() - 1, getWidth() + 1, getHeight() + 1);
            disableSelectionStyle(graphics);
        }

        for (Shape child : children) {
            child.paint(graphics);
        }
    }
} 