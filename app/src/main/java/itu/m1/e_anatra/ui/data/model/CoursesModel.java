package itu.m1.e_anatra.ui.data.model;

public class CoursesModel {
    private String title;
    private String content;
    private String type;
    private String imageUrl;

    public CoursesModel(String title, String content, String type, String imageUrl) {
        this.title = title;
        this.content = content;
        this.type = type;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
