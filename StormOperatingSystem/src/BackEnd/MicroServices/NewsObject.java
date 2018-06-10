package BackEnd.MicroServices;
/*
********************************************************************************************************
*  @author-YUKTA
* this class contains a public parameterized constructor and setters and getters for each string objects
* ******************************************************************************************************
 */
public class NewsObject {
    public NewsObject(String title,String description,String author,String publishedOn){
            this.title=title;
            this.description=description;
            this.author=author;
            this.publishedOn=publishedOn;
    }


    public String getPublishedOn() {
        return publishedOn;
    }

    public void setPublishedOn(String publishedOn) {
        this.publishedOn = publishedOn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String publishedOn,author,description,title;

}
