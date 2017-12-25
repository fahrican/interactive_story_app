package com.example.android.interactive_story_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class StoryActivity extends AppCompatActivity {

    public static final String LOG_TAG = StoryActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        Intent intent = getIntent();
        String personName = intent.getStringExtra(getString(R.string.key_name));
        if (personName == null || personName.isEmpty()) {
            personName = "friend";
        }
        Log.d(LOG_TAG, personName);
    }
}
