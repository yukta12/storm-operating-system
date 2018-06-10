package BackEnd.MicroServices;

/**
 *
 * @author Harsh
 */

import java.net.*;
import java.io.*;
import java.util.*;
class UrlConnection{
    /*
    *********************************************************************************
    * this method reads the content of given url.
    * @param=nothing;
    * @returns=string;
    * *****************************************************************************
     */
    public String readApi(){
        StringBuffer sb = new StringBuffer();
        try{
            URL url = new URL("https://api.darksky.net/forecast/5db151902fa9f695bfcc2f81b77d5750/19.0760,72.8777");
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent","Chrome");
            //connection.setReadTimeout(20000);

            int responseCode = connection.getResponseCode();
            System.out.println("response code = " + responseCode);


            BufferedReader inputStream = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String line;

            while((line = inputStream.readLine()) !=null){
                sb.append(line + "\n");
            }
            //System.out.println(sb);

            inputStream.close();


        }catch(MalformedURLException e){
            System.out.println("eroor" + e.getMessage());
        }catch(IOException e){
            System.out.println("error");
        }
        return sb.toString();
    }
    
}
