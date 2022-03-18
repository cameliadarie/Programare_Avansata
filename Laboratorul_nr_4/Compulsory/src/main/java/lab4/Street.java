package lab4;

/**
 * This class models a street
 */
public class Street implements Comparable<Street> {
    private String name;
    private int length;
    private Intersection start;
    private Intersection end;

    public Street(String name, int length, Intersection start, Intersection end) {
        this.name = name;
        this.length = length;
        this.start = start;
        this.end = end;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Intersection getStart() {
        return start;
    }

    public void setStart(Intersection start) {
        this.start = start;
    }

    public Intersection getEnd() {
        return end;
    }

    public void setEnd(Intersection end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Street{" +
                "name='" + name + '\'' +
                ", length=" + length +
                ", start=" + start +
                ", end=" + end +
                '}';
    }

    @Override
    public int compareTo(Street other) {
        return (this.length - other.length);
    }


}