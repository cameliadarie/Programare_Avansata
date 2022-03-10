package lab2;

/**
 * Un tip de room
 */
public class Lecture extends Room {
String os;

    public Lecture(String name, int size, String os) {
        super(name, size);
        this.os = os;
    }
}
