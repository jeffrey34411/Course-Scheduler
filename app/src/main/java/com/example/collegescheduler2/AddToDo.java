package com.example.collegescheduler2;

import androidx.appcompat.app.AppCompatActivity;
import com.example.collegescheduler2.Home;
import com.example.collegescheduler2.Model.CourseModel;
import com.example.collegescheduler2.Model.ToDoModel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddToDo extends AppCompatActivity {
    private EditText todoTaskText;
    private EditText todoDateText;
    private Button addToDoButton;
    private String todotask;
    private String tododate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_to_do);
        todoTaskText = findViewById(R.id.mToDoTask);
        todoDateText = findViewById(R.id.mToDoDueDate);
        addToDoButton = findViewById(R.id.btnAddToDo);

        addToDoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData();
            }
        });

        Button returnToHome = (Button) findViewById(R.id.btnGoToHome);
        returnToHome.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddToDo.this, Home.class);
                startActivity(intent);
            }
        });

        Button goToListOfToDo = (Button) findViewById(R.id.btnGoToToDoList);
        goToListOfToDo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddToDo.this, ListOfToDo.class);
                startActivity(intent);
            }
        });
    }
    public void sendData() {
        todotask = todoTaskText.getText().toString().trim();
        tododate = todoDateText.getText().toString().trim();
        Intent i = new Intent(AddToDo.this, ListOfToDo.class);

        ToDoModel task = new ToDoModel(todotask, tododate,false);
        task.setStatus(false);

       // ToDoModel task = new ToDoModel();
        task.setTask(todotask);
        task.setStatus(false);
        task.setId(Home.todoArray.size());

        Home.todoArray.add(task);

//        i.putExtra(ListOfToDo.TODOTASK,todotask);

        startActivity(i);
    }
}