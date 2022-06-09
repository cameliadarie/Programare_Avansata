package proiect;

public class Rooms extends Rows {

    private int capacity;

    public Rooms(InfoTable events) {
        Rows.infoTable = events;
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

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "name= '" + name + '\'' +
                "capacity= " + capacity +
                ", id= " + id +
                '\n';
    }
}
