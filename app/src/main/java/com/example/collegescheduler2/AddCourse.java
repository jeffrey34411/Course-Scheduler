package com.example.collegescheduler2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.collegescheduler2.Model.CourseModel;
import com.example.collegescheduler2.Model.ToDoModel;

public class AddCourse extends AppCompatActivity {
    private EditText courseNameText, courseDateAndTimeText, courseProfessorAndSectionText, courseLocationAndRoomNumberText;
    private Button addCourseInfoButton;
    private String coursename;
    private String coursedateandtime;
    private String courseprofessorandsection;
    private String courselocationandroomnumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_course);
        courseNameText = findViewById(R.id.mCourseName);
        courseDateAndTimeText = findViewById(R.id.mCourseDateAndTime);
        courseProfessorAndSectionText = findViewById(R.id.mCourseProfessorAndSection);
        courseLocationAndRoomNumberText = findViewById(R.id.mCourseLocationAndRoomNumber);
        addCourseInfoButton = findViewById(R.id.btnAddCourse);

        addCourseInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData();
            }
        });

        Button returnToHome = (Button) findViewById(R.id.btnGoToHome);
        returnToHome.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddCourse.this, Home.class);
                startActivity(intent);
            }
        });

        Button goToListOfCourses = (Button) findViewById(R.id.btnGoToCourseList);
        goToListOfCourses.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddCourse.this, ListOfCourse.class);
                startActivity(intent);
            }
        });
    }
    public void sendData() {
        coursename = courseNameText.getText().toString().trim();
        coursedateandtime = courseDateAndTimeText.getText().toString().trim();
        courseprofessorandsection = courseProfessorAndSectionText.getText().toString().trim();
        courselocationandroomnumber = courseLocationAndRoomNumberText.getText().toString().trim();

        Intent i = new Intent(AddCourse.this, ListOfCourse.class);

        CourseModel task = new CourseModel(coursename, courseprofessorandsection, coursedateandtime, courselocationandroomnumber, true);
        task.setStatus(false);

        Home.courseArray.add(task);


        startActivity(i);
    }
}