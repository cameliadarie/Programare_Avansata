package lab3;

/**
 * The class Router is a type of node and is also identifiable
 */
public class Router extends Node implements Identifiable {
    private String address;

    public Router(String name, String hardware_address, String location_on_map, String address) {
        super(name, hardware_address, location_on_map);
        this.address = address;
    }

    @Override
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Router{" +
                " name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", hardware_address='" + hardware_address + '\'' +
                ", location_on_map='" + location_on_map + '\'' +
                '}';
    }
}

