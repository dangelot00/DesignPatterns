package org.abstract_factory.checkboxes.interfaces;

/**
 * Represents the common interface for all checkboxes in the Abstract Factory pattern.
 * <p>
 * The Abstract Factory design pattern organizes products into multiple families, where each
 * family is represented by a separate class hierarchy.
 * </p>
 *
 * <p>
 * This interface serves as the base for all checkbox implementations across different families.
 * </p>
 *
 * <p>
 * Usage:
 * Implement this interface to define the behavior of specific checkbox types within a product
 * family.
 * </p>
 */
public interface Checkbox {

  /**
   * Defines the action to be performed when the checkbox is clicked.
   */
  void toggle();
}