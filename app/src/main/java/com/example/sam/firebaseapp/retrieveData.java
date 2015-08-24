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

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
//https://www.firebase.com/docs/web/guide/understanding-data.html

public class retrieveData extends ActionBarActivity {
    String userUrl;
    String userKey;
    Firebase myFirebaseRef;
    EditText messageEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.retrieve_data);
       Intent newNext = getIntent();
        Firebase.setAndroidContext(this);
        userUrl = newNext.getStringExtra("userUrl");
        userKey = newNext.getStringExtra("userKey");
        myFirebaseRef = new Firebase(userUrl);
        messageEdit = (EditText)findViewById(R.id.editTextBox);

    }

    public void pickKeyClicked(View view){
        myFirebaseRef.child(userKey).addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot snapshot) {

                messageEdit.setText(snapshot.getValue().toString());

            }

            @Override
            public void onCancelled(FirebaseError error) {
            }
        });
    }

    public void editSubmitClicked(View view){
        EditText keyEdit = (EditText)findViewById(R.id.editKey);
        myFirebaseRef.child(keyEdit.getText().toString()).setValue(messageEdit.getText().toString());
        Context context = this.getApplicationContext();
        CharSequence success = "Message edited";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, success, duration);
        toast.show();
        messageEdit.setText(" ");
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