package com.example.sam.firebaseapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.client.core.SyncTree;

import java.util.HashMap;
import java.util.Map;
//https://www.firebase.com/docs/web/guide/understanding-data.html

public class dataPage extends ActionBarActivity {
    /*EditText message;
    EditText key;
    String userMessage;
    String userKey;
*/  String userUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datapage);
        Firebase.setAndroidContext(this);
        Intent next = getIntent();

       /* message = (EditText)findViewById(R.id.Message);
        userMessage = message.getText().toString();
        key = (EditText)findViewById(R.id.keyName);
        userKey= key.getText().toString();*/
        userUrl = next.getStringExtra("userUrl");
    }

//79786848
    public void sendData(){

        EditText message = (EditText)findViewById(R.id.Message);
        String userMessage = message.getText().toString();
        EditText key = (EditText)findViewById(R.id.keyName);
        String userKey = key.getText().toString();

        Firebase.setAndroidContext(this);
        Firebase myFirebaseRef = new Firebase(userUrl);
        myFirebaseRef.child("secondMessage").setValue("Hello World");
        myFirebaseRef.child(userKey).setValue(userMessage);
        Context context = this.getApplicationContext();
        CharSequence success = "Message sent";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, success, duration);
        toast.show();
    }

    public void Submit(View view) {

        EditText message = (EditText) findViewById(R.id.Message);
        String userMessage = message.getText().toString();
        EditText key = (EditText) findViewById(R.id.keyName);
        String userKey = key.getText().toString();

        if (userUrl.equals("") || userKey.equals("") || userMessage.equals("")) {
            Context context = this.getApplicationContext();
            CharSequence warning = "Forgot to input some data!!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, warning, duration);
            toast.show();

            Log.e("Empty?", userMessage);
            Log.e("Empty?", userKey);

        } else {
            sendData();
            key.setText("");
            message.setText("");
        }
    }

    public void View(View view){

        Intent viewPage = new Intent();
        viewPage.setAction(Intent.ACTION_VIEW);
        viewPage.addCategory(Intent.CATEGORY_BROWSABLE);
        viewPage.setData(Uri.parse(userUrl));
        startActivity(viewPage);
    }

    public void secondNext(View view){
        Intent newNext = new Intent(this, retrieveData.class);
        startActivity(newNext);
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