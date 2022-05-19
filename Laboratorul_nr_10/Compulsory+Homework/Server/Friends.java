/**
 * This class models a friendship between 2 friends
 */
public class Friends {
    private String friend1;
    private String friend2;

    public Friends(String friend1, String friend2) {
        this.friend1 = friend1;
        this.friend2 = friend2;
    }

    @Override
    public String toString() {
        return "Friends{" +
                "friend1='" + friend1 + '\'' +
                ", friend2='" + friend2 + '\'' +
                '}';
    }
}
