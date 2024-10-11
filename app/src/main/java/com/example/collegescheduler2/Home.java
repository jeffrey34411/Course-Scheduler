package com.example.collegescheduler2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.collegescheduler2.Model.AssignmentModel;
import com.example.collegescheduler2.Model.CourseModel;
import com.example.collegescheduler2.Model.ExamModel;
import com.example.collegescheduler2.Model.ToDoModel;

import java.util.ArrayList;

public class Home extends AppCompatActivity {

    public static ArrayList<ToDoModel> todoArray = new ArrayList<>();
    public static ArrayList<CourseModel> courseArray = new ArrayList<>();
    public static ArrayList<AssignmentModel> assignmentArray = new ArrayList<>();
    public static ArrayList<ExamModel> examArray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        Button goToAddCourse = (Button) findViewById(R.id.btnGoToAddCourse);
        goToAddCourse.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, AddCourse.class);
                startActivity(intent);
            }
        });

        Button goToAddAssignment = (Button) findViewById(R.id.btnGoToAddAssignment);
        goToAddAssignment.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, AddAssignment.class);
                startActivity(intent);
            }
        });

        Button goToAddExam= (Button) findViewById(R.id.btnGoToAddExam);
        goToAddExam.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, AddExam.class);
                startActivity(intent);
            }
        });

        Button goToAddToDo = (Button) findViewById(R.id.btnGoToAddToDo);
        goToAddToDo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, AddToDo.class);
                startActivity(intent);
            }
        });
    }
}