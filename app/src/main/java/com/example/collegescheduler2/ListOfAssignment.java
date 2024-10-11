package com.example.collegescheduler2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.collegescheduler2.Adapter.AssignmentAdapter;
import com.example.collegescheduler2.Adapter.CourseAdapter;
import com.example.collegescheduler2.Model.AssignmentModel;
import com.example.collegescheduler2.Model.CourseModel;

import java.util.List;

public class ListOfAssignment extends AppCompatActivity {
    public static final String ASSIGNMENTTITLE = "ASSIGNMENTTITLE";
    public static final String ASSIGNMENTDUEDATE = "ASSIGNMENTTITLE";
    public static final String ASSIGNMENTCLASS = "ASSIGNMENTTITLE";


    private TextView assignmentTitleText, assignmnentDueDateText, assignmentClassText;
    private String assignmenttitle;
    private String assignmentduedate;
    private String assignmentclass;

    private AssignmentModel todotask;
    private RecyclerView tasksRecyclerView;
    private AssignmentAdapter tasksAdapter;

    private List<AssignmentModel> taskList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_of_assignment);

        assignmentTitleText = findViewById(R.id.mAssignmentTitle);
        assignmnentDueDateText = findViewById(R.id.mAssignmentDueDate);
        assignmentClassText = findViewById(R.id.mAssignmentClass);


        Intent i = getIntent();
        assignmenttitle = i.getStringExtra(ASSIGNMENTTITLE);
        assignmentduedate = i.getStringExtra(ASSIGNMENTDUEDATE);
        assignmentclass = i.getStringExtra(ASSIGNMENTCLASS);


        //assignmentTitleText.setText(assignmenttitle);
        //assignmnentDueDateText.setText(assignmentduedate);
        //assignmentClassText.setText(assignmentclass);

        tasksRecyclerView = findViewById(R.id.assignmentRecyclerView);
        tasksRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        tasksAdapter = new AssignmentAdapter(this);
        tasksRecyclerView.setAdapter(tasksAdapter);

        for(int j = 0; j < Home.assignmentArray.size(); j++) {
            todotask = Home.assignmentArray.get(j);

            if (todotask.getStatus()) {
                Home.courseArray.remove(todotask);
            }
            tasksAdapter.setTasks(Home.assignmentArray);
        }

        Button returnToHome = (Button) findViewById(R.id.btnGoToHome);
        returnToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListOfAssignment.this, Home.class);
                startActivity(intent);
            }
        });

        Button returnToAddAssignments = (Button) findViewById(R.id.btnGoToAddAssignment);
        returnToAddAssignments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListOfAssignment.this, AddAssignment.class);
                startActivity(intent);
            }
        });

        Button sectionASC = findViewById(R.id.sectionASC);
        sectionASC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tasksAdapter.sectionASC();
            }
        });

        Button sectionDESC = findViewById(R.id.sectionDESC);

        sectionDESC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tasksAdapter.sectionDESC();
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
}