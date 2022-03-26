package lab5;

/**
 * A type of item
 */
public class Book extends Item {
    private String type;

    public Book(String id, String title, String location, String author, int year, String type) {
        super(id, title, location, author, year);
        this.type = type;
    }

    @Override
    public String toString() {
        return "Book{" +
                "type='" + type + '\'' +
                ", id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", location='" + location + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                '}';
    }
}
