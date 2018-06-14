package BackEnd.RemoteAccess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RemoteReadOperations extends Thread{

    private BufferedReader bufferedReader;
    private Socket socket;
    private String clientRequest;
    private Pattern pattern;
    private Matcher matcher;

    public RemoteReadOperations(final Socket socket) {
        this.socket = socket;
        System.out.println(socket);
    }
    @Override
    public void run() {
        while(true){
            readRequest();
        }
    }

    /*This method will read the clients request and check what the client requests for*/
    private void readRequest(){
        try{
            System.out.println(socket);
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("Accept balues");
            clientRequest = bufferedReader.readLine();

            switch (patternMatcher(clientRequest,Constants.REQUEST_SELECTOR)){
                case Constants.REQUEST_DOWNLOAD:
                    processRequest(clientRequest);
            }

        }catch(IOException ioe){
            ioe.printStackTrace();
        }

    }

    /* This method will remove and find what the client request's
    * @param : clientRequest - clients request
    * @param : groupSelection - will select what part of the string you want
    *
    * @returns: the part of the string as request by the calling function */

    private String patternMatcher(String clientRequest, int groupSelection){
        pattern = Pattern.compile("(.*):(.*):(.*)");
        matcher = pattern.matcher(clientRequest);
        if (matcher.matches()){
            return matcher.group(groupSelection);
        }
        return null;
    }

    /*This method will process the clients requests process and accordingly call the media player
    * @param : clientRequest - clients request
    * */

    private void processRequest(String clientRequest){
        switch (patternMatcher(clientRequest,Constants.PROCESS_SELECTOR)){
            case Constants.MOVIES:
                System.out.println("movies");
                break;
            case Constants.SERIES:
                System.out.println("series");
                break;
            case Constants.SONGS:
                System.out.println("songs");
                break;
            case Constants.NEWS:
                System.out.println("newa");
                break;
        }
    }



}
