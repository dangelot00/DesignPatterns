# Proxy Design Pattern

## 1. Intent

Proxy is a structural design pattern that lets you provide a substitute or placeholder for another object. A proxy controls access to the original object, allowing you to perform something either before or after the request gets through to the original object.

## 2. Problem

You might want to control access to an object for various reasons. For example, you have a resource-intensive object (a "heavyweight" service) that isn't always needed. Creating it only when necessary (lazy initialization) would be ideal, but this could require duplicating initialization logic across all clients. Or, the original object's class might be from a third-party library and unmodifiable.

## 3. Solution

The Proxy pattern introduces a new proxy class that implements the same interface as the original service object. Clients interact with the proxy, which then creates the real service object (if needed) and delegates requests to it. This allows for additional behaviors (e.g., lazy initialization, access control, caching, logging) to be added before or after the primary logic without changing the original service class.

## 4. Structure

1.  **Service Interface**: Declares the interface that both the RealService and Proxy implement. This allows the Proxy to be a substitute for the RealService.
2.  **RealService (or Service)**: The actual object that provides the core business logic. The Proxy controls access to this object.
3.  **Proxy**: Implements the Service Interface. It holds a reference to the RealService object. It may be responsible for creating and managing the lifecycle of the RealService object. It performs its additional logic (e.g., caching, access control) and then delegates the request to the RealService.
4.  **Client**: Interacts with objects through the Service Interface, unaware whether it's dealing with a RealService or a Proxy.

## 5. Applicability

The Proxy pattern has various use cases:

*   **Lazy Initialization (Virtual Proxy)**: Delays the creation of a resource-intensive object until it's actually needed.
*   **Access Control (Protection Proxy)**: Restricts access to the RealService based on client credentials or permissions.
*   **Remote Proxy**: Represents an object located in a different address space (e.g., on a remote server), handling network communication.
*   **Logging Proxy**: Logs requests to the RealService before or after delegation.
*   **Caching Proxy**: Stores the results of expensive operations and returns cached data for subsequent identical requests, improving performance.
*   **Smart Reference (Smart Proxy)**: Performs additional actions when an object is referenced, such as reference counting to manage the RealService's lifecycle (e.g., disposing of it when no clients are using it).

## 6. How to Implement

1.  If one doesn't exist, define a Service Interface that both the RealService and Proxy will implement. (Alternatively, if modifying clients is not feasible, the Proxy can be a subclass of the RealService).
2.  Create the Proxy class, implementing the Service Interface. It should have a field to reference the RealService.
3.  The Proxy typically manages the RealService's lifecycle (e.g., creates it on demand).
4.  Implement the Proxy methods to include the desired additional behavior (e.g., lazy loading, access checks, caching) and then delegate to the RealService.
5.  Consider a creation method (e.g., static factory method in the Proxy or a separate Factory) that decides whether to return a Proxy or a RealService to the client.

## 7. Pros and Cons

**Pros:**

*   Control the service object without clients being aware.
*   Manage the lifecycle of the service object when clients don't need to (e.g., lazy initialization, smart references).
*   The proxy can work even if the real service object isn't ready or available (e.g., remote proxy handling network issues).
*   *Open/Closed Principle*: New proxies can be introduced without changing the service or clients.

**Cons:**

*   Can increase code complexity by introducing new classes.
*   The response from the service might be delayed due to the proxy's overhead.

## 8. Relations with Other Patterns

*   **Adapter**: Provides a different interface to an object. Proxy provides the same interface.
*   **Decorator**: Adds responsibilities to an object. Proxy controls access to an object. Decorators are typically composed by the client, while a Proxy usually manages its RealService lifecycle.
*   **Facade**: Provides a simplified interface to a complex subsystem. Proxy has the same interface as its service object.
*   Java's `java.lang.reflect.Proxy` allows dynamic creation of proxies. 