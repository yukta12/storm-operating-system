package BackEnd.Remote;

import EventHandling.DirectionManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RemoteReadOperations extends Thread implements RemoteConstants{
    private Socket socket;
    private DirectionManager directionManager;
    public RemoteReadOperations(final Socket socket,
                                final DirectionManager directionManager) {
        this.socket = socket;
        this.directionManager = directionManager;
    }

    @Override
    public void run() {
        readCommands();
    }

    private void readCommands() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String message;
            while(true) {
                message = bufferedReader.readLine();
                processCommands(message);
            }
        } catch (IOException ioe) {
            System.out.println("ioe.getMessage = " + ioe.getMessage());
        } catch(Exception e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        }
    }

    private void processCommands(String message) {
        Matcher commandMatcher = Pattern.compile(COMMAND + ":(.*)").matcher(message);
        if(commandMatcher.find()) {
            switch(commandMatcher.group(1)) {
                case DOWN_COMMAND :
//                    directionManager.goToDirection("DOWN");
                    System.out.println("DOWN");
                    break;

                case UP_COMMAND :
//                    directionManager.goToDirection("UP");
                    System.out.println("UP");
                    break;

                case LEFT_COMMAND :
//                    directionManager.goToDirection("LEFT");
                    System.out.println("LEFT");
                    break;

                case RIGHT_COMMAND :
//                    directionManager.goToDirection("RIGHT");
                    System.out.println("RIGHT");
                    break;

                case OK_COMMAND:
                    System.out.println("OK");
                    break;
            }
        }
    }
}
