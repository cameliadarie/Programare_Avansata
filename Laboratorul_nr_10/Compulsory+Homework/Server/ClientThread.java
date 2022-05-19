import java.io.*;
import java.net.*;
import java.util.LinkedList;

/**
 * @author Camelia Darie
 */
class ClientThread extends Thread {
    private static LinkedList<Friends> friendsList = new LinkedList<>();
    final DataInputStream dataInputStream;
    final DataOutputStream dataOutputStream;
    final Socket socket;
    private Network myNetwork;

    public ClientThread(Socket socket, DataInputStream dataInputStream, DataOutputStream dataOutputStream, Network myNetwork) {
        this.socket = socket;
        this.dataInputStream = dataInputStream;
        this.dataOutputStream = dataOutputStream;
        this.myNetwork = myNetwork;

    }

    /**
     * I am asking the user to type in his request.
     * After receiving it, I perform different activities depending on the answer I received.
     * If the option is register, I verify that he also gave a name and that this user doesn't
     * exist already. If the option is login, I verify that this user exists. If the option
     * is friend, I create a friendship between name1 and the rest and add it to my list of friends
     */
    @Override
    public void run() {
        while (true) {
            try {
                socket.setSoTimeout(100000000);
            } catch (SocketException e) {
                break;
            }
            try {
                dataOutputStream.writeUTF("[SERVER] Please enter your option...");
                String receivedString = dataInputStream.readUTF();
                System.out.println(receivedString);
                if (receivedString.equals("stop")) {
                    this.socket.close();
                    System.out.println("[SERVER] Server stopped... ");
                    try {
                        this.dataInputStream.close();
                        this.dataOutputStream.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    System.exit(0);
                } else if (receivedString.equals("exit")) {
                    this.socket.close();
                    System.out.println("[SERVER] Client exited... ");
                    break;
                } else if (receivedString.startsWith("register")) {
                    if (receivedString.length() > 9) {
                        if (myNetwork.people.contains(receivedString.substring(9)))
                            System.out.println("[CLIENT] Sent invalid request.");
                        else {
                            myNetwork.people.add(receivedString.substring(9));
                            System.out.println(myNetwork);
                        }
                    } else
                        System.out.println("[CLIENT] Sent invalid request.");
                } else if (receivedString.startsWith("login")) {
                    if (receivedString.length() > 5)
                        if (myNetwork.people.contains(receivedString.substring(6)))
                            System.out.println("[CLIENT]" + receivedString.substring(6) + " has logged in");
                        else System.out.println("[CLIENT] No such username");
                    else System.out.println("[CLIENT] Sent invalid request.");

                } else if (receivedString.startsWith("friend")) {
                    String[] parts = receivedString.split(" ");
                    for (int i = 2; i < parts.length; i++) {
                        Friends newFriendship = new Friends(parts[1], parts[i]);
                        friendsList.add(newFriendship);
                        System.out.println(friendsList);
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        try {
            this.dataInputStream.close();
            this.dataOutputStream.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}