package BackEnd.WebScapper;

/**
 * @author Pranay Patro
 */


public interface ScrapperConstants {

    String baseUrl = "https://indiaproxy.in";
    String mainPageContentPatternString = "<div class=\"detName\">			<a href=\"(.+?)\" class=\"detLink\"";
    String magnetPageContentPatternString = "<a.*href=\"(.+?)\" title=\"Get this torrent\">";

}
