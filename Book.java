// This line of code declares an abstract class named "Book".
public abstract class Book {

  // These lines of code declare private instance variables for the book's title,
  // author, description, publisher, and year published.
  private String title;
  private String author;
  private String description;
  private String publisher;
  private int yearPublished;

  // This line of code creates a constructor for the Book class that takes in
  // values for the book's title, author, description, publisher, and year
  // published.
  // The constructor throws an IllegalArgumentException if the year published is
  // less than or equal to zero or if any of the book's information (title,
  // author, description, or publisher) is null. It also catches this exception
  // and prints the error message before re-throwing the exception.
  public Book(String title, String author, String description, String publisher, int yearPublished)
      throws IllegalArgumentException {
    try {
      if (title == null || author == null || description == null || publisher == null) {
        throw new NullPointerException("Book information cannot be null.");
      }

      if (yearPublished <= 0) {
        throw new IllegalArgumentException("Year published cannot be negative.");
      }
    } catch (IllegalArgumentException ex) {
      System.err.println(ex.getMessage());
      throw ex;
    }

    /* This block of code assigns the values passed in the constructor to the private instance variables.*/
    this.title = title;
    this.author = author;
    this.description = description;
    this.publisher = publisher;
    this.yearPublished = yearPublished;
  }

  // These lines of code create getter methods for the private instance variables
  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public String getDescription() {
    return description;
  }

  public String getPublisher() {
    return publisher;
  }

  public int getYearPublished() {
    return yearPublished;
  }

  // This line of code declares an abstract method that returns the genre of the
  // book.
  public abstract String getGenre();

  // This line of code overrides the toString() method to print out the book's
  // information in a formatted string.
  @Override
  public String toString() {
    return "Title: " + title + ", Author: " + author + ", Description: " + description + ", Publisher: " + publisher
        + ", Year Published: " + yearPublished +
        ", Genre: " + getGenre();
  }
}
