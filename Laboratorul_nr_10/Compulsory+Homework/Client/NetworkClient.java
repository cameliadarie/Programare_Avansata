import java.io.*;
import java.net.*;
import java.util.*;

/**
 * @author Darie Camelia-Beatrice
 */
public class NetworkClient {
    private static final int PORT = 6868;
    private static final String ADDRESS = "127.0.0.1";
    private static int nrOfPeopleConnected;
    private static InetAddress ip;
    private static Scanner scanner;
    private static Socket socket;
    private static DataInputStream dataInputStream;
    private static DataOutputStream dataOutputStream;

    /**
     * @param args
     * @throws IOException At first I am getting the localhost ip and then starting a connection with the server.
     *                     After getting input and output stream, I perform a loop which exchanges information
     *                     between the client and the ClientThread class. Depending on the option the client chooses,
     *                     I print and perform different things
     */
    public static void main(String[] args) throws IOException {
        try {
            scanner = new Scanner(System.in);
            ip = InetAddress.getByName(ADDRESS);
            socket = new Socket(ip, PORT);
            socket.setSoTimeout(10000000);
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            while (true) {
                System.out.println(dataInputStream.readUTF());
                String toSend = scanner.nextLine();
                dataOutputStream.writeUTF(toSend);
                if (toSend.equals("exit")) {
                    socket.close();
                    System.out.println("[Client]Connection closed... ");
                    break;
                } else if (toSend.equals("stop")) {
                    socket.close();
                    System.out.println("[Client] The server has stopped. Exiting... ");
                    break;
                } else if (toSend.startsWith("register")) {
                    if (toSend.length() > 9)
                        System.out.println("You have been registered ");
                    else System.out.println(" Sent invalid request.Try again");

                } else if (toSend.startsWith("login")) {
                    if (toSend.length() > 5)
                        System.out.println("Logging you in... ");
                    else System.out.println("Sent invalid request.Try again");
                }
            }
            dataInputStream.close();
            dataOutputStream.close();
            scanner.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}