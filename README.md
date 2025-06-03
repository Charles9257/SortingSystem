## PROBLEM STATEMENT
Sorting is a critical but often overlooked process behind many modern applications. While numerous libraries offer sorting functions, users generally have little insight into:
•	What different sorting algorithms work?
•	The performance implications of each method.
•	The practical application of choosing one algorithm over another.
Additionally, most web-based sorting tools either lack versatility (supporting only one or two algorithms) or do not allow users to track and review their previous sorting actions.


## OVERALL ARCHITECTURE DESIGN
The Number Sorting System is developed following the MVC (Model-View-Controller) architectural pattern, ensuring a clear separation between data (Model), business logic (Controller), and presentation (View). 
•	Model Layer: Represents sorting history records and mapping them to the PostgreSQL database via JPA entities.
•	View Layer: Frontend pages designed with HTML5, CSS3, Bootstrap 5.3, and basic JavaScript for integration.
•	Controller Layer: Java Spring Boot Controllers handle users' requests, select appropriate sorting strategies, and manage data flow.
 ![image](https://github.com/user-attachments/assets/459e26ab-dd7f-4740-890e-75d418ec8431)


![image](https://github.com/user-attachments/assets/938c2d4f-8fad-4134-9ad5-b80c950dee89)


## TECH STACK OVERVIEW
### Backend
o	Java 17 to implement business logic and server operations
o	Spring Boot Framework to facilitate rapid application development with in-built MVC support.
### Frontend
o	HTML5 for webpage structure.
o	CSS3 and Bootstrap 5.3 for mobile-first, responsive design.
o	JavaScript for minor client-side interactions and input validation.
### Database 
o	PostgreSQL for production
o	Spring Boot JPA for storing and authenticating user login credentials
o	Integration via Spring Data JPA for efficient data handling
o	H2 Database for storing user sorting history during testing 
•	Build Tool:
•	Gradle to manage dependencies, automate builds, and maintain a modular project structure.

## FUNCTIONALITIES DESIGN   AND DEVELOPMENT
•	Input Numbers: Users can input a sequence of numbers and select the desired sorting strategy.
•	Sorting History: Each sorting operation is logged and stored in Postgresql, allowing users to view historical records. Every sorting operation (user input, algorithm used, sorted output, timestamp) is stored in an H2 database. This history allows users to review their past sorting activities and understand how different algorithms impact sorting results. DTOs are used to transfer sorting history data securely to the front end.
•	Dynamic Sorting Strategy Selection: The system dynamically chooses and executes the appropriate sorting algorithm based on user selection at runtime.
•	Logging: System activities such as sorting operations and errors are logged using a centralised Singleton LoggerManager. Its responsibilities are to log system events (new sort request, user selection, error) and provide easy-to-access, thread-safe logging functionalities. The components include LoggerManager(Singleton), context (to manage current state and selected strategy), config (application configurations like sorting options) and UserSort (the user’s input numbers and algorithm chosen).
•	Database Integration: all sorted data is persisted using the Repository pattern.
•	Responsive Frontend: The UI adapts to different devices using Bootstrap. The frontend interface adapts to desktops, tablets, and mobile devices. Users can manually enter a sequence of numbers, choose a sorting method from a dropdown menu, view sorted results immediately, and access the history of previous sorted activities. Bootstrap ensures a clean and modern user experience with minimal additional styling needed.

## OBJECT-ORIENTED DESIGN PRINCIPLES IMPLEMENTATION
The sorting system implements several object-oriented principles:
•	Encapsulation: All entities and service classes keep their data fields private with public getters/setters.
•	Abstraction: Sorting algorithms are hidden behind an abstract SortStrategy interface.
•	Polymorphism: Multiple sorting classes (BubbleSort, HeapSort, etc.) implement the familiar SortStrategy interface, allowing dynamic selection.
•	Inheritance: All sorting strategies inherit common behaviour from a shared interface.
•	Single Responsibility Principle: Each class handles one responsibility, such as sorting, logging, database interaction, etc.
•	UML Class Diagrams: show your system structure with relationships between models.

## CRITICAL EVALUATION OF DESIGN PATTERNS
Factory Pattern: creating sorting algorithm objects dynamically. It creates different concrete sorting classes such as Bubblesort, MergeSort, BucketSort, InsertionSort, SelectionSort, etc. and a factory class through a standard interface. Use Factory Pattern to choose the strategy, and Strategy Pattern to execute it. This is used in the Service and Controller.
 It is chosen to avoid hard-coded conditionals when selecting sorting algorithms and evaluating.
A factory instantiates the correct sorting strategy based on the user’s selection. The Factory eliminates the need for large, complex conditional statements, simplifies object creation, and improves code scalability and maintainability (Zhou, 2018).

Strategy Pattern: for interchangeable sorting algorithms, such as context (sorter which switches between the strategies based on the selected sorting algorithm), and strategy (BubbleSort, MergeSort, QuickSort, InsertionSort, SelectionSort, HeapSort, etc.). 
Needed to switch sorting algorithms dynamically based on user choice. Achieved runtime flexibility; easily extendable if new algorithms are needed. Each sorting algorithm is encapsulated as a separate class implementing a standard interface. The sorting method is selected dynamically at runtime based on user input (DeLucia et al., 2018).

Singleton Pattern: This pattern manages configuration or logging globally, bringing about thread-safe and lazy loading. This pattern is used in four major parts: during algorithm execution, when receiving/sending user input, in the service layer logic, and for debugging errors. It ensures consistent and efficient logging. LoggerManager ensures that only a single instance is responsible for application-wide logging. This is useful for tracking activities consistently without the overhead of multiple logger instances (Awais, 2024).

Repository Pattern
It abstracts database operations using JPA entities to connect to PostgreSQL for user registration and H2 Database to test SortController, SortHistoryRepository, SortStrategy and Unit test (JUnit 5). Reduced boilerplate, clean code, easy database switching if needed. Spring Data JPA repositories handle interaction with the H2 Database. CRUD operations (Create, Read, Update, Delete) are abstracted through repositories (Dorfmann, 2016).

## SORTING STRATEGIES
Sorting is a class of algorithms that are tasked with rearranging the positions of elements of an array such that all its components are either in ascending or descending order. A good sorting algorithm must also ensure that elements with the same value don’t change their locations in the sorted array (Bandyopadhyay, 2021).
### QUICKSORT
Quicksort is a divide-and-conquer strategy. It selects a pivot element from the array and partitions the other elements into two sub-arrays according to whether they are less than or greater than the pivot. This process is recursively applied to the sub-arrays. 
Steps:
•	Pick a pivot element (the first element, last element, middle element, or a random element).
•	Rearrange the array so that elements smaller than the pivot are on the left and those greater than the pivot are on the right.
•	Recursively apply QuickSort to the left and right sub-arrays.
### BUBBLESORT
BubbleSort is a simple comparison-based strategy. It works by repeatedly stepping through the list, comparing adjacent items and swapping them if they are in the wrong order. This process is repeated until the list is sorted.
Steps:
•	Compare the first element with the second element. If the first element is greater than the second element, swap them.
•	Move to the next pair and repeat until the end of the array.
•	After each pass, the most prominent unsorted element will “bubble up” to its correct position.
•	Repeat the process for the unsorted portion of the array.
### MERGESORT
MergeSort is a divide-and-conquer algorithm. It divides the array into two halves, recursively sorts each half, and then merges the two sorted halves to produce the sorted result.  
Steps:
•	Divide the array into two halves.
•	Recursively apply MergeSort to each half.
•	Merge the two sorted halves back together.

### HEAPSORT
HeapSort is a comparison-based algorithm that builds a binary heap from the input data. It then repeatedly extracts the maximum element from the heap and builds the sorted array in reverse order.
Steps:
•	Build a max heap from the array.
•	Swap the root (largest) element with the last element of the heap.
•	Reduce the process until the heap is empty.
### SELECTIONSORT
This repeatedly finds the minimum element from the unsorted portion of the array and swaps it with the first unsorted element, reducing the unsorted portion of the array by one element each time.
Steps:
•	Find the minimum element in the unsorted part of the array.
•	Swap it with the first element of the unsorted portion of the array.
•	Repeat the process for the rest of the array.
### INSERTIONSORT
InsertionSort builds a sorted portion of the array one element at a time. It starts with the second element and inserts it into the correct position in the sorted portion.
Steps: 
•	Begin with the second element and compare it to the first element.
•	Move the first element to the right if it’s smaller.
•	Insert the element in the correct position.
•	Repeat for each subsequent element.


## Testing Summary Conclusion
Through rigorous unit, integration, and manual testing, the Number Sorting System was verified to meet its functional and non-functional requirements. 
All critical functionalities, including the sorting algorithms, API endpoints, database interactions, and frontend validations, were tested and confirmed to work as expected. 
No critical defects were found during testing. 
The successful completion of these tests demonstrates that the application is stable, reliable, and ready for deployment, providing users with an accurate and responsive sorting experience.

