package itu.m1.e_anatra.service.api.result.course;

import com.google.gson.annotations.SerializedName;

public class CourseResult {
    @SerializedName("_id")
    private String id;

    @SerializedName("title")
    private String title;

    @SerializedName("picture")
    private String picture;

    @SerializedName("description")
    private String description;

    @SerializedName("type")
    private String type;

    @SerializedName("url")
    private String url;

    public CourseResult(String id, String title, String picture, String description, String type, String url) {
        this.id = id;
        this.title = title;
        this.picture = picture;
        this.description = description;
        this.type = type;
        this.url = url;
    }

    public String getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getPicture() {
        return picture;
    }
    public String getDescription() {
        return description;
    }
    public String getType() {
        return type;
    }
    public String getUrl() {
        return url;
    }
}
