package com.example.collegescheduler2.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.collegescheduler2.AddCourse;
import com.example.collegescheduler2.AddToDo;
import com.example.collegescheduler2.Home;
import com.example.collegescheduler2.ListOfCourse;
import com.example.collegescheduler2.ListOfToDo;
import com.example.collegescheduler2.Model.CourseModel;
import com.example.collegescheduler2.Model.ToDoModel;
import com.example.collegescheduler2.R;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> {
    private List<CourseModel> todoList;
    private ListOfCourse activity;
    public static CourseModel clickedItem = null;

    public CourseAdapter(ListOfCourse activity) {
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.task_layout, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final CourseModel item = Home.courseArray.get(position);
        holder.task.setText(item.getName() + " -  " + item.getSection() + " -  " + item.getDate() + " - " + item.getLocation());
        holder.task.setChecked(item.getStatus());

        holder.task.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    item.setStatus(true);
                    Home.courseArray.remove(item);
                    notifyItemRemoved(position);
                    notifyItemRangeChanged(position, Home.courseArray.size());
                } else {
                    item.setStatus(false);
                }
            }
        });
    }

    private boolean toBoolean(int n) {
        return n != 0;
    }

    @Override
    public int getItemCount() {
        return todoList.size();
    }

    public void setTasks(List<CourseModel> todoList) {
        this.todoList = todoList;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public CheckBox task;

        ViewHolder(View view) {
            super(view);
            task = view.findViewById(R.id.todoCheckBox);
            view.setOnClickListener(this); // Set the ViewHolder as the click listener for the itemView
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                clickedItem = Home.courseArray.get(position);
                Home.courseArray.remove(clickedItem);
                Context context = view.getContext();
                context.startActivity(new Intent(context, AddCourse.class));
            }
        }

    }
}