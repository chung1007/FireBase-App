package com.example.sam.mombirthday;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void presentClick(View view){
        ImageView present = (ImageView)findViewById(R.id.imageView);
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("http://media.daum.net/"));
        startActivity(intent);
    }

    public void buttonClicked(View view) {
            Intent intent = new Intent().setClass(this, supprise.class);
            startActivity(intent);
            Log.e("asdf", "asdf");
        }

    public void letter(View arg0){
        TextView letter = (TextView)findViewById(R.id.letterClick);
        letter.setText("Dear: Mom," +
                " thank you so much for your hard work over the past years to support us and provide for us." +
                " Without you i won't be able to go to robotics, school, and do the things i love. You are very" +
                "valuable to me and sometimes i might take you for granted but i appreciate everything you do" +
                "for me." +
                " Thank you and Happy Birthday!");
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
