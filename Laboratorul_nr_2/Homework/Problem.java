package lab2;

/**
 * Aceasta clasa reprezinta problema
 */
public class Problem {
    public Event[] events;
    public Room[] rooms;

    /**
     * Constructorul default, va crea o problema folosindu-se de datele din problema noastra
     */
    public Problem() {
        this.events=new Event[]{
        new Event(8, 10, "C1", 100),
        new Event(10, 12, "c2", 100),
        new Event(8, 10, "L1", 30),
        new Event(8, 10, "L2", 30),
        new Event(10, 12, "L3", 30)};
        this.rooms=new Room[]{
        new Labs("R401", 30, true),
        new Labs("R405", 30, true),
        new Labs("403", 30, false),
        new Lecture("R309", 100,"Windows")};
    }

    public Event[] getEvents() {
        return events;
    }

    public void setEvents(Event[] events) {
        this.events = events;
    }

    public Room[] getRooms() {
        return rooms;
    }

    public void setRooms(Room[] rooms) {
        this.rooms = rooms;
    }

    /**
     *  Un constructor ce initiaza problema cu parametrii dati
     * @param events
     * @param rooms
     */
    public Problem(Event[] events, Room[] rooms) {
        this.events = events;
        this.rooms = rooms;
    }
}
