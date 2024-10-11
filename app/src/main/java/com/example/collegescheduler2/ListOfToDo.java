package com.example.collegescheduler2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.collegescheduler2.Adapter.ToDoAdapter;
import com.example.collegescheduler2.Model.ToDoModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListOfToDo extends AppCompatActivity {
    public static final String TODOTASK = "TODOTASK";

    private TextView todoTaskText;
    private ToDoModel todotask;
    private RecyclerView tasksRecyclerView;
    private ToDoAdapter tasksAdapter;

    private List<ToDoModel> taskList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_of_to_do);
        todoTaskText = findViewById(R.id.mToDoTask);

        taskList = new ArrayList<>();

        tasksRecyclerView = findViewById(R.id.tasksRecyclerView);
        tasksRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        tasksAdapter = new ToDoAdapter(this);
        tasksRecyclerView.setAdapter(tasksAdapter);

        Intent i = getIntent();

        for(int j = 0; j < Home.todoArray.size(); j++) {
            todotask = Home.todoArray.get(j);

//            if (todotask.getStatus()) {
//                Home.todoArray.remove(todotask);
//            }
            tasksAdapter.setTasks(Home.todoArray);
        }


        Button returnToHome = (Button) findViewById(R.id.btnGoToHome);
        returnToHome.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListOfToDo.this, Home.class);
                startActivity(intent);
            }
        });

        Button returnToAddToDo = (Button) findViewById(R.id.btnGoToAddToDo);
        returnToAddToDo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListOfToDo.this, AddToDo.class);
                startActivity(intent);
            }
        });

        Button sortButton = findViewById(R.id.btnSort);
        sortButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<ToDoModel> sorted = sortList(tasksAdapter.getTasks());
                refreshList(sorted);
            }
        });

        Button reverse = findViewById(R.id.reverse);
        reverse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<ToDoModel> reverse = reverse(tasksAdapter.getTasks());
                refreshList(reverse);
            }
        });
        Button dateASC = findViewById(R.id.dateASC);
        dateASC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tasksAdapter.dateASC();
            }
        });

        Button dateDESC = findViewById(R.id.dateDESC);
        dateDESC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tasksAdapter.dateDESC();
            }
        });

    }

    private List<ToDoModel> sortList(List<ToDoModel> tasks) {
        Collections.sort(tasks, new Comparator<ToDoModel>() {
            @Override
            public int compare(ToDoModel task1, ToDoModel task2) {
                return task1.getTask().compareTo(task2.getTask());
            }
        });
        return tasks;
    }

    private void refreshList(List<ToDoModel> updated){
        tasksAdapter.setTasks(updated);
    }
    private List<ToDoModel> reverse(List<ToDoModel> tasks) {
        Collections.sort(tasks, new Comparator<ToDoModel>() {
            @Override
            public int compare(ToDoModel task1, ToDoModel task2) {
                return task2.getTask().compareTo(task1.getTask());
            }
        });
        return tasks;
    }

    private void delete(ToDoModel task){

    }
}