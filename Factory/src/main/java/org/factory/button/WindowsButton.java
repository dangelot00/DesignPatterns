package org.factory.button;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Windows button implementation.
 */
public class WindowsButton implements Button {
  JPanel panel = new JPanel();
  JFrame frame = new JFrame();
  JButton button;

  @Override
  public void render() {
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    final JLabel label = new JLabel("Hello World!");
    label.setOpaque(true);
    label.setBackground(new Color(235, 233, 126));
    label.setFont(new Font("Dialog", Font.BOLD, 44));
    label.setHorizontalAlignment(SwingConstants.CENTER);
    panel.setLayout(new FlowLayout(FlowLayout.CENTER));
    frame.getContentPane().add(panel);
    panel.add(label);
    onClick();
    panel.add(button);

    frame.setSize(320, 200);
    frame.setVisible(true);
  }

  @Override
  public void onClick() {
    button = new JButton("Exit");
    button.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        frame.setVisible(false);
        System.exit(0);
      }
    });
  }
} 