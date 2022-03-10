package lab2;

public class Event {
    public int start;
    public int end;
    String name;
    int size;

    /**
     * Constructorul; primeste 4 parametri
     * @param start ora la care incepe evenimentul
     * @param end ora la care se sfarseste evenimentul
     * @param name numele evenimentului
     * @param size marimea evenimentului
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
     * In acest fel fac override la toString
     *
     * @return un string ce contine informatii despre eveniment
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
