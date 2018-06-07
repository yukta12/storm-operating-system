package BackEnd.WebScapper;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchResults {


    /**
     * This will be the main method which will be called and all other methods will be called by this method...
     * a huge stack of methods are called recursively.
     * please donot change the position and flow of methods.
     * @param searchQuery query to be search.
     * @return  ArrayList of TorrentObjects.
     * @throws Exception
     */
    public static ArrayList<TorrentObject> mainType(String searchQuery) throws Exception {
//        this list will contain all the objects of TorrentObject class which will contain torrent name and magnet URL.
        ArrayList<TorrentObject> torrentObjectsLists = new ArrayList<>();

        String mainPageContent = getURLSource(ScrapperConstants.baseUrl + "/s/?q=" + searchQuery);

        Pattern mainPageContentGroupPattern =Pattern.compile(ScrapperConstants.mainPageContentPatternString);
        Matcher mainPageContentGroupMatcher = mainPageContentGroupPattern.matcher(mainPageContent);

        while(mainPageContentGroupMatcher.find()){
            String name = mainPageContentGroupMatcher.group(1);
            String magnetUrl = magnetUrl(ScrapperConstants.baseUrl, mainPageContentGroupMatcher.group(1));
            torrentObjectsLists.add(new TorrentObject(name, magnetUrl));
        }

        return torrentObjectsLists;

    }


    /**
     * this method will parse the link from the main page and and will return the magnet url which will be used
     * this is implemented by regex.
     * @param baseUrl it is the proxy website.
     * @param links it is the search query used by the piratesbay to perform search operation on the website.
     * @return it will return a string of magnet url.
     * @throws Exception
     */
    private static String magnetUrl(final String baseUrl, final String links) throws Exception{
        String magnetLink = "";
        String magnetPageContent = getURLSource(baseUrl + links);

        Pattern magnetPageContentGroupPattern = Pattern.compile(ScrapperConstants.magnetPageContentPatternString);
        Matcher magnetPageContentGroupMatcher = magnetPageContentGroupPattern.matcher(magnetPageContent);

        while(magnetPageContentGroupMatcher.find()){
            magnetLink = magnetPageContentGroupMatcher.group(1);
            return magnetLink;
        }
        return null;
    }


    /**
     * this is a universal method when called, will return the html code of the website,
     * all the user-Agent has been det in case if the website denys the access.
     * @param url this is the url path of which you want the content.
     * @return returns the string content of a web page.
     * @throws IOException
     */
    private static String getURLSource(String url) throws IOException
    {
        URL urlObject = new URL(url);
        URLConnection urlConnection = urlObject.openConnection();
        urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");

        return toString(urlConnection.getInputStream());
    }


    /**
     * overridden this for my convinience please do not modify.
     * @param inputStream
     * @return
     * @throws IOException
     */
    private static String toString(InputStream inputStream) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8")))        {
            String inputLine;
            StringBuilder stringBuilder = new StringBuilder();
            while ((inputLine = bufferedReader.readLine()) != null) {
                stringBuilder.append(inputLine);
            }
            PrintWriter writer = new PrintWriter("pagecontent.txt", "UTF-8");
            writer.println(stringBuilder.toString());

            return stringBuilder.toString();
        }
    }
}
