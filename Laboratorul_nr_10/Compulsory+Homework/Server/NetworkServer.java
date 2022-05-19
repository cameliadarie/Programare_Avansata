import java.io.*;
import java.net.*;

/**
 * @author Camelia Darie
 */
public class NetworkServer {
    private static Network myNetwork = new Network();

    /**
     * I am running an infinite loop to get client requests.
     * After a new client is connected, and I get the input output streams,
     * I create a new thread object and invoke the start method
     *
     * @param args
     * @throws IOException
     */

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6868);
        while (true) {
            Socket socket = null;
            try {
                socket = serverSocket.accept();
                System.out.println("New client connected : " + socket);
                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                System.out.println("[SERVER] Assigning new thread for this client");
                Thread threadClient = new ClientThread(socket, dataInputStream, dataOutputStream, myNetwork);
                threadClient.start();
            } catch (Exception ex) {
                socket.close();
                ex.printStackTrace();
            }
        }
    }
}