package com.tinu.android.assignment2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listImages;
    private CustomListAdapter adapter;
    SharedPreferences sharedPrefs;
    SharedPreferences.Editor sharedEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Set the title of the main screen
        this.setTitle(getResources().getString(R.string.main_screen));
        sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        sharedEditor = sharedPrefs.edit();

        //Create list items
        List<ListItems>listItems = new ArrayList<ListItems>();
        listItems.add(new ListItems(R.drawable.pic1, "You Tube", "05.01.2016,08:00 AM", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis sapien enim, luctus quis ipsum eget, tempor rutrum nulla."));
        listItems.add(new ListItems(R.drawable.pic2, "Twitter", "06.02.2016,07:00 PM", "Sed at ex vitae nisi congue vulputate sed vitae nisl. Curabitur ipsum quam, scelerisque in bibendum sit amet."));
        listItems.add(new ListItems(R.drawable.pic3, "Facebook", "07.01.2016,01:00 AM", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis sapien enim, luctus quis ipsum eget, tempor rutrum nulla."));
        listItems.add(new ListItems(R.drawable.pic4, "Google+", "08.02.2016,07:00 pM", "Aenean mauris arcu, ornare eu venenatis quis, fringilla vel ligula. Morbi pharetra est nec vestibulum eleifend. Fusce at arcu non nibh cursus molestie. Integer dictum, ex non mattis auctor."));
        listItems.add(new ListItems(R.drawable.pic5, "Skype", "09.03.2016,08:00 AM", "Vivamus et feugiat magna. Nulla quis dui porta, elementum dolor sed, rutrum sapien. Duis blandit magna vel lacus dapibus scelerisque."));
        listItems.add(new ListItems(R.drawable.pic6, "Andoid", "10.02.2016,09:00 PM", "In sed augue sed arcu dapibus rhoncus a non purus. Ut magna ex, pharetra eget ligula vel, consequat tempus nulla. Mauris scelerisque lectus sed sapien commodo."));
        listItems.add(new ListItems(R.drawable.pic7, "Linkedin", "11.03.2016,03:00 AM", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis sapien enim, luctus quis ipsum eget, tempor rutrum nulla."));
        listItems.add(new ListItems(R.drawable.pic8, "Contact", "12.02.2016,04:00 PM", "Phasellus faucibus turpis vel augue blandit porta. Mauris ultricies, sapien ac efficitur efficitur, sem erat porttitor magna."));

        //The adapter will take the data and populate the list view.
        adapter = new CustomListAdapter(this, listItems);

        // Get a reference to the ListView, and attach this adapter to it.
        listImages = (ListView) findViewById(R.id.listView);
        listImages.setAdapter(adapter);
        listImages.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ListItems item = (ListItems) adapter.getItem(position);
                String current_date = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());

                sharedEditor.putString(Constants.TITLE,item.getTitle());
                sharedEditor.putString(Constants.CURRENT_DATE,current_date);
                sharedEditor.commit();

                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                intent.putExtra(Constants.IMAGE, ""+item.getImage());
                intent.putExtra(Constants.TITLE, item.getTitle());
                intent.putExtra(Constants.DATE_AND_TIME, item.getDate_and_time());
                intent.putExtra(Constants.DESCRIPTION, item.getDescription());
                startActivity(intent);
            }
        });

    }
}