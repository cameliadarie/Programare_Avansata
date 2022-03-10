package lab2;

/**
 * Un tip de room
 */
public class Labs extends Room {
  boolean videoprojector;

    /**
     * Constructorul; acesta primeste urmatorii parametrii
     * @param name numele laboratorului
     * @param size marimea laboratorului
     * @param videoprojector daca are sau nu videoproiector
     */
    public Labs(String name, int size, boolean videoprojector) {
        super(name, size);
        this.videoprojector = videoprojector;
    }
}

