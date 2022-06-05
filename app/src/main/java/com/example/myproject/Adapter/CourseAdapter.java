package com.example.myproject.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myproject.Model.Course;
import com.example.myproject.R;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {

    private Context context;
    private List<Course> courseList;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public CourseAdapter(Context context, List<Course> courseList) {
        this.context = context;
        this.courseList = courseList;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View courseItem = LayoutInflater.from(context).inflate(R.layout.course_item,parent,false);
        return new CourseAdapter.CourseViewHolder(courseItem);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        holder.courseBG.setCardBackgroundColor(Color.parseColor(courseList.get(position).getColor()));
        int imageID = context.getResources().getIdentifier("ic_" + courseList.get(position).getImg(),"drawable",context.getPackageName());
        holder.courseImage.setImageResource(imageID);
        holder.courseTitle.setText(courseList.get(position).getTitle());
        holder.courseDate.setText(courseList.get(position).getDate());
        holder.courseLevel.setText(courseList.get(position).getLevel());


    }

    @Override
    public int getItemCount() {
        return courseList.size();
    }

    public static final class CourseViewHolder extends RecyclerView.ViewHolder{
       CardView courseBG;
        ImageView courseImage;
        TextView courseTitle, courseDate, courseLevel;


        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);
            courseBG = itemView.findViewById(R.id.courseBG);
            courseImage = itemView.findViewById(R.id.course_image);
            courseTitle = itemView.findViewById(R.id.categoryTitle);
            courseDate = itemView.findViewById(R.id.course_date);
            courseLevel = itemView.findViewById(R.id.course_level);
        }
    }
}
