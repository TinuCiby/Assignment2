package com.tinu.android.assignment2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OverviewActivity extends AppCompatActivity {

    private SharedPreferences sharedPrefs;
    private SharedPreferences.Editor sharedEditor;
    private String title_string;
    private String date_string;
    private TextView text_Title;
    private TextView textDate;
    private Button chose_items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);
        //Set the title of the overview screen
        this.setTitle(getResources().getString(R.string.overview_screen));

        sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        sharedEditor = sharedPrefs.edit();
        title_string = sharedPrefs.getString(Constants.TITLE, "No item is selected");
        date_string = sharedPrefs.getString(Constants.CURRENT_DATE, "");

        text_Title = (TextView) findViewById(R.id.text_title);
        textDate = (TextView) findViewById(R.id.text_date);

        chose_items = (Button) findViewById(R.id.chosebtn);
        chose_items.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent mainScreen = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(mainScreen);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        text_Title.setText(title_string);
        textDate.setText(date_string);
    }
    @Override
    public void onRestart()
    {
        super.onRestart();
        finish();
        startActivity(getIntent());
    }
}
