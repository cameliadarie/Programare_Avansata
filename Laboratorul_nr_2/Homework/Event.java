package lab2;

public class Event {
    public int start;
    public int end;
    String name;
    int size;

    /**
     * The constructor, it gets 4 parameters
     * @param start when the event starts
     * @param end   when the event ends
     * @param name  event's name
     * @param size  event's size
     */
    public Event(int start, int end, String name, int size) {
        this.start = start;
        this.end = end;
        this.name = name;
        this.size = size;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    /**
     * It overrides toString
     *
     * @return A string that provides information about the event
     */
    @Override
    public String toString() {
        return "Event{" +
                "start=" + start +
                ", end=" + end +
                ", Name='" + name + '\'' +
                ", size=" + size +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
