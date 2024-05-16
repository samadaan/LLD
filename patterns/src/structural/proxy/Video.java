package structural.proxy;


public class Video {

    private
    String id;
    private String data;
    private String title;

    public Video(String id, String title){
        this.id=id;
        this.title=title;
        this.data="Random data";
    }

    public String getData() {
        return data;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
