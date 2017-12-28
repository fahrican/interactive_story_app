package com.example.android.interactive_story_app.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.interactive_story_app.R;
import com.example.android.interactive_story_app.model.Page;
import com.example.android.interactive_story_app.model.Story;

public class StoryActivity extends AppCompatActivity {

    public static final String LOG_TAG = StoryActivity.class.getSimpleName();

    private String personName;
    private Story story;
    private ImageView storyImageView;
    private TextView storyTextView;
    private Button choice1Button;
    private Button choice2Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        storyImageView = (ImageView) findViewById(R.id.storyImageView);
        storyTextView = (TextView)findViewById(R.id.storyTextView);
        choice1Button = (Button)findViewById(R.id.choice1Button);
        choice2Button = (Button)findViewById(R.id.choice2Button);

        Intent intent = getIntent();
        personName = intent.getStringExtra(getString(R.string.key_name));
        if (personName == null || personName.isEmpty()) {
            personName = "friend";
        }
        Log.d(LOG_TAG, personName);

        story = new Story();
        loadPage(0);
    }

    private void loadPage(int pageNumber) {

        Page page = story.getPage(pageNumber);
        Log.d(LOG_TAG, "Until here it worked1");
        Drawable image = ContextCompat.getDrawable(this, page.getImageId());
        Log.d(LOG_TAG, "Until here it worked2");
        storyImageView.setImageDrawable(image);

        String pageText = getString(page.getTextId());
        //add a name if text is included, otherwise nothing will be included
        pageText = String.format(pageText, personName);

        storyTextView.setText(pageText);
        choice1Button.setText(page.getChoice1().getTextId());
        choice2Button.setText(page.getChoice2().getTextId());
    }
}
