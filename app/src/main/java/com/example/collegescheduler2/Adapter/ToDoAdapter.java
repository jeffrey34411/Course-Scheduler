package com.example.collegescheduler2.Adapter;

import static androidx.core.content.ContextCompat.startActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.collegescheduler2.AddToDo;
import com.example.collegescheduler2.Home;
import com.example.collegescheduler2.ListOfToDo;
import com.example.collegescheduler2.Model.AssignmentModel;
import com.example.collegescheduler2.Model.ToDoModel;
import com.example.collegescheduler2.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.ViewHolder> {
    private List<ToDoModel> todoList;
    private ListOfToDo activity;

    public ToDoAdapter(ListOfToDo activity) {
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
    public void onBindViewHolder(@NonNull final ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        final ToDoModel item = Home.todoArray.get(position);
        holder.task.setText(item.getTask() + " - " + item.getDate());
        holder.task.setChecked(item.getStatus());

        holder.task.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    item.setStatus(true);
                    Home.todoArray.remove(item);
                    notifyItemRemoved(position);
                    notifyItemRangeChanged(position, Home.todoArray.size());
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

    public void setTasks(List<ToDoModel> todoList) {
        this.todoList = todoList;
        notifyDataSetChanged();
    }

    public List<ToDoModel> getTasks() {
        return todoList;
    }

    public void sortList(Comparator<ToDoModel> taskList) {
        Collections.sort(todoList, taskList);
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
                Context context = view.getContext();
                context.startActivity(new Intent(context, AddToDo.class));
            }
        }
    }
    public void dateASC() {
        Collections.sort(todoList, new Comparator<ToDoModel>() {
            @Override
            public int compare(ToDoModel assignment1, ToDoModel assignment2) {
                String date1 = assignment1.getDate();
                String date2 = assignment2.getDate();

                // Assuming your date format is "YYYY-MM-DD". Adjust accordingly.
                SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

                try {
                    Date parsedDate1 = dateFormat.parse(date1);
                    Date parsedDate2 = dateFormat.parse(date2);

                    // Compare the parsed dates
                    return parsedDate1.compareTo(parsedDate2);
                } catch (ParseException e) {
                    e.printStackTrace();
                    // Handle the exception if parsing fails
                    return 0;
                }
            }
        });

        // Notify the adapter that the data has changed
        notifyDataSetChanged();
    }

    public void dateDESC() {
        Collections.sort(todoList, new Comparator<ToDoModel>() {
            @Override
            public int compare(ToDoModel assignment1, ToDoModel assignment2) {
                String date1 = assignment1.getDate();
                String date2 = assignment2.getDate();

                // Assuming your date format is "YYYY-MM-DD". Adjust accordingly.
                SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

                try {
                    Date parsedDate1 = dateFormat.parse(date1);
                    Date parsedDate2 = dateFormat.parse(date2);

                    // Compare the parsed dates
                    return parsedDate2.compareTo(parsedDate1);
                } catch (ParseException e) {
                    e.printStackTrace();
                    // Handle the exception if parsing fails
                    return 0;
                }
            }
        });

        // Notify the adapter that the data has changed
        notifyDataSetChanged();
    }

}
