# Decorator Design Pattern

## 1. Intent

Decorator is a structural design pattern that allows adding new behaviors to objects dynamically by placing them inside special wrapper objects, called *decorators*. It enables extending functionality without altering the original class structure, and multiple decorators can be stacked.

## 2. Problem

You want to add additional responsibilities to an individual object, not to an entire class. Subclassing might be impractical because the number of independent extensions could produce a large number of subclasses, or a class definition may be hidden or otherwise unavailable for subclassing.

## 3. Solution

The Decorator pattern encloses the original object (component) inside another object (decorator) that has the same interface. The decorator adds its own behavior either before or after delegating the call to the wrapped component.

Both the component and the decorator implement a common interface. This allows decorators to be wrapped by other decorators, creating a stack of responsibilities.

## 4. Structure

1.  **Component**: Defines the interface for objects that can have responsibilities added to them dynamically.
2.  **ConcreteComponent**: A class that implements the Component interface – the object to which additional responsibilities can be attached.
3.  **Decorator (Abstract)**: Maintains a reference to a Component object and defines an interface that conforms to Component's interface. It delegates work to the wrapped component.
4.  **ConcreteDecorator**: Adds responsibilities to the component it decorates. It implements the Decorator interface and adds its own behavior before or after forwarding the request to the wrapped component.

## 5. Applicability

Use the Decorator pattern when:

*   You want to add responsibilities to individual objects dynamically and transparently (without affecting other objects).
*   Responsibilities can be withdrawn.
*   Extending a class through subclassing is impractical due to a large number of independent extensions or when a class definition is hidden/unavailable.
*   Common in Java I/O streams (`java.io.InputStream`, `OutputStream`, `Reader`, `Writer` subclasses often accept objects of their own type in constructors).

## 6. How to Implement

1.  Ensure the business domain can be represented as a primary component with optional layers of features.
2.  Create a Component interface that defines methods common to both the original object and its decorators.
3.  Create a ConcreteComponent class that implements the Component interface.
4.  Create an abstract Decorator class that also implements the Component interface. This class should have a field for referencing a wrapped Component object, initialized via the constructor.
5.  The Decorator class delegates all work to the wrapped component by default.
6.  Create ConcreteDecorator classes that extend the abstract Decorator. A ConcreteDecorator executes its behavior and then (or before) calls the parent method, which, in turn, calls the wrapped object's behavior.

## 7. Pros and Cons

**Pros:**

*   More flexibility than static inheritance for adding responsibilities.
*   Avoids feature-laden classes high up in the hierarchy.
*   Responsibilities can be added or removed at runtime by composing decorators differently.
*   Decorators can be composed recursively.

**Cons:**

*   A decorator and its component aren't identical (in terms of `instanceof` checks if not careful with interfaces).
*   Can lead to a system with many small, similar-looking objects, making it harder to understand the configuration if overused.
*   The client code can become complex if it needs to instantiate and assemble a specific chain of decorators.

## 8. Relations with Other Patterns

*   **Adapter**: Changes an object's interface, while Decorator enhances its responsibilities. An adapter provides a different interface to the wrapped object.
*   **Composite**: Decorators can be viewed as a degenerate Composite with only one child component. However, Decorator adds responsibilities, whereas Composite focuses on object aggregation and treating a group of objects as a single object.
*   **Strategy**: Decorator changes an object's "skin" (adds behavior around existing methods), while Strategy changes its "guts" (provides different algorithms for a method).
*   **Facade**: Provides a simplified interface to a subsystem, while Decorator adds responsibilities to an object. 