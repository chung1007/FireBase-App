package com.example.sam.realmproject;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.Attributes;

import javax.xml.datatype.Duration;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmObject;
import io.realm.RealmResults;

import io.realm.Realm;


public class MainActivity extends ActionBarActivity {
    String Name;
    int Age;
    int ageLimit;
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       realm = realm.getInstance(this);


    }
    public void submitClick(View view) {

        EditText nameInput = (EditText) findViewById(R.id.Name);
        Name = nameInput.getText().toString();
        if (nameInput.getText().toString().equals("")) {
            Context context = this.getApplicationContext();
            CharSequence warning = "Enter a Name!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, warning, duration);
            toast.show();
            nameInput.setText("");

        }
        EditText ageInput = (EditText) findViewById(R.id.Age);
        Age = Integer.parseInt(ageInput.getText().toString());
        if(ageInput.getText().toString().equals("")) {
            Context context = this.getApplicationContext();
            CharSequence warning = "Enter an Age!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, warning, duration);
            toast.show();
            ageInput.setText("");
        }
           realm.beginTransaction();
           Person person = realm.createObject(Person.class);
           person.setName(Name);
           person.setAge(Age);
           realm.commitTransaction();

        }


    public void List(View view){

        EditText ageLimInput = (EditText) findViewById(R.id.ageLimit);
        ageLimit = Integer.parseInt(ageLimInput.getText().toString());
        if(ageLimInput.getText().toString().equals("")){
            Context context = this.getApplicationContext();
            CharSequence warning = "Input an Age limit";
            int Duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, warning, Duration);
            toast.show();
            ageLimInput.setText("");

        }

         RealmQuery<Person>query = realm.where(Person.class);
         query.lessThanOrEqualTo("ageLimit", Age);
         RealmResults<Person>result = query.findAll();

        ArrayList<Map<String, String>> personList = new ArrayList<>();

        for(Person person : result) {
            Map<String, String> people = new HashMap<>();
            people.put("Name", person.getName());
            people.put("Age", person.getAge() + "");
            personList.add(people);
        }


            Intent intent = new Intent(this, PeopleList.class);
            intent.putExtra("people" , personList);
            startActivity(intent);

            }









        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);

    }

}




