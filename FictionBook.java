// This line of code declares a public class named "FictionBook" that extends the abstract class "Book".
public class FictionBook extends Book {

  // This line of code declares a private instance variable for the book's genre.

  private String genre;

  // This line of code creates a constructor for the FictionBook class that takes
  // in values for the book's title, author, description, publisher, year
  // published, and genre.

  public FictionBook(String title, String author, String description, String publisher, int yearPublished,
      String genre) throws IllegalArgumentException {

    // This line of code calls the constructor of the parent class "Book" using the
    // "super" keyword and passing the values for the book's title, author,
    // description, publisher, year published and book Count.

    super(title, author, description, publisher, yearPublished);
    if (genre == null) {
      throw new IllegalArgumentException("Genre cannot be null.");
    }
    // This line of code assigns the value passed in the constructor to the private
    // instance variable "genre".

    this.genre = genre;
  }

  // This line of code implements the abstract method "getGenre" from the parent
  // class "Book" and returns the value of the private instance variable "genre".

  public String getGenre() {
    return genre;
  }
}
