
// This code imports the required classes for the Library class
import java.util.ArrayList;
import java.util.HashMap;

// This is a public class named Library
public class Library {

  // These are private fields that define the properties of the library
  private ArrayList<Book> books;
  private HashMap<String, Integer> bookCounts;

  // This is a constructor for the Library class with no parameters
  // It initializes the books ArrayList and the bookCounts HashMap
  public Library() {
    books = new ArrayList<>();
    bookCounts = new HashMap<>();
  }

  // This is a constructor for the Library class that takes an ArrayList of books
  // as a parameter
  // It calls the no-parameter constructor of the Library class and initializes
  // bookCounts with a count of each book
  public Library(ArrayList<Book> books) {
    this.books = books;
    bookCounts = new HashMap<>();
    for (Book book : books) {
      String title = book.getTitle();
      bookCounts.put(title, bookCounts.getOrDefault(title, 0) + 1);
    }
  }

  // This is a method that adds a book to the library
  // It adds the book to the books ArrayList and increments the book count in the
  // bookCounts HashMap
  public void addBook(Book book) {
    if (book.getTitle() == null || book.getAuthor() == null || book.getDescription() == null || book.getPublisher() == null) {
      throw new IllegalArgumentException("Book information cannot be null.");
    }
    books.add(book);
    String title = book.getTitle();
    bookCounts.put(title, bookCounts.getOrDefault(title, 0) + 1);
  }
  

  // This is a method that removes a book from the library
  public void removeBook(String title) {
    try {
      for (Book book : books) {
        if (book.getTitle().equals(title)) {
          books.remove(book);
          System.out.println("Book removed successfully.");
          return;
        }
      }
      System.out.println("Book not found in the library.");
    } catch (NullPointerException e) {
      System.out.println("Unable to remove book: " + e.getMessage());
    }
  }

  // This is a method that returns the number of copies of a book in the library
  // It returns the value of the book count in the bookCounts HashMap for a given
  // title
  public int getBookCount(String title) {
    return bookCounts.getOrDefault(title, 0);
  }

  // This is a method that searches the library for books containing a given
  // keyword
  // It returns an ArrayList of books that match the keyword in their title or
  // author and publisher field
  public ArrayList<Book> searchBooks(String keyword) {
    ArrayList<Book> result = new ArrayList<>();
    for (Book book : books) {
      if (book.getTitle().contains(keyword) || book.getAuthor().contains(keyword)
          || book.getPublisher().contains(keyword)) {
        result.add(book);
      }
    }
    return result;
  }

  // This is a method that displays the details of all books in the library
  // It prints the toString representation of each book in the books ArrayList
  public void displayBooks() {
    if (books.isEmpty()) {
      System.out.println("No books found");
    } else {
      for (Book book : books) {
        System.out.println(book);
      }
    }
  }
}