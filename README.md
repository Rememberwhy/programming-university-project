# GadgetShop Java Application

## Overview

The GadgetShop project is a Java application that simulates a gadget store management system. It allows users to add gadgets (Mobile phones and MP3 players), manage their details, and perform operations such as making calls and downloading music via a graphical user interface (GUI). The application employs object-oriented programming principles and ensures an interactive user experience through various GUI components.

## Features

- Add new mobile gadgets and MP3 players to the store.
- Display all gadgets in the store.
- Make phone calls using the mobile gadgets.
- Download music to the MP3 players.
- Clear input fields to reset the form.
- User-friendly GUI with Nimbus look and feel.
- Robust error handling and input validation.

## Class Structure

### Gadget Class

The `Gadget` class represents a generic gadget with attributes for model, price, weight, and size. It provides the basic structure and methods that are inherited by the `Mobile` and `MP3` subclasses.

### Mobile Class

The `Mobile` class extends `Gadget` to represent a mobile phone with additional functionality to manage calling credit and make phone calls.

### MP3 Class

The `MP3` class extends `Gadget` to represent an MP3 player with additional functionality to manage available memory and download music.

### GadgetShop Class

The `GadgetShop` class manages the GUI and the interaction between the user and the gadget store. It handles user inputs, displays gadget details, and performs operations such as adding gadgets, making calls, and downloading music.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or later.
- A Java Integrated Development Environment (IDE) such as IntelliJ IDEA or Eclipse.
- Graphviz (for generating UML diagrams, optional).

### Installation

1. Clone the repository:
    ```sh
    git clone https://github.com/yourusername/GadgetShop.git
    ```
2. Open the project in your preferred IDE.

### Running the Application

1. Navigate to the project directory in your IDE.
2. Compile the Java files:
    ```sh
    javac GadgetShop.java
    ```
3. Run the compiled program:
    ```sh
    java GadgetShop
    ```

### Usage

1. **Add Mobile**: Enter the model, price, weight, size, and initial credit, then click "Add Mobile" to add a new mobile gadget.
2. **Add MP3**: Enter the model, price, weight, size, and available memory, then click "Add MP3" to add a new MP3 player.
3. **Clear Fields**: Click "Clear Fields" to reset all input fields.
4. **Display All Gadgets**: Click "Display All Gadgets" to view details of all gadgets in the store.
5. **Make Call**: Enter the display number, phone number, and call duration, then click "Make Call" to make a phone call using the selected mobile gadget.
6. **Download Music**: Enter the display number and download size, then click "Download Music" to download music to the selected MP3 player.

## UML Class Diagram

![UML Class Diagram](gadget_shop_class_diagram_friendly.png)

## Testing

The application has been tested to ensure all functionalities work as expected. Below are the test cases:

1. **Adding a Mobile**: Fill the fields with valid data and click "Add Mobile".
2. **Adding an MP3 Player**: Fill the fields with valid data and click "Add MP3".
3. **Displaying All Gadgets**: Click the "Display All Gadgets" button.
4. **Making a Call**: Enter a valid display number, phone number, and duration, then click "Make Call".
5. **Downloading Music**: Enter a valid display number and download size, then click "Download Music".
6. **Validating Inputs**: Enter invalid data in various fields and attempt to perform actions.

## References

1. Deitel, P. J., & Deitel, H. M., *Java How to Program*, 11th edn (Pearson, 2017).
2. Eckel, B., *Thinking in Java*, 4th edn (Prentice Hall, 2006).
3. Schildt, H., *Java: The Complete Reference*, 11th edn (McGraw-Hill Education, 2018).
4. Robinson, R., Vorobiev, P., & Vorobiev, V., *Swing: A Beginner's Guide* (McGraw-Hill/Osborne, 2002).
5. Fowler, M., *UML Distilled: A Brief Guide to the Standard Object Modeling Language*, 3rd edn (Addison-Wesley Professional, 2004).
6. Booch, G., Rumbaugh, J., & Jacobson, I., *The Unified Modeling Language User Guide*, 2nd edn (Addison-Wesley Professional, 2005).
7. Gaddis, T., *Starting Out with Java: From Control Structures through Objects*, 7th edn (Pearson, 2019).
8. Zukowski, J., *The Definitive Guide to Swing for Java 2* (Apress, 2005).
9. Kolling, M., & Barnes, D., *BlueJ: Programming with Java*, 5th edn (Pearson, 2016).
10. Sommerville, I., *Software Engineering*, 10th edn (Pearson, 2015).
11. Pressman, R. S., *Software Engineering: A Practitioner's Approach*, 8th edn (McGraw-Hill Education, 2014).
12. Oracle Documentation: Java SE Documentation. Available at: <https://docs.oracle.com/javase/8/docs/> [Accessed: 24 July 2024].
13. Stack Overflow. Available at: <https://stackoverflow.com/> [Accessed: 24 July 2024].
14. Graphviz - Graph Visualization Software. Available at: <https://graphviz.org/> [Accessed: 24 July 2024].
15. IntelliJ IDEA: The Java IDE for Professional Developers by JetBrains. Available at: <https://www.jetbrains.com/idea/> [Accessed: 24 July 2024].

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.

