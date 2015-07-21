///////////Created by: Sam.Chung///////////////////////
//////////July 2nd, 2015////////////////
package com.example.sam.firebaseapp;
import android.content.Intent;
import android.content.Context;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.firebase.client.Firebase;
//https://www.firebase.com/docs/web/guide/understanding-data.html

public class MainActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
//goes to the website to create new account
    public void fireBase(View view){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("https://www.firebase.com/signup/"));
        startActivity(intent);
    }
//goes to the datapage
    public void nextClicked(View view) {
        Intent next = new Intent(this, dataPage.class);
        startActivity(next);
        Log.e("clicked", "next");
    }
       //sends data to the database of their account
    //refreshes their keyName, message
    //makes sure the user didn't leave out any information
    //calls that the message was sent
    public void Submit(View view){

        EditText url= (EditText) findViewById(R.id.Url);
        url.getText().toString();
        if(url.equals("")){
            Context context = this.getApplicationContext();
            CharSequence warning = "type in your Url!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, warning, duration);
            toast.show();
        }
        EditText key = (EditText)findViewById(R.id.keyName);
        key.getText().toString();
        if(key.equals("")){
             Context context = this.getApplicationContext();
             CharSequence warning = "type in your key name!";
             int duration = Toast.LENGTH_SHORT;
             Toast toast = Toast.makeText(context, warning, duration);
             toast.show();
         }
        EditText message = (EditText)findViewById(R.id.Message);
        message.getText().toString();
        if(message.equals("")){
            Context context = this.getApplicationContext();
            CharSequence warning = "type in your message!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, warning, duration);
            toast.show();
        }
        Firebase.setAndroidContext(this);
        Firebase myFirebaseRef = new Firebase(url + "");
        myFirebaseRef.child(key + ": ").setValue(message);

        Context context = this.getApplicationContext();
        CharSequence warning = "your message was sent";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, warning, duration);
        toast.show();

        key.setText("");
        message.setText("");


    }

    public void View(View view){
        EditText url = (EditText)findViewById(R.id.Url);
        url.getText().toString();
        Intent viewPage = new Intent();
        viewPage.setAction(Intent.ACTION_VIEW);
        viewPage.addCategory(Intent.CATEGORY_BROWSABLE);
        viewPage.setData(Uri.parse(url + ""));
        startActivity(viewPage);
    }

    public void forgotClicked(View view){
        Intent forgot = new Intent();
        forgot.setAction(Intent.ACTION_VIEW);
        forgot.addCategory(forgot.CATEGORY_BROWSABLE);
        forgot.setData(Uri.parse("https://www.firebase.com/login/"));
        startActivity(forgot);
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