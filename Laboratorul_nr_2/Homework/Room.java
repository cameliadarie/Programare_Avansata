package lab2;

public abstract class Room {
    String name;
    int size;


    /**
     * Constructorul; acesta primeste 2 parametri
     * @param name numele camerei
     * @param size marimea camerei
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
     * In acest fel fac override la toString
     *
     * @return un string ce contine informatii despre camera
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
