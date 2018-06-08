package BackEnd.MicroServices;


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
            URL url = new URL("https://newsapi.org/v2/top-headlines?sources=techcrunch&apiKey=2458ead0bce74439a6ebeb0579fafb14");
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
    // public static void main(String[] args) {
    //    	new UrlConnection().readApi();
    // }
}