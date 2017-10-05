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
        if(requestCode==RENAME_REQUEST) {
            if(resultCode==RESULT_OK) {
                String newName = data.getStringExtra("newName");
                textBox.setText(newName);
            }
        }
    }

    private void AddButtonListeners() {

        textBox = (EditText) findViewById(R.id.text);

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

        explRes = (Button) findViewById(R.id.exp_intent_res);
        explRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ExplicitIntentResultActivity.class);
                startActivityForResult(i, RENAME_REQUEST);
            }
        });

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
