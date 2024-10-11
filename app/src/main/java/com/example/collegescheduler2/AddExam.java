package com.example.collegescheduler2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.collegescheduler2.Model.CourseModel;
import com.example.collegescheduler2.Model.ExamModel;
import com.example.collegescheduler2.Model.ToDoModel;

public class AddExam extends AppCompatActivity {
    private EditText examCourseAndNameText, examDateAndTimeText, examLocationText;
    private Button addExamInfoButton;
    private String examcourseandname;
    private String examdateandtime;
    private String examlocation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_exam);
        examCourseAndNameText = findViewById(R.id.mExamCourseAndName);
        examDateAndTimeText = findViewById(R.id.mExamDateAndTime);
        examLocationText = findViewById(R.id.mExamLocation);

        addExamInfoButton = findViewById(R.id.btnAddExam);

        addExamInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData();
            }
        });

        Button returnToHome = (Button) findViewById(R.id.btnGoToHome);
        returnToHome.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddExam.this, Home.class);
                startActivity(intent);
            }
        });

        Button goToListOfExams = (Button) findViewById(R.id.btnGoToExamList);
        goToListOfExams.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddExam.this, ListOfExam.class);
                startActivity(intent);
            }
        });
    }
    public void sendData() {
        examcourseandname = examCourseAndNameText.getText().toString().trim();
        examdateandtime = examDateAndTimeText.getText().toString().trim();
        examlocation = examLocationText.getText().toString().trim();

        Intent i = new Intent(AddExam.this, ListOfExam.class);

        ExamModel task = new ExamModel(examcourseandname, examdateandtime, examlocation, false);
        task.setStatus(false);

        Home.examArray.add(task);

        ToDoModel todo = new ToDoModel(examcourseandname, examdateandtime,false);
        todo.setTask(examcourseandname);
        todo.setStatus(false);
        todo.setId(Home.todoArray.size());
        Home.todoArray.add(todo);

       // i.putExtra(ListOfExam.EXAMCOURSEANDNAME,examcourseandname);
        //i.putExtra(ListOfExam.EXAMDATEANDTIME,examdateandtime);
        //i.putExtra(ListOfExam.EXAMLOCATION,examlocation);

        startActivity(i);
    }
}