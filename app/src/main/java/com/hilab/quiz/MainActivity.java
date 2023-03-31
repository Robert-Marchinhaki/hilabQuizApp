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

                selectedTopicName = "Fácil";

                easyMode.setBackgroundResource(R.drawable.round_back_pink_stroke10);

                hardMode.setBackgroundResource(R.drawable.round_back_blue);
            }
        });

        hardMode.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                selectedTopicName = "Difícil";

                hardMode.setBackgroundResource(R.drawable.round_back_pink_stroke10);

                easyMode.setBackgroundResource(R.drawable.round_back_blue);
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

