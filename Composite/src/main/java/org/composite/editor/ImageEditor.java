package org.composite.editor;

import org.composite.shapes.CompoundShape;
import org.composite.shapes.Shape;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ImageEditor {
    private EditorCanvas canvas;
    private CompoundShape allShapes = new CompoundShape();

    public ImageEditor() {
        canvas = new EditorCanvas();
    }

    public void loadShapes(Shape... shapes) {
        allShapes.clear();
        allShapes.add(shapes);
        canvas.refresh();
    }

    private class EditorCanvas extends Canvas {
        JFrame frame;

        private static final int PADDING = 10;

        EditorCanvas() {
            createFrame();
            refresh();
            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    allShapes.unSelect();
                    boolean childSelected = allShapes.selectChildAt(e.getX(), e.getY());
                    
                    if (!childSelected && allShapes.isInsideBounds(e.getX(), e.getY())) {
                        allShapes.select();
                    }
                    e.getComponent().repaint();
                }
            });
        }

        void createFrame() {
            frame = new JFrame("Composite Pattern - Shapes Editor");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);

            JPanel contentPanel = new JPanel();
            Border padding = BorderFactory.createEmptyBorder(PADDING, PADDING, PADDING, PADDING);
            contentPanel.setBorder(padding);
            contentPanel.setLayout(new BorderLayout());
            frame.setContentPane(contentPanel);

            frame.add(this, BorderLayout.CENTER);
            frame.setVisible(true);
            frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(allShapes.getX() + allShapes.getWidth() + PADDING, 
                                 allShapes.getY() + allShapes.getHeight() + PADDING);
        }

        void refresh() {
            frame.pack();
            this.repaint();
        }

        @Override
        public void paint(Graphics graphics) {
            allShapes.paint(graphics);
        }
    }
} 