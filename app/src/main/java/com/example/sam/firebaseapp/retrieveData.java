package com.example.sam.firebaseapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
//https://www.firebase.com/docs/web/guide/understanding-data.html

public class retrieveData extends ActionBarActivity {
    Intent newNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.retrieve_data);
       newNext = getIntent();


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
 /*Firebase.setAndroidContext(this);
        Firebase myFirebaseRef = new Firebase("https://blistering-inferno-9204.firebaseio.com");
        Firebase ref = new Firebase("https://blistering-inferno-9204.firebaseio.com/web/data/users/schung/name");

        myFirebaseRef.child("users/schung/name").setValue("Sam Chung");
        */
//Log.e("testing", "works?");