package com.example.sam.realmproject;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.app.ListActivity;

import java.util.ArrayList;
import java.util.Map;
import java.util.jar.Attributes;
import java.util.zip.Inflater;

import io.realm.Realm;


public class PeopleList extends ListActivity {
   String Name;
   int Age;
   ArrayList<Map<String, String>> personList;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //final ListView listView = (ListView)findViewById(R.id.listView);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        intent = getIntent();

       personList = (ArrayList<Map< String, String>>)intent.getSerializableExtra("people");


        /*ListAdapter adapter = */ setListAdapter  (new ListAdapter() {

            @Override
            public boolean areAllItemsEnabled() {
                return true;
            }

            @Override
            public boolean isEnabled(int position) {
                return true;
            }

            @Override
            public void registerDataSetObserver(DataSetObserver observer) {

            }

            @Override
            public void unregisterDataSetObserver(DataSetObserver observer) {

            }

            @Override
            public int getCount() {
               return personList.size();
            }

            @Override
            public Object getItem(int position) {
                return personList.get(position);
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public boolean hasStableIds() {
                return false;
            }

            @Override
                public View getView(int position, View convertView, ViewGroup parent){
                View recycle = convertView;
                if (recycle == null) {

                    LayoutInflater Expansion = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    recycle = Expansion.inflate(R.layout.infolayout, parent, false);

                }

              Map<String, String> people = (Map<String, String>)getItem(position);
                ((TextView)recycle.findViewById(R.id.personName)).setText(Name);
                ((TextView)recycle.findViewById(R.id.personAge)).setText(Age);

                return recycle;

            }

            @Override
            public int getItemViewType(int position) {
                return 0;
            }

            @Override
            public int getViewTypeCount() {
                return 1;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }


    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list, menu);
        return true;


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

        return true;

    }
    });}
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        finish();
    }
}
