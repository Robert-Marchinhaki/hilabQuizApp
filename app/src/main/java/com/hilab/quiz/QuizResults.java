package com.hilab.quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class QuizResults extends AppCompatActivity {

    int qtyEasyGamesCompleted = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_results);

        final AppCompatButton btnStartNewGame = findViewById(R.id.btnStartNewGame);
        final TextView correctAnswers = findViewById(R.id.correctAnswers);
        final TextView incorrectAnswers = findViewById(R.id.incorrectAnswers);

        final int getCorrectAnswers = getIntent().getIntExtra("acertos", 0);
        final int getIncorrectAnswers = getIntent().getIntExtra("erros", 0);

        final String correctAnswersMessage = "Respostas corretas: " + getCorrectAnswers;
        final String incorrectAnswersMessage = "Respostas incorretas: " + getIncorrectAnswers;

        correctAnswers.setText(String.valueOf(correctAnswersMessage));
        incorrectAnswers.setText(String.valueOf(incorrectAnswersMessage));

        btnStartNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(QuizResults.this, MainActivity.class));
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(QuizResults.this, MainActivity.class));
        finish();
    }
}