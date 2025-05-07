# Composite Design Pattern

## 1. Intent

Composite is a structural design pattern that lets you compose objects into tree structures and then work with these structures as if they were individual objects. This pattern makes sense when the core model of your app can be represented as a tree.

## 2. Problem

Imagine an application dealing with `Products` and `Boxes`. A `Box` can contain `Products` and other `Boxes`, forming a tree-like structure. Calculating the total price of an order containing such nested structures can be complex if you need to know the specific classes and nesting levels of all items.

## 3. Solution

The Composite pattern suggests working with both simple elements (leaves, e.g., `Product`) and complex elements (containers, e.g., `Box`) through a common interface. This interface declares operations applicable to both, like calculating a price.

For a leaf, the operation (e.g., `getPrice()`) returns its direct value. For a container, the operation iterates over its children, calls their respective `getPrice()` method, and aggregates the results. This allows the client to treat individual objects and compositions of objects uniformly.

## 4. Structure

1.  **Component**: An interface describing operations common to both simple (leaf) and complex (container/composite) elements of the tree.
2.  **Leaf**: A basic element of a tree that doesn't have sub-elements. It performs most of the real work as it has no children to delegate to.
3.  **Container (Composite)**: An element that has sub-elements (children), which can be leaves or other containers. It doesn't know the concrete classes of its children, interacting with them only via the Component interface. When a request is made to a container, it delegates the work to its sub-elements and may process intermediate results before returning the final result.
4.  **Client**: Interacts with all elements (both leaves and containers) through the Component interface, allowing uniform treatment of simple and complex tree elements.

## 5. Applicability

Use the Composite pattern when:

*   You need to implement a tree-like object structure (e.g., UI component hierarchies, graphs).
*   You want client code to treat both simple (leaf) and complex (composite) elements uniformly, without needing to distinguish between them.

## 6. How to Implement

1.  Ensure your core model can be represented as a tree. Identify simple elements (leaves) and containers.
2.  Declare the Component interface with methods applicable to both leaves and containers.
3.  Create Leaf classes for simple elements, implementing the Component interface.
4.  Create a Container (Composite) class for complex elements. Include a field (e.g., a list) to store references to its children (typed to the Component interface). Implement Component interface methods, typically by delegating to children.
5.  Define methods in the Container for adding and removing child elements. These might also be declared in the Component interface (though this can violate Interface Segregation Principle if leaves don't use them).

## 7. Pros and Cons

**Pros:**

*   Simplifies working with complex tree structures through polymorphism and recursion.
*   *Open/Closed Principle*: New element types (leaves or composites) can be added without breaking existing client code that works with the Component interface.

**Cons:**

*   It can be difficult to create a common interface if classes have vastly different functionalities, potentially leading to an overgeneralized or hard-to-understand Component interface.

## 8. Relations with Other Patterns

*   **Builder**: Can be used to construct complex Composite trees recursively.
*   **Chain of Responsibility**: Often used with Composite. A request to a leaf might be passed up the chain of parent components.
*   **Iterator**: Used to traverse Composite trees.
*   **Visitor**: Used to perform an operation over an entire Composite tree.
*   **Flyweight**: Can implement shared leaf nodes in a Composite tree to save memory.
*   **Decorator**: Has a similar structure (recursive composition). Decorator adds responsibilities to one child, while Composite sums up children's results. They can cooperate, e.g., decorating a specific object in a Composite tree.
*   **Prototype**: Useful for cloning complex Composite (or Decorator) structures instead of rebuilding them. 