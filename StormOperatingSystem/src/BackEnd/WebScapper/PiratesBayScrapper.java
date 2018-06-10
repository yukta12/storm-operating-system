package BackEnd.WebScapper;

import java.util.ArrayList;

/**
 * @author Pranay Patro
 */

public class PiratesBayScrapper {

    public PiratesBayScrapper() {

    }

    /**
     *
     * @param searchQuery is the query that is to be searched on torrent database.
     * @return a ArrayList of TorrentObject.
     * @throws Exception
     */
    public ArrayList<TorrentObject> startScrapping(String searchQuery) throws Exception {
        System.out.println("inside startScrapping");
        return new SearchResults().mainType(searchQuery);
    }
}
