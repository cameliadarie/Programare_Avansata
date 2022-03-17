package lab3;

/**
 * This class is a type of node and has both an ip address and storage.
 */
public class Computer extends Node implements Identifiable, Storage {
    private String address;
    private int storageCapacity;

    public Computer(String name, String hardware_address, String location_on_map, String address, int storageCapacity) {
        super(name, hardware_address, location_on_map);
        this.address = address;
        this.storageCapacity = storageCapacity;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public int getStorageCapacity() {
        return storageCapacity;
    }

    public void setStorageCapacity(int storageCapacity) {
        this.storageCapacity = storageCapacity;
    }

    @Override
    public String getAddress() {
        return address;
    }


    @Override
    public String toString() {
        return "Computer{" +
                "name='" + name + '\'' +
                ",address='" + address + '\'' +
                ", hardware_address='" + hardware_address + '\'' +
                ", location_on_map='" + location_on_map + '\'' +
                ", storageCapacity=" + storageCapacity +
                '}';
    }


}
