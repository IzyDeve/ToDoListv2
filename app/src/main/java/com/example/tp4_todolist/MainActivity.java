package com.example.tp4_todolist;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
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
    String text[] = {"Sacar al perro","comprar el pan","revisa el correo de la salle","preparar reuniones del día","hacer ejercicio"};
    ArrayAdapter<String> adapter;
    ArrayList<String> toDo = new ArrayList<String>(Arrays.asList(text));

    private final static int MY_REQUEST_CODE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toDoList = (ListView) findViewById(R.id.toDoList);
        btnAdd = (Button) findViewById(R.id.btnAdd);


        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, (List<String>) toDo);
        toDoList.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AddActivity.class);
                startActivityForResult(intent, MY_REQUEST_CODE);
            }
        });


        main();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        System.out.println(resultCode);
        if (resultCode == Activity.RESULT_OK){
            if(requestCode == MY_REQUEST_CODE){
                String newAct = data.getStringExtra("value");
                System.out.println(newAct);
                toDo.add(newAct);
                adapter.notifyDataSetChanged();
            }
        }
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
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.item_done){
            String itemSelected ="Activity done: \n";

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