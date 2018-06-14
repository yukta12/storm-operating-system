package BackEnd.WebScapper;

/**
 * @author Pranay Patro
 */

public class TorrentObject {

    private String name="";
    private String magnetUrl="";

    /**
     * this is the constructor that will set the values for the torrent object
     * @param name this is the name of the link comming from the URL
     * @param magnetUrl it is the magnet Url that will be used by the C# module
     *                  to download the file and open the bittorrent by generating events from code.
     */
    public TorrentObject(String name, String magnetUrl) {
        this.name = name;
        this.magnetUrl = magnetUrl;
    }


    /**
     *
     * getters and setters.
     */
    public String getName() {
        return name;
    }

    public String getMagnetUrl() {
        return magnetUrl;
    }

}
