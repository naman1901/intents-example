package com.example.naman.intents_example;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ExplicitIntentResultActivity extends AppCompatActivity {


    Button res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit_intent_result);

        res = (Button) findViewById(R.id.res_button);
        res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                EditText editText = (EditText) findViewById(R.id.res_text);
                String newName = editText.getText().toString();
                i.putExtra("newName", newName);
                setResult(RESULT_OK, i);
                finish();
            }
        });

    }
}
