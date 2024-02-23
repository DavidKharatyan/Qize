package com.example.qize;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class QuizActivity extends AppCompatActivity {
    private TextView questions;
    private TextView question;
    private AppCompatButton option1, option2, option3, option4;

    private AppCompatButton nextBtn;
    private Timer quizTimer;
    private int seconds = 0;
    private int minute = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        final ImageView backBtn = findViewById(R.id.backBtn);
        final TextView timer = findViewById(R.id.timer);
        final TextView selectedtopicName = findViewById(R.id.selectedtopicName);
        question = findViewById(R.id.question);
        questions = findViewById(R.id.questions);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);
        nextBtn = findViewById(R.id.nextBtn);
        final String getSelectedTopic = getIntent().getStringExtra("selectedTopic");

        selectedtopicName.setText(getSelectedTopic);
    }

    private void startTimer(TextView textView {
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

                    Toast.makeText(QuizActivity.this, "время вышло ", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent();
                }
            }
        }, 1000, 1000);
    }
}