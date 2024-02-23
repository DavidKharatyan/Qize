package com.example.qize;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class QuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
         final ImageView backBtn = findViewById(R.id.backBtn);
         final TextView timer = findViewById(R.id.timer);
         final TextView selectedtopicName = findViewById(R.id.selectedtopicName);
        final String getSelectedTopic = getIntent().getStringExtra("selectedTopic");
        selectedtopicName.setText(getSelectedTopic);
    }
}