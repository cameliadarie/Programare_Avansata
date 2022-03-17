package lab3;

/**
 * This clas is a type of node; I think that it is neither identifiable nor has a storage
 */
public class Switch extends Node {
    public Switch(String name, String hardware_address, String location_on_map) {
        super(name, hardware_address, location_on_map);
    }

    @Override
    public String toString() {
        return "Switch{" +
                "name='" + name + '\'' +
                ", hardware_address='" + hardware_address + '\'' +
                ", location_on_map='" + location_on_map + '\'' +
                '}';
    }
}
