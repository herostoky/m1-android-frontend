package itu.m1.e_anatra.ui.data.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import itu.m1.e_anatra.R;

public class CoursesHolder extends RecyclerView.ViewHolder {

    public TextView courseTitle, courseContent, courseType;
    public ImageView courseImageView;
    public View view;

    public CoursesHolder(@NonNull View itemView) {
        super(itemView);

        courseImageView = (ImageView)itemView.findViewById(R.id.course_img);
        courseTitle     = (TextView)itemView.findViewById(R.id.course_title);
        courseContent   = (TextView)itemView.findViewById(R.id.course_content);
        courseType      = (TextView)itemView.findViewById(R.id.course_type);
        view = itemView;
    }

}
