package com.example.collegescheduler2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.collegescheduler2.Adapter.CourseAdapter;
import com.example.collegescheduler2.Adapter.ExamAdapter;
import com.example.collegescheduler2.Model.CourseModel;
import com.example.collegescheduler2.Model.ExamModel;

import java.util.List;

public class ListOfExam extends AppCompatActivity {
    public static final String EXAMCOURSEANDNAME = "EXAMCOURSEANDNAME";
    public static final String EXAMDATEANDTIME = "EXAMDATEANDTIME";
    public static final String EXAMLOCATION = "EXAMLOCATION";

    private TextView examCourseAndNameText, examDateAndTimeText, examLocationText;
    private String examcourseandname;
    private String examdateandtime;
    private String examlocation;
    private ExamModel todotask;
    private RecyclerView tasksRecyclerView;
    private ExamAdapter tasksAdapter;

    private List<ExamModel> taskList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_of_exam);
        examCourseAndNameText = findViewById(R.id.mExamCourseAndName);
        examDateAndTimeText = findViewById(R.id.mExamDateAndTime);
        examLocationText = findViewById(R.id.mExamLocation);

        Intent i = getIntent();
        examcourseandname = i.getStringExtra(EXAMCOURSEANDNAME);
        examdateandtime = i.getStringExtra(EXAMDATEANDTIME);
        examlocation = i.getStringExtra(EXAMLOCATION);

        //examCourseAndNameText.setText(examcourseandname);
        //examDateAndTimeText.setText(examdateandtime);
        //examLocationText.setText(examlocation);

        tasksRecyclerView = findViewById(R.id.examRecyclerView);
        tasksRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        tasksAdapter = new ExamAdapter(this);
        tasksRecyclerView.setAdapter(tasksAdapter);

        for(int j = 0; j < Home.examArray.size(); j++) {
            todotask = Home.examArray.get(j);

            if (todotask.getStatus()) {
                Home.examArray.remove(todotask);
            }
            tasksAdapter.setTasks(Home.examArray);
        }

        Button returnToHome = (Button) findViewById(R.id.btnGoToHome);
        returnToHome.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListOfExam.this, Home.class);
                startActivity(intent);
            }
        });
        Button returnToAddExam = (Button) findViewById(R.id.btnGoToAddExamss);
        returnToAddExam.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListOfExam.this, AddExam.class);
                startActivity(intent);
            }
        });
    }
}