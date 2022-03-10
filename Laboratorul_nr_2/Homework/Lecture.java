package lab2;

/**
 * A type of room
 */
public class Lecture extends Room {
    String os;

    public Lecture(String name, int size, String os) {
        super(name, size);
        this.os = os;
    }
}
