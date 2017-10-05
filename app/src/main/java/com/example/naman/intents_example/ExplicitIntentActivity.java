package com.example.naman.intents_example;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ExplicitIntentActivity extends AppCompatActivity {

    /**
     * This activity will retrieve the intent that launched it, and extract the string we passed in the intent,
     * and set this text in a TextView box.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit_intent);

        Intent i = getIntent();
        String text = i.getStringExtra("text");


//        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
        TextView textView = (TextView) findViewById(R.id.textBox);
        textView.setText(text);

    }
}
