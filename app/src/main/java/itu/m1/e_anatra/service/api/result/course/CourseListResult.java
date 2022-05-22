package itu.m1.e_anatra.service.api.result.course;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import itu.m1.e_anatra.service.api.result.user.UserResult;

public class CourseListResult {
    @SerializedName("contents")
    private List<CourseResult> courses;

    public CourseListResult(List<CourseResult> courses) {
        this.courses = courses;
    }

    public List<CourseResult> getCourses() {
        return courses;
    }
}
