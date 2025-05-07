# Prototype Design Pattern

## 1. Intent

Prototype is a creational design pattern that lets you copy existing objects without making your code dependent on their classes. It allows cloning objects, even complex ones, without coupling to their specific classes.

## 2. Problem

Creating an exact copy of an object by instantiating a new object of the same class and then copying all field values has limitations:

1.  **Private Fields**: Some fields may be private and inaccessible from outside the object.
2.  **Class Dependency**: Requires knowing the object's concrete class, leading to dependencies. This is problematic if you only know the interface an object implements, not its concrete class.

## 3. Solution

The Prototype pattern delegates the cloning process to the objects being cloned. It declares a common interface (or abstract class) for all objects that support cloning, typically with a single `clone()` method.

The `clone()` method implementation in each class creates a new object of the current class and copies all field values (including private ones, as objects of the same class can access each other's private fields) from the original object to the new one.

An object that supports cloning is called a *prototype*. When objects have many fields or configurations, cloning pre-configured prototypes can be an alternative to subclassing or manual construction.

## 4. Structure

**Basic Implementation:**

1.  **Prototype (Interface/Abstract Class)**: Declares the cloning method (e.g., `clone()`).
2.  **Concrete Prototype**: Implements the cloning method. It copies its data to the clone and may handle edge cases like cloning linked objects or resolving recursive dependencies.
3.  **Client**: Can produce a copy of any object that implements the Prototype interface, without needing to know its concrete class.

**Prototype Registry (Optional):**

1.  **Prototype Registry**: Provides a way to access frequently-used, pre-built prototype objects ready to be copied. Often implemented as a map from a name/key to a prototype object.

## 5. Applicability

Use the Prototype pattern when:

*   Your code shouldn't depend on the concrete classes of objects you need to copy (e.g., when working with objects from third-party code via an interface).
*   You want to reduce the number of subclasses that differ only in their initialization. Instead of many subclasses, you can have a few prototypes configured in various ways and clone them.

## 6. How to Implement

1.  Create the Prototype interface/abstract class with a `clone()` method. Or, add `clone()` to an existing class hierarchy.
2.  Each Concrete Prototype class must implement the `clone()` method. Typically, this involves:
    *   Defining a copy constructor (a constructor that takes an object of the same class as an argument) to copy all fields (including those inherited from parent classes by calling `super(source)`).
    *   The `clone()` method then calls this copy constructor: `return new ConcretePrototype(this);`.
3.  (Optional) Create a Prototype Registry (e.g., a class with a map) to store and manage pre-configured prototype instances. The client requests a clone from the registry by some identifier.

## 7. Pros and Cons

**Pros:**

*   Clone objects without coupling to their concrete classes.
*   Avoid repeated initialization code by cloning pre-built prototypes.
*   Conveniently produce complex objects.
*   An alternative to inheritance for configuring complex objects.

**Cons:**

*   Cloning complex objects with circular references or deep-copying requirements can be tricky.
    *   Java's `Cloneable` interface and `Object.clone()` provide a shallow copy by default. Deep copy needs to be implemented manually if required.

## 8. Relations with Other Patterns

*   Designs may start with **Factory Method** and evolve to **Abstract Factory**, **Prototype**, or **Builder**.
*   **Abstract Factory** classes can be based on Factory Methods or use **Prototype** to compose methods.
*   **Prototype** can be useful for saving copies of **Command** objects in history.
*   Heavy use of **Composite** and **Decorator** can benefit from **Prototype** for cloning complex structures.
*   **Prototype** avoids inheritance drawbacks but requires careful (potentially complex) clone initialization. **Factory Method** relies on inheritance.
*   Can be a simpler alternative to **Memento** if the object's state is straightforward and has no complex external resource links.
*   **Abstract Factories**, **Builders**, and **Prototypes** can all be implemented as **Singletons**. 