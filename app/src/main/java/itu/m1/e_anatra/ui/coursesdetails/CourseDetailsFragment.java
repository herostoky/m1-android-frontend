package itu.m1.e_anatra.ui.coursesdetails;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import itu.m1.e_anatra.R;
import itu.m1.e_anatra.service.api.result.course.CourseResult;

public class CourseDetailsFragment extends Fragment {

    private CourseDetailsViewModel mViewModel;

    public static CourseDetailsFragment newInstance() {
        return new CourseDetailsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_course_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String id = String.valueOf(getArguments().get(CourseResult.COURSE_ID_KEY));
        ((TextView) view.findViewById(R.id.course_details_title)).setText(id);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(CourseDetailsViewModel.class);
        // TODO: Use the ViewModel
    }

}