package com.tinu.android.assignment2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textTitle;
    private TextView textDate;
    private TextView textDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        String title = "";
        String dateAndTime = "";
        String description = "";
        String image = "";

        Intent intent = this.getIntent();
        if (null != intent) {
            //Get the data from the intent.
            image = intent.getStringExtra(Constants.IMAGE);
            title = intent.getStringExtra(Constants.TITLE);
            dateAndTime = intent.getStringExtra(Constants.DATE_AND_TIME);
            description = intent.getStringExtra(Constants.DESCRIPTION);
        }

        imageView = (ImageView) findViewById(R.id.image);
        textTitle = (TextView) findViewById(R.id.text_title);
        textDate = (TextView) findViewById(R.id.text_date);
        textDescription = (TextView) findViewById(R.id.text_description);

        //Set the values for the detail screen.

        textTitle.setText(title);
        textDate.setText(dateAndTime);
        textDescription.setText(description);
        imageView.setImageResource(Integer.parseInt(image));


    }
}
