CATALOGUE MANAGEMNT SYSTEM
This is a Java program that implements a simple catalogue management system for books. It allows users to add books to a catalogue, 
view the list of books, and search for books by title or author and as well as deleting books.
 
 DEVELOPERS -GROUP 1 LEVEL 2 of MZUZU UNIVERSITY DATA SCIENCE WKEND STUDENTS - 2022-2023 ACADEMIC YEAR
 Gresham Mfune          – BSDSW3421
 Patrick Phandera       – BSDSW4821
 Sebastian  Macheso     - BSDSW2821
 Samuel kachali         - BSDSW1521 
 Amos gway              - BSCDS1020 

PRE-REQUISITES
Make sure you have the following installed on your system:

Java Development Kit (JDK)
Java Runtime Environment (JRE)
Swing library
Getting Started
Clone the repository or download the source code files.

Open the project in your preferred Java IDE.

Build the project to compile the code.

Run the program.

USAGE
The program provides a graphical user interface (GUI) for interacting with the catalogue. Here are the main components and their functionalities:

Catalogue class: Represents the catalogue of books. It provides methods for adding books to the catalogue and viewing the list of books.

Book class: Represents a book. It contains attributes such as title, author, ISBN, year, publisher, price, and number of pages.
It also has a display_book_info method to display the book's information.

NumericDocumentFilter class: A document filter that allows the text box to accept only integer values.

MyJframe class: The main GUI class that extends JFrame and implements ActionListener. It creates the main window and handles user actions.

The GUI consists of the following components:

Table: Displays the list of books in a tabular format with columns for title, author, ISBN, year, publisher, price, and number of pages.

BUTTONS:

"Addbook": Opens a form to add a new book to the catalogue.
"Searchbook": Opens a search form to search for books by title or author.
"Search": Performs a search based on the entered search criteria.
"Next": Displays the next page of search results.
"Previous": Displays the previous page of search results.
"ETC"
Text Fields:

Title
Author
ISBN
Year
Publisher
Price
Number of Pages
Search field
etc

FUNCTIONALITY

Adding a Book: Clicking the "Add book" button opens a form where you can enter the details of a book. After entering the details, click the "Add Book" button to add the book to the catalogue.

Viewing Books: The table displays the list of books in the catalogue. Each row represents a book and contains its details.

Searching for Books: Clicking the "Search book" button opens a search form. Enter the title or author you want to search for and click the "Search" button. The table will display the search results, and you can navigate between pages using the "Next" and "Previous" buttons.
Deleting Books:Clicking the "remove " button you delete a book from the system.It askes for comfirmation. 
Contributing
Contributions to this project are welcome. If you find any issues or have suggestions for improvements, please feel free to submit a pull request or open an issue.

UpGRADE CHANGES 
- The previous project used ussd inputs in making choices.While this one uses GUI.
- The previous one had arrayList as a storage structure while this one has JTable as storage structure which is more efficient and more compatible with Swing and awt.
 - Hence we recommend users to use this upgrade.

LICENCE
This project is licensed under the MIT License.
