package com.example.inclassexamples_f20;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button viewButton = findViewById(R.id.button2);
        viewButton.setOnClickListener( click ->
                startActivity(new Intent(MainActivity.this, VideoActivity.class)));
    }
}
