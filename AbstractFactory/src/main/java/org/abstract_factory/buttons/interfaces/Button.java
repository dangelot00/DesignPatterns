package org.abstract_factory.buttons.interfaces;

/**
 * Represents the common interface for all buttons in the Abstract Factory pattern.
 * <p>
 * The Abstract Factory design pattern organizes products into multiple families, where each
 * family is represented by a separate class hierarchy.
 * </p>
 *
 * <p>
 * This interface serves as the base for all button implementations across different families.
 * </p>
 *
 * <p>
 * Usage:
 * Implement this interface to define the behavior of specific button types within a product
 * family.
 * </p>
 */
public interface Button {

  /**
   * Defines the action to be performed when the button is clicked.
   */
  void click();
}