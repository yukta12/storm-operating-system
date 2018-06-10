package BackEnd.MicroServices;

/**
 *
 * @author Harsh
 */

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class Fetcher {

    /*
        ****************************************************************************************
        * this fetchWeather is the static method that returns long value of current temperature
        if value is -999 then temperature is invalid .
        * @param=nothing
        * @returns=long
        ******************************************************************************************
     */
    public static long fetchWeather() {
        try {
            Object object = new JSONParser().parse(new UrlConnection().readApi());
            JSONObject jsonObject = (JSONObject) object;
            JSONObject currently = (JSONObject)jsonObject.get("currently");
            Double temperature = (Double) currently.get("temperature");
            Double celcius = (temperature-32)/1.8;
            
            //System.out.println( Math.round(celcius));
            return Math.round(celcius);
               
            
            
        } catch(ParseException pe) {
            pe.printStackTrace();
        }   
        return -999;
    }
}
