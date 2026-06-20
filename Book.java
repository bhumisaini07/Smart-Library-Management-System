public class Book {

    private int id;
    private String title;
    private String author;
    private boolean available;

    // Constructor for adding a new book
    public Book(int id, String title, String author) {
        this(id, title, author, true);
    }

    // Constructor for loading books from file
    public Book(int id, String title, String author, boolean available) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.available = available;
    }

    // Getter for ID
    public int getId() {
        return id;
    }

    // Getter for Title
    public String getTitle() {
        return title;
    }

    // Getter for Author
    public String getAuthor() {
        return author;
    }

    // Check availability
    public boolean isAvailable() {
        return available;
    }

    // Update availability
    public void setAvailable(boolean available) {
        this.available = available;
    }

    // Display book details
    @Override
    public String toString() {
        return "ID: " + id +
                " | Title: " + title +
                " | Author: " + author +
                " | Available: " + available;
    }
}