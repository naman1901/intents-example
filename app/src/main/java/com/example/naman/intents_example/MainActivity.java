package com.example.naman.intents_example;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /**
     * This app is an example of how intents work in Android.
     * There are 2 kinds of intents - Explicit (where you mention the activity you want to launch)
     *                                Implicit (where you leave the choice of activity to the user and the Android system)
     * Intents can be used to launch activity only, or to launch new activity and get some result from it.
     */

    static final int RENAME_REQUEST = 1;

    Button expl, explRes, impl;
    EditText textBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AddButtonListeners();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        /**
         * Receive the result from ExplicitIntentResultActivity
         * Set the received string to this Activity's EditText box
         */
        if(requestCode==RENAME_REQUEST) {
            if(resultCode==RESULT_OK) {
                String newName = data.getStringExtra("newName");
                textBox.setText(newName);
            }
        }
    }

    /**
     * This function adds listeners to the buttons that fire intents on being clicked.
     */
    private void AddButtonListeners() {

        textBox = (EditText) findViewById(R.id.text);

        /**
         * Explicit intent where we don't return any result.
         * This example takes the text entered in the EditText box and passes it to the next activity
         */
        expl = (Button) findViewById(R.id.exp_intent);
        expl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ExplicitIntentActivity.class);
                String text = textBox.getText().toString();
//                Toast.makeText(MainActivity.this, text + "Main", Toast.LENGTH_SHORT).show();
                i.putExtra("text", text);
                startActivity(i);
            }
        });

        /**
         * Explicit intent where we return a result.
         * This part of the code launches the new activity.
         * RENAME_REQUEST is a constant defined by us.
         */
        explRes = (Button) findViewById(R.id.exp_intent_res);
        explRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ExplicitIntentResultActivity.class);
                startActivityForResult(i, RENAME_REQUEST);
            }
        });

        /**
         * Implicit intent where we try to dial a number
         * This part fetches the number string input in the EditText box, parses it into a URI object,
         * and sends the intent to the android system which will handle the rest.
         */
        impl = (Button) findViewById(R.id.imp_intent);
        impl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = textBox.getText().toString();
                String phno = "tel:" + text.trim();
                Intent i = new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse(phno));
                startActivity(i);
            }
        });

    }



}
