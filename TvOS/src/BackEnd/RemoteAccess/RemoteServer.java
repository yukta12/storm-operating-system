package BackEnd.RemoteAccess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class RemoteServer {
    private ServerSocket serverSocket;
    private String ip;
    private int port;

    Socket clientSocket;
    RemoteReadOperations remoteReadOperations;

    public RemoteServer(final int port) {
        this.port = port;
        initVairables();
        acceptClients();
    }

    /*This method will initialize all the variables */

    private void initVairables() {
        try {
            this.serverSocket = new ServerSocket(port);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /*This method will accept the clients*/

    private void acceptClients() {

        while(true) {
            try {
                clientSocket = serverSocket.accept();
                System.out.println(clientSocket);
                remoteReadOperations = new RemoteReadOperations(clientSocket);
                remoteReadOperations.start();
            } catch(IOException ioe) {
                ioe.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        new RemoteServer(4000);
    }
}
