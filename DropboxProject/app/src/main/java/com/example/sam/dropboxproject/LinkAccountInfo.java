package com.example.sam.dropboxproject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dropbox.sync.android.DbxAccount;
import com.dropbox.sync.android.DbxAccountManager;
import com.dropbox.sync.android.DbxException;
import com.dropbox.sync.android.DbxFile;
import com.dropbox.sync.android.DbxFileSystem;
import com.dropbox.sync.android.DbxPath;

import java.io.IOException;


public class LinkAccountInfo extends ActionBarActivity {
    public static final String APP_KEY = "fu1drprr1bha4zl";
    public static final String APP_SECRET = "x8f4ehb2qyk30r4";
    public DbxFileSystem dbxFs;
    public DbxFile dbxF;
    public DbxPath dbxP;
    public DbxAccountManager DAM;
    public DbxAccount dbxA;
    static final int REQUEST_LINK_TO_DBX = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        DAM = DbxAccountManager.getInstance(getApplicationContext(), APP_KEY, APP_SECRET);
        if (!DAM.hasLinkedAccount()) {
            DAM.startLink(this, REQUEST_LINK_TO_DBX);
            Log.e("asdf", "asf");

        } else if (DAM.hasLinkedAccount()) {
            afterDbxLink();
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link_account_info);

    }

    public void afterDbxLink() {
        try {
            dbxFs = DbxFileSystem.forAccount(DAM.getLinkedAccount());

        } catch (DbxException e) {
            Context context = this.getApplicationContext();
            CharSequence warning = "ERROR in FileSystem!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, warning, duration);
            toast.show();
            e.printStackTrace();
        }


    }

    public void pathInfo(String data, String Path) {
        EditText path = (EditText) findViewById(R.id.dbxPath);
        dbxP = new DbxPath(path.getText().toString());
        try {
            dbxF = dbxFs.create(dbxP);
            dbxF.writeString(data);
            dbxF.close();
        } catch (DbxException e) {
            e.printStackTrace();
            Log.e("dbxE","asdf");

        } catch (IOException e) {
            e.printStackTrace();
            Log.e("IO.E", "asdf");

        }catch(DbxPath.InvalidPathException e){
            e.printStackTrace();
            Context context = this.getApplicationContext();
            CharSequence warning = "Invalid Dbx Path!!!";
            int Duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, warning, Duration);
            toast.show();
        }


    }


    public void SUBMIT(View view) {
        EditText pageInfo = (EditText)findViewById(R.id.writingPage);
        EditText path = (EditText)findViewById(R.id.dbxPath);
        pathInfo(pageInfo.getText().toString(), path.getText().toString());
        Log.e("asdf" , "asdf");
        path.setText("");
    }

    public void delete(View view){
        Button del = (Button)findViewById(R.id.delete);
        EditText pageInfo = (EditText)findViewById(R.id.writingPage);
        pageInfo.setText("");

    }

    public void dropBoxLink(View view){
        DAM = DbxAccountManager.getInstance(getApplicationContext(), APP_KEY, APP_SECRET);
        DAM.startLink(this, REQUEST_LINK_TO_DBX);
        afterDbxLink();

    }

    public void searchClick(View view){
        Intent search = new Intent(this,resource.class);
        startActivity(search);
    }

    public void unLink(View view){
        dbxA.unlink();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_link_account_info, menu);
        return true;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_LINK_TO_DBX) {
            if (resultCode == Activity.RESULT_OK) {
                afterDbxLink();
            } else {
                DAM = DbxAccountManager.getInstance(getApplicationContext(), APP_KEY, APP_SECRET);
                DAM.startLink(this, REQUEST_LINK_TO_DBX);

                // ... Link failed or was cancelled by the user.
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

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
