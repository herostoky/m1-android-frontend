package itu.m1.e_anatra.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import java.util.Objects;

import itu.m1.e_anatra.R;
import itu.m1.e_anatra.databinding.FragmentHomeBinding;
import itu.m1.e_anatra.service.CourseService;
import itu.m1.e_anatra.service.api.result.course.CourseResult;
import itu.m1.e_anatra.ui.coursesdetails.CourseDetailsFragment;
import itu.m1.e_anatra.ui.data.adapter.CoursesAdapter;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private RecyclerView recyclerView;
    private CoursesAdapter coursesAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.loadCourses();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void loadCourses() {
        CourseService courseService = new CourseService();
        courseService.findAllCourses(this);
    }

    public void setUpRecyclerView(List<CourseResult> courses) {
        recyclerView = this.getView().findViewById(R.id.courses_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setHasFixedSize(true);
        coursesAdapter = new CoursesAdapter(this.getContext(), courses, this);
        recyclerView.setAdapter(coursesAdapter);
    }

    public void showCourseDetailsFragment(String courseId) {
        Bundle bundle = new Bundle();
        bundle.putString(CourseResult.COURSE_ID_KEY, courseId); // Put anything what you want

        CourseDetailsFragment courseDetailsFragment = new CourseDetailsFragment();
        courseDetailsFragment.setArguments(bundle);
        getFragmentManager().beginTransaction()
                .replace(((ViewGroup)this.getView().getParent()).getId(), courseDetailsFragment, "courseDetailsFragment")
                .addToBackStack(null)
                .commit();
    }
}