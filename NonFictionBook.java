//Defines a new class called NonFictionBook which extends the Book class.
public class NonFictionBook extends Book {

    // Declares a private String variable called nonfictionGenre that will hold the
    // genre of the non-fiction book.
    private String nonfictionGenre;

    // Constructor for the NonFictionBook class that accepts the title, author,
    // description, publisher, yearPublished, and nonfictionGenre as parameters.
    public NonFictionBook(String title, String author, String description, String publisher, int yearPublished,
            String nonfictionGenre) throws IllegalArgumentException {

        // Calls the constructor of the superclass (Book) using the super keyword.
        // Calls the constructor of the superclass (Book) with the given parameters
        // using the super keyword.
        // Initializes the nonfictionGenre variable with the value passed as a
        // parameter.
        super(title, author, description, publisher, yearPublished);

        if (nonfictionGenre == null || nonfictionGenre.isEmpty()) {
            throw new IllegalArgumentException("Non-fiction genre cannot be null or empty");
        }

        if (yearPublished < 0 || yearPublished > 2023) {
            throw new IllegalArgumentException("Invalid year published");
        }

        this.nonfictionGenre = nonfictionGenre;
    }

    // Getter method for the nonfictionGenre variable that returns the value of the
    // variable.
    public String getNonfictionGenre() {
        return nonfictionGenre;
    }

    // Overrides the getGenre method from the Book class to return the
    // nonfictionGenre variable.
    @Override
    public String getGenre() {
        return nonfictionGenre;
    }
}
