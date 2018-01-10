package com.assignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HomeScreenActivity extends AppCompatActivity {
    private final String TAG = HomeScreenActivity.class.toString();
    private TextView mUserTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // initialise layout
        setContentView(R.layout.activity_home_screen);
        mUserTv = (TextView) findViewById(R.id.textview_user); // init textview
        //here we are creating the string
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras(); //get user information
        String userName = bundle.getString(MainActivity.USER);
        mUserTv.setText("Welcome "+userName);   // Show user
    }
}
