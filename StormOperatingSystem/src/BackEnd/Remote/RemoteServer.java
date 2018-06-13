package BackEnd.Remote;

import EventHandling.DirectionManager;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class RemoteServer {
    private ServerSocket serverSocket;
    private DirectionManager directionManager;

    public RemoteServer(final DirectionManager directionManager,
                        final int port) {
        try {
            this.directionManager  = directionManager;
            serverSocket = new ServerSocket(port);
            new Thread() {
                @Override
                public void run() {
                    acceptClients();
                }
            }.start();
        } catch (IOException ioe) {
            System.out.println("ioe.getMessage() = " + ioe.getMessage());
        } catch (Exception e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        }
    }

    private void acceptClients() {
        while(true) {
            try {
                Socket socket = serverSocket.accept();
                new RemoteReadOperations(socket, directionManager).start();
            } catch(IOException ioe) {
                System.out.println("ioe.getMessage* = " + ioe.getMessage());
            } catch (Exception e) {
                System.out.println("e.getMessage() = " + e.getMessage());
            }
        }
    }
}
