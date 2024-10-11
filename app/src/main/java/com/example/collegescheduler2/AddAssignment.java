package com.example.collegescheduler2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.collegescheduler2.Model.AssignmentModel;
import com.example.collegescheduler2.Model.CourseModel;
import com.example.collegescheduler2.Model.ToDoModel;

public class AddAssignment extends AppCompatActivity {
    private EditText assignmentTitleText, assignmentDueDateText, assignmentClassText;
    private Button addAssignmentInfoButton;
    private String assignmenttitle;
    private String assignmentduedate;
    private String assignmentclass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_assignment);
        assignmentTitleText = findViewById(R.id.mAssignmentTitle);
        assignmentDueDateText = findViewById(R.id.mAssignmentDueDate);
        assignmentClassText = findViewById(R.id.mAssignmentClass);

        addAssignmentInfoButton = findViewById(R.id.btnAddAssignment);

        addAssignmentInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData();
            }
        });

        Button returnToHome = (Button) findViewById(R.id.btnGoToHome);
        returnToHome.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddAssignment.this, Home.class);
                startActivity(intent);
            }
        });

        Button goToListOfAssignments = (Button) findViewById(R.id.btnGoToAssignmentList);
        goToListOfAssignments.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddAssignment.this, ListOfAssignment.class);
                startActivity(intent);
            }
        });
    }
    public void sendData() {
        assignmenttitle = assignmentTitleText.getText().toString().trim();
        assignmentduedate = assignmentDueDateText.getText().toString().trim();
        assignmentclass = assignmentClassText.getText().toString().trim();

        Intent i = new Intent(AddAssignment.this, ListOfAssignment.class);

        AssignmentModel task = new AssignmentModel(assignmenttitle, assignmentclass, assignmentduedate, true);
        task.setStatus(false);

        Home.assignmentArray.add(task);

        ToDoModel todo = new ToDoModel(assignmenttitle, assignmentduedate,false);
        todo.setTask(assignmenttitle);
        todo.setStatus(false);
        todo.setId(Home.todoArray.size());
        Home.todoArray.add(todo);

        //i.putExtra(ListOfAssignment.ASSIGNMENTTITLE,assignmenttitle);
        //i.putExtra(ListOfAssignment.ASSIGNMENTDUEDATE,assignmentduedate);
        //i.putExtra(ListOfAssignment.ASSIGNMENTCLASS,assignmentclass);

        startActivity(i);
    }
}