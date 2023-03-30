package com.hilab.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String selectedTopicName = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final LinearLayout easyMode = findViewById(R.id.easyMode);
        final LinearLayout hardMode = findViewById(R.id.hardMode);

        final Button btnStart = findViewById(R.id.btnStart);


        easyMode.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                selectedTopicName = "easy";

                easyMode.setBackgroundResource(R.drawable.round_back_white_stroke10);

                hardMode.setBackgroundResource(R.drawable.round_back_white10);
            }
        });

        hardMode.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                selectedTopicName = "hard";

                hardMode.setBackgroundResource(R.drawable.round_back_white_stroke10);

                easyMode.setBackgroundResource(R.drawable.round_back_white10);
            }
        });

        btnStart.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                if(selectedTopicName.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Por favor selecione um nível de dificuldade", Toast.LENGTH_SHORT).show();
                }
                else {

                    Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                    intent.putExtra("selectedTopic", selectedTopicName);
                    startActivity(intent);

                }
            }
        });
    }
}

