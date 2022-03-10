package lab2;

public abstract class Room {
    String name;
    int size;


    /**
     * The constructor; it takes 2 parameters
     *
     * @param name room's name
     * @param size room's size
     */
    public Room(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
     * @return a string that contains information about the room
     */
    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                ", size=" + size +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
