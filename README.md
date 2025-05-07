# Java Design Patterns Showcase

A collection of common design patterns implemented in Java. This project serves as a practical guide and a quick reference for understanding and applying these patterns.

## Implemented Design Patterns

This repository includes implementations for the following design patterns:

*   [Abstract Factory](./AbstractFactory/documentation.md)
*   [Builder](./Builder/documentation.md)
*   [Composite](./Composite/documentation.md)
*   [Decorator](./Decorator/documentation.md)
*   [Factory](./Factory/documentation.md)
*   [Prototype](./Prototype/documentation.md)
*   [Proxy](./Proxy/documentation.md)
*   [Singleton (Thread-Safe)](./Singleton/documentation.md)

Each pattern resides in its own directory, which is also a Maven module. You can find detailed explanations and usage examples in the `documentation.md` file within each pattern's directory.

## Prerequisites

*   Java Development Kit (JDK) 17 or later
*   Apache Maven 3.6.0 or later

## Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/dangelot00/DesignPatterns.git
cd DesignPatterns
```

### 2. Build the Project

This is a multi-module .idea project. To run modules, navigate and run from each Demo class (IntelliJ IDEA suggested):

### 3. Explore Individual Patterns

Each design pattern is self-contained in its own module directory (e.g., `AbstractFactory/`, `Builder/`).

*   **Documentation**: Navigate to the specific pattern's directory and open the `documentation.md` file for a detailed explanation, UML diagrams, and code snippets.
*   **Running Examples**: Most patterns will have example code within their `src/main/java` directory. You can compile and run these examples using your IDE or Maven commands specific to that module (e.g., `cd AbstractFactory && mvn compile exec:java -Dexec.mainClass="org.example.Main"` - adjust the main class as needed).

## Project Structure

The project is organized as a parent Maven project with each design pattern implemented as a separate child module.

```
DesignPatterns/
├── pom.xml                   # Parent POM
├── AbstractFactory/
│   ├── pom.xml               # Module POM
│   ├── src/main/java/        # Source code for Abstract Factory
│   └── documentation.md      # Detailed docs for Abstract Factory
├── Builder/
│   ├── ...
├── Composite/
│   ├── ...
├── ...                       # Other pattern modules
└── README.md                 # This file
```

## Contributing

Contributions are welcome! If you'd like to add a new design pattern, improve an existing one, or fix a bug, please follow these steps:

1.  Fork the repository.
2.  Create a new branch (`git checkout -b feature/your-feature-name`).
3.  Make your changes.
4.  Commit your changes (`git commit -m 'Add some feature'`).
5.  Push to the branch (`git push origin feature/your-feature-name`).
6.  Open a Pull Request.

Please ensure your code adheres to the existing style and that you update or add relevant documentation.