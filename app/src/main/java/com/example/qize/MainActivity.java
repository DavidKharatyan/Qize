package com.example.qize;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

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
        Armenia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedTopic = "Armenia";
                Armenia.setBackgroundResource(R.drawable.round_back_write_strouk10);
            }
        });
        America.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            America.setBackgroundResource(R.drawable.round_back_write_strouk10);
        }
        });
        Russian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Russian.setBackgroundResource(R.drawable.round_back_write_strouk10);

            }
        });
        Ukraine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Ukraine.setBackgroundResource(R.drawable.round_back_write_strouk10);
            }
        });

    }
}