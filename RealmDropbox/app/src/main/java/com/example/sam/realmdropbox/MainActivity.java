package com.example.sam.realmdropbox;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import io.realm.Realm;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.dropbox.sync.android.DbxAccountManager;
import com.dropbox.sync.android.DbxException;
import com.dropbox.sync.android.DbxFile;
import com.dropbox.sync.android.DbxFileSystem;
import com.dropbox.sync.android.DbxPath;


public class MainActivity extends ActionBarActivity {
    public static final int REQUEST_LINK_TO_DBX = 254;
    public static final String APP_KEY = "fu1drprr1bha4zl";
    public static final String APP_SECRET = "x8f4ehb2qyk30r4";

    private DbxAccountManager mDbxAcctMgr;
    private DbxFileSystem fileSystem;
    private DbxFile file;
    private DbxPath path;

    String name;
    String message;
    int age;
    Realm realm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        realm = realm.getInstance(this);
        mDbxAcctMgr = DbxAccountManager.getInstance(getApplicationContext(), APP_KEY, APP_SECRET);
        mDbxAcctMgr.startLink((Activity)this, REQUEST_LINK_TO_DBX);


    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode == REQUEST_LINK_TO_DBX){
            if (resultCode == Activity.RESULT_OK){
               try{
                   fileSystem =  DbxFileSystem.forAccount(mDbxAcctMgr.getLinkedAccount());
               }catch(DbxException.Unauthorized ue) {
                   Context context = getApplicationContext();
                   CharSequence cS = "Unauthorized account...";
                   int duration = Toast.LENGTH_SHORT;
                   Toast toast = Toast.makeText(context, cS, duration);
                   toast.show();
               }catch(DbxException e) {
                   Context context = getApplicationContext();
                   CharSequence cS = "Something is wrong...";
                   int duration = Toast.LENGTH_SHORT;
                   Toast toast = Toast.makeText(context, cS, duration);
                   toast.show();

               }
               try{
                DbxFile file = fileSystem.create(new DbxPath("/"));
            }catch(DbxException e) {
                   Context context = this.getApplicationContext();
                   CharSequence cS = "Try Again";
                   int Duration = Toast.LENGTH_SHORT;
                   Toast toast = Toast.makeText(context, cS, Duration);
                   toast.show();

               }

               }
        }
    }

    public void Submit(View view){
        EditText nameInput = (EditText)findViewById(R.id.Name);
        name = nameInput.getText().toString();
        nameInput.setText("");
        if(nameInput.getText().toString().equals("")) {
            Context context = this.getApplicationContext();
            CharSequence warning = "Enter a name!";
            int Duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, warning, Duration);
            toast.show();
        }
        EditText ageInput = (EditText)findViewById(R.id.Age);
        age = Integer.parseInt(ageInput.getText().toString());
        ageInput.setText("");
        if(ageInput.getText().toString().equals("")) {
            Context context = this.getApplicationContext();
            CharSequence warning = "Enter an age!";
            int Duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, warning, Duration);
            toast.show();
        }
        EditText messageInput = (EditText)findViewById(R.id.Message);
        message = messageInput.getText().toString();
        messageInput.setText("");
        if(messageInput.getText().toString().equals("")){
            Context context = this.getApplicationContext();
            CharSequence warning = "Input a message!";
            int Duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, warning, Duration);
            toast.show();
        }

            realm.beginTransaction();
            Information information = realm.createObject(Information.class);
            information.setName(name);
            information.setAge(age);
            information.setMessage(message);


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
