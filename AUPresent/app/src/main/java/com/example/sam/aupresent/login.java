package com.example.sam.aupresent;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


public class login extends ActionBarActivity {
    String Lydia;
    String Chung;
    String firstName;
    String lastName;
    String familyName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void auClick(View view){
       ImageView Au = (ImageView)findViewById(R.id.auLogo);
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.addCategory(Intent.CATEGORY_BROWSABLE);
            intent.setData(Uri.parse("http://www.american.edu/"));
            startActivity(intent);
        }

    public void submitSuccess(){
        Intent family = new Intent(this, Family.class);
        startActivity(family);
    }
    public void warn(){
        Context context = getApplicationContext();
        CharSequence warning = "Make sure you use capitals!";
        int Duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, warning, Duration);
        toast.show();
    }

    public void submitClick(View view){
        EditText first = (EditText)findViewById(R.id.firstName);
        firstName = first.getText().toString();
        if(first.getText().toString().equals("Lydia")){
         submitSuccess();
        }else{
           warn();
        }

        EditText last = (EditText)findViewById(R.id.lastName);
        lastName = last.getText().toString();
        if(last.getText().toString().equals("Chung")){
           submitSuccess();
        }else{
            warn();
        }

        EditText family = (EditText)findViewById(R.id.familyName);
        familyName = family.getText().toString();
        if(family.getText().toString().equals("Chung")){
            submitSuccess();
        }else{
            warn();
        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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
