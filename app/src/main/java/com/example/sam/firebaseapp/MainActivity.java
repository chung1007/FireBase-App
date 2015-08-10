///////////Created by: Sam.Chung/////////
//////////July 2nd, 2015////////////////
package com.example.sam.firebaseapp;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.firebase.client.Firebase;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);

    }
    public void Save(View v) {

        Toast.makeText(this, "Url Saved", Toast.LENGTH_SHORT).show();
    }


    public void fireBase(View view){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("https://www.firebase.com/signup/"));
        startActivity(intent);
    }

    public void nextClicked(View view) {
       EditText url = (EditText) findViewById(R.id.Url);
        Intent next = new Intent(this, dataPage.class);
        next.putExtra("userUrl", url.getText().toString());
        startActivity(next);

        Log.e("clicked", "next");
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