
// Importing the necessary classes from the java.util package
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class LibraryApp {
    public static void main(String[] args) {
        // Creating a new Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Creating a new ArrayList to hold the books
        ArrayList<Book> books = new ArrayList<>();

        // Creating a new Library object with the ArrayList of books
        Library library = new Library(books);

        // Initializing a boolean variable to control the loop
        boolean exit = false;

        // Starting the loop to display the menu until the user chooses to exit
        while (!exit) {
            // Displaying the options available to the user
            System.out.println("\nEnter your choice:");
            System.out.println("1. Add book");
            System.out.println("2. Remove book");
            System.out.println("3. Search books");
            System.out.println("4. Display all books");
            System.out.println("5. Exit\n");

            // Prompting the user for their choice
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                // Using a switch statement to perform an action based on the user's choice
                switch (choice) {
                    case 1:
                        // Prompting the user for the book's details
                        System.out.println("\nEnter title:");
                        String title = scanner.nextLine();
                        System.out.println("\nEnter author:");
                        String author = scanner.nextLine();
                        System.out.println("\nDescription of the Book");
                        String description = scanner.nextLine();
                        System.out.println("\nPublisher");
                        String publisher = scanner.nextLine();
                        System.out.println("\nEnter year published:");
                        int yearPublished = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("\nEnter genre (fiction or non-fiction):");
                        String genre = scanner.nextLine();

                        // Checking the genre of the book and creating a new book object accordingly
                        Book book = null;
                        if (genre.equalsIgnoreCase("fiction")) {
                            System.out.println("\nEnter Fiction genre:");
                            String fictionGenre = scanner.nextLine();
                            book = new FictionBook(title, author, description, publisher, yearPublished, fictionGenre);
                        } else if (genre.equalsIgnoreCase("non-fiction")) {
                            System.out.println("\nEnter Non-Fiction genre:");
                            String nonfictionGenre = scanner.nextLine();
                            book = new NonFictionBook(title, author, description, publisher, yearPublished,
                                    nonfictionGenre);
                        } else {
                            System.out.println("Invalid genre");
                        }

                        // Adding the book to the library and notifying the user
                        if (book != null) {
                            library.addBook(book);
                            System.out.println("\nBook added successfully");
                        }
                        break;

                    // If the user chooses to remove a book
                    case 2:
                        System.out.println("Enter the title of the book to remove:");
                        String titleToRemove = scanner.nextLine();
                        library.removeBook(titleToRemove);
                        break;

                    // If the user chooses to search for a book
                    case 3:
                        System.out.println("Enter keyword:");
                        String keyword = scanner.nextLine();

                        // Searching for books in the library and displaying the result
                        ArrayList<Book> searchResult = library.searchBooks(keyword);
                        if (searchResult.isEmpty()) {
                            System.out.println("\nNo books found\n");
                        } else {
                            System.out.println("Search result:");
                            for (Book b : searchResult) {
                                System.out.println(b);
                            }
                        }
                        break;

                    // If the user chooses to display all books in the library
                    case 4:
                        library.displayBooks();
                        break;

                    // If the user chooses to exit the program
                    case 5:
                        exit = true;
                        System.out.println("Exit");
                        break;

                    // If the user chooses an invalid option
                    default:
                        System.out.println("Invalid choice");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // clear the buffer
            }
        }

        // Closing the Scanner object
        scanner.close();
    }
}
