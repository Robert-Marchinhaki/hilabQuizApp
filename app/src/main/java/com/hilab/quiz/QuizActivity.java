package com.hilab.quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

    private List<QuestionsList> questionsList;

    private int currentQuestionPosition = 0;

    private String selectedOptionByUser = "";

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
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);

        nextBtn = findViewById(R.id.nextBtn);

        final String getSelectedTopicName = getIntent().getStringExtra("selectedTopic");

        if (getSelectedTopicName.equals("Fácil")) {
            totalTimerInMin += 1;
        }

        topicName.setText(getSelectedTopicName);

        questionsList = QuestionBank.getQuestion(getSelectedTopicName);

        startTimer(timer);

        questions.setText((currentQuestionPosition + 1)+ "/" +questionsList.size());
        question.setText(questionsList.get(0).getQuestion());
        option1.setText(questionsList.get(0).getOption1());
        option2.setText(questionsList.get(0).getOption2());
        option3.setText(questionsList.get(0).getOption3());
        option4.setText(questionsList.get(0).getOption4());


        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (selectedOptionByUser.isEmpty()) {

                    selectedOptionByUser = option1.getText().toString();

                    option1.setBackgroundResource(R.drawable.round_back_red);
                    option1.setTextColor(Color.WHITE);

                    revealAnswer();

                    questionsList.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
                }
            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (selectedOptionByUser.isEmpty()) {

                    selectedOptionByUser = option2.getText().toString();

                    option2.setBackgroundResource(R.drawable.round_back_red);
                    option2.setTextColor(Color.WHITE);

                    revealAnswer();

                    questionsList.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
                }
            }
        });

        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (selectedOptionByUser.isEmpty()) {

                    selectedOptionByUser = option3.getText().toString();

                    option3.setBackgroundResource(R.drawable.round_back_red);
                    option3.setTextColor(Color.WHITE);

                    revealAnswer();

                    questionsList.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
                }
            }
        });

        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (selectedOptionByUser.isEmpty()) {

                    selectedOptionByUser = option4.getText().toString();

                    option4.setBackgroundResource(R.drawable.round_back_red);
                    option4.setTextColor(Color.WHITE);

                    revealAnswer();

                    questionsList.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
                }
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(selectedOptionByUser.isEmpty()) {
                    Toast.makeText(QuizActivity.this, "Por favor, selecione uma opção.", Toast.LENGTH_SHORT).show();

                }
                else {
                    changeNextQuestion();
                }
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

    private void changeNextQuestion() {

        currentQuestionPosition++;

        if((currentQuestionPosition+1) == questionsList.size()) {
            nextBtn.setText("Enviar quiz");
        }

        if((currentQuestionPosition < questionsList.size())) {

            selectedOptionByUser = "";

            option1.setBackgroundResource(R.drawable.round_back_white_stroke2_10);
            option1.setTextColor(Color.parseColor("#024873"));

            option2.setBackgroundResource(R.drawable.round_back_white_stroke2_10);
            option2.setTextColor(Color.parseColor("#024873"));

            option3.setBackgroundResource(R.drawable.round_back_white_stroke2_10);
            option3.setTextColor(Color.parseColor("#024873"));

            option4.setBackgroundResource(R.drawable.round_back_white_stroke2_10);
            option4.setTextColor(Color.parseColor("#024873"));

            questions.setText((currentQuestionPosition + 1)+ "/" +questionsList.size());
            question.setText(questionsList.get(currentQuestionPosition).getQuestion());
            option1.setText(questionsList.get(currentQuestionPosition).getOption1());
            option2.setText(questionsList.get(currentQuestionPosition).getOption2());
            option3.setText(questionsList.get(currentQuestionPosition).getOption3());
            option4.setText(questionsList.get(currentQuestionPosition).getOption4());

        }
        else {

            Intent intent = new Intent(QuizActivity.this, QuizResults.class);
            intent.putExtra("acertos", getCorrectAnswer());
            intent.putExtra("erros", getIncorrectAnswer());
            startActivity(intent);

            finish();
        }
    }
    private void startTimer(TextView timerTextview){
            quizTimer = new Timer();

            quizTimer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    if(seconds == 0 && totalTimerInMin == 0) {
                        quizTimer.purge();
                        quizTimer.cancel();

                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(QuizActivity.this, "Acabou o tempo!", Toast.LENGTH_SHORT).show();
                            }
                        });

                        Intent intent = new Intent(QuizActivity.this, QuizResults.class);
                        intent.putExtra("acertos", getCorrectAnswer());
                        intent.putExtra("erros", getIncorrectAnswer());
                        startActivity(intent);

                        finish();
                    }
                    else if(seconds == 0) {
                        totalTimerInMin--;
                        seconds = 59;
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
                            String concatenatingTimer = finalMinutes+":"+finalSeconds;
                            timerTextview.setText(concatenatingTimer);
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

    private void revealAnswer() {

        final String getAnswer = questionsList.get(currentQuestionPosition).getAnswer();

        if (option1.getText().toString().equals(getAnswer)) {
            option1.setBackgroundResource(R.drawable.round_back_green10);
            option1.setTextColor(Color.WHITE);
        }
        else if (option2.getText().toString().equals(getAnswer)) {
            option2.setBackgroundResource(R.drawable.round_back_green10);
            option2.setTextColor(Color.WHITE);
        }
        else if (option3.getText().toString().equals(getAnswer)) {
            option3.setBackgroundResource(R.drawable.round_back_green10);
            option3.setTextColor(Color.WHITE);
        }
        else if (option4.getText().toString().equals(getAnswer)) {
            option4.setBackgroundResource(R.drawable.round_back_green10);
            option4.setTextColor(Color.WHITE);
        }
    }
}