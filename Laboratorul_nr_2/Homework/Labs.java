package lab2;

/**
 * Some type of room
 */
public class Labs extends Room {
    boolean videoprojector;

    /**
     * The constructor; it gets the following parameters
     *
     * @param name           lab's name
     * @param size           lab's size
     * @param videoprojector if it has a video projector or not
     */
    public Labs(String name, int size, boolean videoprojector) {
        super(name, size);
        this.videoprojector = videoprojector;
    }
}

