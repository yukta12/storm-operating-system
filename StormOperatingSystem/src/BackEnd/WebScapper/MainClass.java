package BackEnd.WebScapper;


/**
 *
 * @author Pranay Patro
 */

public class MainClass {
    public static void main(String[] args) throws Exception {
        PiratesBayScrapper piratesBayScrapper = new PiratesBayScrapper();
//
//        ArrayList<TorrentObject> obj = new ArrayList<>();
//
//        obj = piratesBayScrapper.startScrapping("deadpool");


        /**
         * The enumerator will return an arraylist on which i am iterating.
         */
        for(TorrentObject torrentObject : piratesBayScrapper.startScrapping("deadpool")){
            System.out.println("inside For Loop");
            System.out.println("Name = " + torrentObject.getName() + "\n Magnet = " + torrentObject.getMagnetUrl());
        }
    }
}
