package com.example.tp4_todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView toDoList;
    private ArrayList<String> toDo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main();
    }


    public void main(){
        String text[] = {"OUI","NON","oui"};
        toDo = new ArrayList<>(Arrays.asList(text));

        System.out.println(toDo);
        toDoList = (ListView) findViewById(R.id.toDoList);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,toDo);

        toDoList.setAdapter(adapter);




        toDoList = (ListView) findViewById(R.id.toDoList);
        toDoList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Object o = toDoList.getItemAtPosition(i);
                System.out.println(o);
            }
        });

    }
}