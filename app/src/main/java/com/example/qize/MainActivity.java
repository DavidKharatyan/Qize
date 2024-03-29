package com.example.qize;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String selectedTopic = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final LinearLayout Armenia = findViewById(R.id.armeniaLayout);
        final LinearLayout America = findViewById(R.id.americaLeyout);
        final LinearLayout Russian = findViewById(R.id.russiaLayout);
        final LinearLayout Ukraine = findViewById(R.id.ukraineLayout);
        final Button stsrtQuizBTN = findViewById(R.id.stsrtQuizBTN);
        Armenia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedTopic = "Armenia";
                Armenia.setBackgroundResource(R.drawable.round_back_write_strouk10);
                America.setBackgroundResource(R.drawable.round_back_wait_10);
                Russian.setBackgroundResource(R.drawable.round_back_wait_10);
                Ukraine.setBackgroundResource(R.drawable.round_back_wait_10);
            }
        });
        America.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedTopic = "America";
                Armenia.setBackgroundResource(R.drawable.round_back_wait_10);
                America.setBackgroundResource(R.drawable.round_back_write_strouk10);
                Russian.setBackgroundResource(R.drawable.round_back_wait_10);
                Ukraine.setBackgroundResource(R.drawable.round_back_wait_10);
            }
        });
        Russian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedTopic = "Russian";
                Armenia.setBackgroundResource(R.drawable.round_back_wait_10);
                America.setBackgroundResource(R.drawable.round_back_wait_10);
                Russian.setBackgroundResource(R.drawable.round_back_write_strouk10);
                Ukraine.setBackgroundResource(R.drawable.round_back_wait_10);
            }
        });
        Ukraine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedTopic = "Ukraine";
                Armenia.setBackgroundResource(R.drawable.round_back_wait_10);
                America.setBackgroundResource(R.drawable.round_back_wait_10);
                Russian.setBackgroundResource(R.drawable.round_back_wait_10);
                Ukraine.setBackgroundResource(R.drawable.round_back_write_strouk10);
            }
        });
        stsrtQuizBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (selectedTopic.isEmpty()) {
                    Toast.makeText(MainActivity.this, "выберите тему викторины ", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                    intent.putExtra("selectedTopic", selectedTopic);
                    startActivity(intent);
                }

            }
        });
    }

}