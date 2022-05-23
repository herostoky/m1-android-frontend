package itu.m1.e_anatra.ui.data.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import itu.m1.e_anatra.R;
import itu.m1.e_anatra.service.api.result.course.CourseResult;
import itu.m1.e_anatra.ui.data.holder.CoursesHolder;
import itu.m1.e_anatra.ui.home.HomeFragment;

public class CoursesAdapter extends RecyclerView.Adapter<CoursesHolder> {
    private Context context;
    private List<CourseResult> courses;
    private HomeFragment homeFragment;

    public CoursesAdapter(Context context, List<CourseResult> courses, HomeFragment homeFragment) {
        this.context = context;
        this.courses = courses;
        this.homeFragment = homeFragment;
    }

    @Override
    public CoursesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CoursesHolder(LayoutInflater.from(context).inflate(R.layout.list_courses, parent, false));
    }

    @Override
    public void onBindViewHolder(CoursesHolder holder, int position) {
        CourseResult course = courses.get(position);
        holder.courseTitle.setText(course.getTitle());
        holder.courseContent.setText(course.getDescription());
        holder.courseType.setText(course.getType());
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homeFragment.showCourseDetailsFragment(course.getId());
                Log.d("Clicked", course.getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return courses.size();
    }
}
