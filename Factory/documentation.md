# Factory Method Design Pattern

## 1. Intent

Factory Method is a creational design pattern that provides an interface for creating objects in a superclass, but allows subclasses to alter the type of objects that will be created.

## 2. Problem

Imagine you're creating a logistics management application. Initially, it only handles transportation by trucks. Most of your code is coupled to the `Truck` class. If you later need to add sea transportation (`Ship` class), you'd have to change the entire codebase. Adding more transportation types would lead to complex conditional logic to switch behaviors based on the transportation object class.

## 3. Solution

The Factory Method pattern suggests replacing direct object construction calls (using `new`) with calls to a special *factory* method. The objects are still created with `new`, but from within this factory method. Objects returned by a factory method are often called *products*.

This allows you to override the factory method in a subclass and change the class of products being created. A key constraint is that these products must share a common base class or interface, and the factory method in the base class should declare its return type as this interface.

Client code that uses the factory method doesn't see a difference between the actual products returned by various subclasses. It treats all products via the abstract interface.

## 4. Structure

1.  **Product**: Declares the interface common to all objects that can be produced by the creator and its subclasses.
2.  **Concrete Products**: Different implementations of the Product interface.
3.  **Creator**: Declares the factory method that returns new product objects. The return type must match the Product interface. The Creator class can also have core business logic related to products. The factory method helps decouple this logic from concrete product classes.
4.  **Concrete Creators**: Override the base factory method to return a different type of product.

## 5. Applicability

Use the Factory Method when:

*   You don't know beforehand the exact types and dependencies of the objects your code should work with. It separates product construction from product use.
*   You want to provide users of your library or framework with a way to extend its internal components. Users can subclass your creator and override the factory method to produce their custom product types.
*   You want to save system resources by reusing existing objects instead of rebuilding them each time (e.g., for resource-intensive objects like database connections). The factory method can return existing objects from a cache or pool.

## 6. How to Implement

1.  Make all products follow the same interface, declaring methods that make sense in every product.
2.  Add an empty factory method in the creator class. Its return type should be the common product interface.
3.  Find all direct calls to product constructors in the creator's code. Replace them with calls to the factory method.
4.  Create creator subclasses for each product type. Override the factory method in these subclasses and move the appropriate construction code there.
5.  If the base factory method becomes empty, make it abstract. Otherwise, it can provide a default implementation.

## 7. Pros and Cons

**Pros:**

*   Avoids tight coupling between the creator and concrete products.
*   *Single Responsibility Principle*: Product creation code is centralized, making it easier to support.
*   *Open/Closed Principle*: New product types can be introduced without breaking existing client code.

**Cons:**

*   The code can become more complicated due to the introduction of many new subclasses (if not an existing hierarchy).

## 8. Relations with Other Patterns

*   Designs often start with **Factory Method** and evolve towards **Abstract Factory**, **Prototype**, or **Builder**.
*   **Abstract Factory** classes are often based on a set of Factory Methods.
*   Can be used with **Iterator** to let collection subclasses return different types of compatible iterators.
*   **Prototype** doesn't use inheritance but requires complex initialization for cloned objects. Factory Method uses inheritance but doesn't need a separate initialization step.
*   Factory Method is a specialization of **Template Method**. A Factory Method can also be a step in a larger Template Method. 