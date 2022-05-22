package itu.m1.e_anatra.service;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import itu.m1.e_anatra.service.api.RetrofitClient;
import itu.m1.e_anatra.service.api.result.BaseResult;
import itu.m1.e_anatra.service.api.result.course.CourseListResult;
import itu.m1.e_anatra.service.api.result.course.CourseResult;
import itu.m1.e_anatra.service.session.UserConnectionSession;
import itu.m1.e_anatra.ui.home.HomeFragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CourseService {
    public List<CourseResult> findAllCourses(HomeFragment homeFragment) {
        Call<BaseResult<CourseListResult>> call = RetrofitClient.getInstance().getApi().findAllCourses();
        final List<CourseResult> courses = new ArrayList<CourseResult>();
        Callback<BaseResult<CourseListResult>> callback = new Callback<BaseResult<CourseListResult>>() {
            @Override
            public void onResponse(Call<BaseResult<CourseListResult>> call, Response<BaseResult<CourseListResult>> response) {
                if(response.isSuccessful()) {
                    BaseResult<CourseListResult> result = response.body();
                    if (result.isSuccessful()) {
                        homeFragment.setUpRecyclerView(result.getData().getCourses());
                    }
                }
            }
            @Override
            public void onFailure(Call<BaseResult<CourseListResult>> call, Throwable t) {
                Log.d("error-api", t.getMessage());
            }
        };
        call.enqueue(callback);
        return courses;
    }
}
