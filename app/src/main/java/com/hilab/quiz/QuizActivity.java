package com.hilab.quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class QuizActivity extends AppCompatActivity {

    private TextView questions;
    private TextView question;

    private AppCompatButton option1, option2, option3, option4;

    private AppCompatButton nextBtn;

    private Timer quizTimer;

    private int totalTimerInMin = 1;
    private int seconds = 0;

    private final List<QuestionsList> questionsList = ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        final ImageView backBtn = findViewById(R.id.backBtn);
        final TextView timer = findViewById(R.id.timer);
        final TextView topicName = findViewById(R.id.topicName);

        questions = findViewById(R.id.qtyQuestion);
        question = findViewById(R.id.showQuestions);

        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option1);
        option3 = findViewById(R.id.option1);
        option4 = findViewById(R.id.option1);

        nextBtn = findViewById(R.id.nextBtn);

        final String getSelectedTopicName = getIntent().getStringExtra("selectedTopic");

        topicName.setText(getSelectedTopicName);

        startTimer(timer);

        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                quizTimer.purge();
                quizTimer.cancel();

                startActivity(new Intent(QuizActivity.this, MainActivity.class));
                finish();
            }
        });
    }

    private void startTimer(TextView timerTextview){
            quizTimer = new Timer();

            quizTimer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {

                    if(seconds == 0) {
                        totalTimerInMin++;
                        seconds = 59;
                    }
                    else if(seconds == 0 && totalTimerInMin == 0) {
                        quizTimer.purge();
                        quizTimer.cancel();

                        Toast.makeText(QuizActivity.this, "Acabou o tempo", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(QuizActivity.this, QuizResults.class);
                        intent.putExtra("acertos", getCorrectAnswer());
                        intent.putExtra("erros", getIncorrectAnswer());
                        startActivity(intent);

                        finish();
                    }
                    else {
                        seconds--;
                    }

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {


                            String finalMinutes = String.valueOf(totalTimerInMin);
                            String finalSeconds = String.valueOf(seconds);

                            if(finalMinutes.length() == 1) {
                                finalMinutes = "0" + finalMinutes;
                            }

                            if(finalSeconds.length() == 1) {
                                finalSeconds = "0" + finalSeconds;
                            }

                            timerTextview.setText(finalMinutes+":"+finalSeconds);
                        }
                    });
                }
            }, 1000, 1000);
    }

    private int getCorrectAnswer() {

        int correctAnswer = 0;

        for(int i=0;i < questionsList.size();i++){

            final String getUserSelectedAnswer = questionsList.get(i).getUserSelectedAnswer();
            final String getAnswer = questionsList.get(i).getAnswer();

            if(getUserSelectedAnswer.equals(getAnswer)) {
                correctAnswer++;
            }

        }

        return correctAnswer;
    }

    private int getIncorrectAnswer() {

        int correctAnswer = 0;

        for(int i=0;i < questionsList.size();i++){

            final String getUserSelectedAnswer = questionsList.get(i).getUserSelectedAnswer();
            final String getAnswer = questionsList.get(i).getAnswer();

            if(!getUserSelectedAnswer.equals(getAnswer)) {
                correctAnswer++;
            }

        }

        return correctAnswer;
    }

    @Override
    public void onBackPressed() {
        quizTimer.purge();
        quizTimer.cancel();

        startActivity(new Intent(QuizActivity.this, MainActivity.class));
        finish();
    }
}