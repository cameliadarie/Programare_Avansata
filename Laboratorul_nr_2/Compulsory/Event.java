package lab2;

public class Event {
 public int start;
 public int end;
 String Name;
 int size;

    public Event(int start, int end, String name, int size) {
        this.start = start;
        this.end = end;
        Name = name;
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
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Event{" +
                "start=" + start +
                ", end=" + end +
                ", Name='" + Name + '\'' +
                ", size=" + size +
                '}';
    }
}
