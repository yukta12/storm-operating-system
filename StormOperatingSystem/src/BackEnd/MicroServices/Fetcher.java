package BackEnd.MicroServices;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import org.json.simple.*;
import java.util.Iterator;
import java.util.*;
import java.util.Map.*;




public class Fetcher {

    /*
        ****************************************************************************************
        * this fetchNews is the static method that returns arraylist that parse the json api file.
        * @param=nothing
        * @returns=arraylist of news object
        ******************************************************************************************
     */
    public static ArrayList<NewsObject> fetchNews() {
        ArrayList<NewsObject> news = new ArrayList<>();
        try {
            Object object = new JSONParser().parse(new UrlConnection().readApi());
            JSONObject jsonObject = (JSONObject) object;
            String status = (String) jsonObject.get("status");
            long totalResults = (long) jsonObject.get("totalResults");
            System.out.println(status);
            System.out.println(totalResults);

            JSONArray ja = (JSONArray) jsonObject.get("articles");
            for (Object anotherObject : ja) {
                JSONObject result = (JSONObject) anotherObject;
                String publishedAt = (String) result.get("publishedAt");
                String id = (String) result.get("id");
                String title = (String) result.get("title");
                String description = (String) result.get("description");
                String author = (String) result.get("author");
                news.add(new NewsObject(title, description, author, publishedAt));
            }
            return news;
        } catch(ParseException pe) {
            pe.printStackTrace();
        }
        return null;
    }

}
