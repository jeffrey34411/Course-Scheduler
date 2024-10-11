package com.example.collegescheduler2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.collegescheduler2.Adapter.CourseAdapter;
import com.example.collegescheduler2.Adapter.ToDoAdapter;
import com.example.collegescheduler2.Model.CourseModel;
import com.example.collegescheduler2.Model.ToDoModel;

import java.util.List;

public class ListOfCourse extends AppCompatActivity {
    public static final String COURSENAME = "COURSENAME";
    public static final String COURSEDATEANDTIME = "COURSEDATEANDTIME";
    public static final String COURSEPROFESSORANDSECTION = "COURSEPROFESSORANDSECTION";
    public static final String COURSELOCATIONANDROOMNUMBER = "COURSELOCATIONANDROOMNUMBER";

    private TextView courseNameText, courseDateAndTimeText, courseProfessorAndSectionText, courseLocationAndRoomNumberText;
    private String coursename;
    private String coursedateandtime;
    private String courseprofessorandsection;
    private String courselocationandroomnumber;

    private CourseModel todotask;
    private RecyclerView tasksRecyclerView;
    private CourseAdapter tasksAdapter;

    private List<CourseModel> taskList;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_of_course);
        courseNameText = findViewById(R.id.mCourseName);
        courseDateAndTimeText = findViewById(R.id.mCourseDateAndTime);
        courseProfessorAndSectionText = findViewById(R.id.mCourseProfessorAndSection);
        courseLocationAndRoomNumberText = findViewById(R.id.mCourseLocationAndRoomNumber);

        Intent i = getIntent();
        coursename = i.getStringExtra(COURSENAME);
        coursedateandtime = i.getStringExtra(COURSEDATEANDTIME);
        courseprofessorandsection = i.getStringExtra(COURSEPROFESSORANDSECTION);
        courselocationandroomnumber = i.getStringExtra(COURSELOCATIONANDROOMNUMBER);

        tasksRecyclerView = findViewById(R.id.courseRecyclerView);
        tasksRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        tasksAdapter = new CourseAdapter(this);
        tasksRecyclerView.setAdapter(tasksAdapter);


        tasksAdapter.setTasks(Home.courseArray);


        Button returnToHome = (Button) findViewById(R.id.btnGoToHome);
        returnToHome.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListOfCourse.this, Home.class);
                startActivity(intent);
            }
        });

        Button returnToAddCourse = (Button) findViewById(R.id.btnGoToAddCourse);
        returnToAddCourse.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListOfCourse.this, AddCourse.class);
                startActivity(intent);
            }
        });
    }
}