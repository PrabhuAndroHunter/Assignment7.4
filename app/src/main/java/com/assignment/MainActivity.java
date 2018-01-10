package com.assignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final String TAG = MainActivity.class.toString();
    private Button mLoginBtn;
    private EditText mEmailEt, mPasswordEt;
    private String userName, password;

    public static final String USER = "USERNAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // initialise layout
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");
        initViews();
        // Setting actionBar title
        getSupportActionBar().setTitle("Login Screen");
        // add onclick listener to login Button
        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: ");
                // capture username and password
                userName = mEmailEt.getText().toString();
                password = mPasswordEt.getText().toString();

                // check for empty fields
                if (userName.equalsIgnoreCase("")) {
                    mEmailEt.setError("Please Enter Username");
                } else if (password.equalsIgnoreCase("")) {
                    mPasswordEt.setError("Please Enter Password");
                } else {
                    checkCredentiolAndLogin(userName, password);
                }
            }
        });
    }

    // This method will initialise view
    private void initViews() {
        mEmailEt = (EditText) findViewById(R.id.editText);
        mPasswordEt = (EditText) findViewById(R.id.editText2);
        mLoginBtn = (Button) findViewById(R.id.button);
    }

    // Check the credential if valid then move to HomeScreen
    private void checkCredentiolAndLogin(String userName, String password) {
        if (userName.equalsIgnoreCase("prabhu") && password.equalsIgnoreCase("password")) {
            Bundle bundle = new Bundle();
            bundle.putString(USER, userName); // add username to Bundle
            Intent intent = new Intent(this, HomeScreenActivity.class);
            //here passing information from this activity to HomeScreen activity using Bundle
            intent.putExtras(bundle);
            startActivity(intent);  // Start HomeScreen Activity
            finish();   // close this Activity
        }
    }
}
