package lab5hw;

/**
 * A type of Item
 */
public class Document extends Item {
    public Document(String id, String title, String location, String author, int year) {
        super(id, title, location, author, year);
    }

    public Document() {

    }

    @Override
    public String toString() {
        return "Document{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", location='" + location + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                '}';
    }
}