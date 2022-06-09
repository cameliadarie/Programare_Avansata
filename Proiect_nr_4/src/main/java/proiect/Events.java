package proiect;

public class Events extends Rows {

    private int start;
    private int end;
    private int size;

    public Events(InfoTable events) {
        Rows.infoTable = events;
    }

    public void Events(InfoTable infoTable) {
        Rows.infoTable = infoTable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "name=" + name +
                ",id ='" + id +
                "start=" + start +
                ", end=" + end +
                ", size=" + size
                ;
    }
}
