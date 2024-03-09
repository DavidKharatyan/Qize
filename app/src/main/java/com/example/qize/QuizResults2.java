package com.example.qize;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class QuizResults2 extends AppCompatActivity {
    private TextView questions;
    private TextView question;
    private String selectedTopic = "";
    private AppCompatButton option1, option2, option3, option4;

    private AppCompatButton nextBtn;
    private Timer quizTimer;
    private int seconds = 0;
    private int minute = 1;
    private List<QuestionsList> questionsLists;
    private int cureQuestionPosition = 0;
    private String selectedOptionByUser = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results2);
        final ImageView backBtn = findViewById(R.id.backBtn);
        final TextView timer = findViewById(R.id.timer);
        final TextView selectedtopicName = findViewById(R.id.selectedtopicName);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);
        nextBtn = findViewById(R.id.nextBtn3);
        final String getSelectedTopic = getIntent().getStringExtra("selectedTopic");

        selectedtopicName.setText(getSelectedTopic);
        startTimer(timer);
        //questions.setText((cureQuestionPosition + 1) + "/" + questionsLists.size());
        //question.setText(questionsLists.get(0).getQuestion());
        //  option1.setText(questionsLists.get(0).getOption1());
        //    option2.setText(questionsLists.get(0).getOption2());
        //      option3.setText(questionsLists.get(0).getOption3());
//        option4.setText(questionsLists.get(0).getOption4());
        //  questionsLists = QuestionsBank.getQuestions(getSelectedTopic);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quizTimer.purge();
                quizTimer.cancel();

                startActivity(new Intent(QuizResults2.this, QuizResults3.class));
                finish();
            }
        });
        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedOptionByUser.isEmpty()) {
                    option1.setBackgroundResource(R.drawable.round_back_green10);
                    option2.setBackgroundResource(R.drawable.round_back_wait_10);
                    option3.setBackgroundResource(R.drawable.round_back_wait_10);
                    option4.setBackgroundResource(R.drawable.round_back_wait_10);

                }
            }
        });
        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                option1.setBackgroundResource(R.drawable.round_back_green10);
                option2.setBackgroundResource(R.drawable.round_back_red10);
                option3.setBackgroundResource(R.drawable.round_back_wait_10);
                option4.setBackgroundResource(R.drawable.round_back_wait_10);
            }
        });
        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                option1.setBackgroundResource(R.drawable.round_back_green10);
                option2.setBackgroundResource(R.drawable.round_back_wait_10);
                option3.setBackgroundResource(R.drawable.round_back_red10);
                option4.setBackgroundResource(R.drawable.round_back_wait_10);
            }
        });
        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                option1.setBackgroundResource(R.drawable.round_back_green10);
                option2.setBackgroundResource(R.drawable.round_back_wait_10);
                option3.setBackgroundResource(R.drawable.round_back_wait_10);
                option4.setBackgroundResource(R.drawable.round_back_red10);
            }
        });
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String getSelectedTopic = getIntent().getStringExtra("selectedTopic");
                Intent intent = new Intent(QuizResults2.this, QuizResults3.class);
                intent.putExtra("selectedTopic", selectedTopic);
                startActivity(intent);

            }
        });

    }

    private void startTimer(TextView timetextView) {
        quizTimer = new Timer();
        quizTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (seconds == 0) {
                    minute--;
                    seconds = 59;
                } else if (seconds == 0 && minute == 0) {
                    quizTimer.purge();
                    quizTimer.cancel();

                    Toast.makeText(QuizResults2.this, "время вышло ", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(QuizResults2.this, QuizResults3.class);
                    intent.putExtra("Correct", getCorrectAndwers());
                    intent.putExtra("incorrect", getInCorrectAndwers());

                    startActivity(intent);
                    finish();
                } else {
                    seconds--;
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String finalMinutes = String.valueOf(minute);
                        String finalSeconds = String.valueOf(seconds);

                        if (finalMinutes.length() == 1) {
                            finalMinutes = "0" + finalMinutes;
                        }
                        if (finalSeconds.length() == 1) {
                            finalSeconds = "0" + finalSeconds;
                        }
                        timetextView.setText(finalMinutes + ":" + finalSeconds);
                    }
                });
            }
        }, 1000, 1000);
    }

    private int getCorrectAndwers() {

        int correctAnswers = 0;
        for (int i = 0; i < questionsLists.size(); i++) {
            final String grtUserSelectedAnswer = questionsLists.get(i).getUserSelectedAnswer();
            final String getAnswer = questionsLists.get(i).getAnswer();

            if (grtUserSelectedAnswer.equals(getAnswer)) {
                correctAnswers++;
            }
        }
        return correctAnswers;
    }

    private int getInCorrectAndwers() {

        int correctAnswers = 0;
        for (int i = 0; i < questionsLists.size(); i++) {
            final String grtUserSelectedAnswer = questionsLists.get(i).getUserSelectedAnswer();
            final String getAnswer = questionsLists.get(i).getAnswer();

            if (!grtUserSelectedAnswer.equals(getAnswer)) {
                correctAnswers++;
            }
        }
        return correctAnswers;
    }

    private void revialAnswer() {
        final String getAnswer = questionsLists.get(cureQuestionPosition).getAnswer();
        if (option1.getText().toString().equals(getAnswer)) {
            option1.setBackgroundResource(R.drawable.round_back_green10);
            option1.setTextColor(Color.WHITE);
        } else if (option2.getText().toString().equals(getAnswer)) {
            option2.setBackgroundResource(R.drawable.round_back_green10);
            option2.setTextColor(Color.WHITE);
        } else if (option3.getText().toString().equals(getAnswer)) {
            option3.setBackgroundResource(R.drawable.round_back_green10);
            option3.setTextColor(Color.WHITE);
        } else if (option4.getText().toString().equals(getAnswer)) {
            option4.setBackgroundResource(R.drawable.round_back_green10);
            option4.setTextColor(Color.WHITE);
        }
    }
}