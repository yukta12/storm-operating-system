package BackEnd.Remote;

import EventHandling.DirectionManager;

public class UnitTest {
    public static void main(String[] args) {
        RemoteServer remoteServer = new RemoteServer(new DirectionManager(), 8080);
    }
}
