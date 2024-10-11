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

import com.example.collegescheduler2.AddAssignment;
import com.example.collegescheduler2.AddCourse;
import com.example.collegescheduler2.Home;
import com.example.collegescheduler2.ListOfAssignment;
import com.example.collegescheduler2.ListOfCourse;
import com.example.collegescheduler2.ListOfToDo;
import com.example.collegescheduler2.Model.AssignmentModel;
import com.example.collegescheduler2.Model.CourseModel;
import com.example.collegescheduler2.Model.ToDoModel;
import com.example.collegescheduler2.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class AssignmentAdapter extends RecyclerView.Adapter<AssignmentAdapter.ViewHolder> {
    private List<AssignmentModel> assignmentList;
    private ListOfAssignment activity;
    public static AssignmentModel clickedItem = null;

    public AssignmentAdapter(ListOfAssignment activity) {
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
        final AssignmentModel item = Home.assignmentArray.get(position);
        holder.task.setText(item.getName() + " - " + item.getSection() + " - " + item.getDate());
        holder.task.setChecked(item.getStatus());

        holder.task.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    item.setStatus(true);
                    Home.assignmentArray.remove(item);
                    notifyItemRemoved(position);
                    notifyItemRangeChanged(position, Home.assignmentArray.size());
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
        return assignmentList.size();
    }

    public void setTasks(List<AssignmentModel> assignmentList) {
        this.assignmentList = assignmentList;
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
                clickedItem = Home.assignmentArray.get(position);
                Home.assignmentArray.remove(clickedItem);
                Context context = view.getContext();
                context.startActivity(new Intent(context, AddAssignment.class));
            }
        }
    }

    public void sectionASC() {
        Collections.sort(assignmentList, new Comparator<AssignmentModel>() {
            @Override
            public int compare(AssignmentModel assignment1, AssignmentModel assignment2) {
                // Implement your comparison logic here
                // For example, if you want to sort by assignment name:
                return assignment1.getSection().compareTo(assignment2.getSection());
            }
        });
        notifyDataSetChanged(); // Notify the adapter that the data has changed
    }

    public void sectionDESC() {
        Collections.sort(assignmentList, new Comparator<AssignmentModel>() {
            @Override
            public int compare(AssignmentModel assignment1, AssignmentModel assignment2) {
                // Implement your comparison logic here
                // For example, if you want to sort by assignment name:
                return assignment2.getSection().compareTo(assignment1.getSection());
            }
        });
        notifyDataSetChanged(); // Notify the adapter that the data has changed
    }

    public void dateASC() {
        Collections.sort(assignmentList, new Comparator<AssignmentModel>() {
            @Override
            public int compare(AssignmentModel assignment1, AssignmentModel assignment2) {
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
        Collections.sort(assignmentList, new Comparator<AssignmentModel>() {
            @Override
            public int compare(AssignmentModel assignment1, AssignmentModel assignment2) {
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