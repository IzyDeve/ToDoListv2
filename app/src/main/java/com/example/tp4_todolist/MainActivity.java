package com.example.tp4_todolist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView toDoList;
    Button btnAdd;
    private ArrayList<String> toDo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String text[] = {"OUI","NON","oui"};
        toDo = new ArrayList<>(Arrays.asList(text));
        toDoList = (ListView) findViewById(R.id.toDoList);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice,toDo);

        toDoList.setAdapter(adapter);
        main();
    }


    public void main(){

        toDoList = (ListView) findViewById(R.id.toDoList);
        System.out.println(toDoList);
        toDoList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Object o = toDoList.getItemAtPosition(i);
                System.out.println(o);
                System.out.println(toDoList.getItemAtPosition(i));
            }
        });



    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
        //return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.item_done){
            String itemSelected ="Selected items: \n";

            for(int i=0;i < toDoList.getCount();i++){
                if(toDoList.isItemChecked(i)){
                    itemSelected += toDoList.getItemAtPosition(i) + "\n";
                }
            }
            Toast.makeText(this,itemSelected,Toast.LENGTH_SHORT).show();

        }
        return super.onOptionsItemSelected(item);
    }
}