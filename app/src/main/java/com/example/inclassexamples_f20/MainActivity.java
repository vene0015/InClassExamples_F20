package com.example.inclassexamples_f20;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override   //like main function
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);  //loads stuff to the screen
//screen is blank
        final TextView myTextView = findViewById(R.id.topText);

        EditText theEdit = findViewById(R.id.editText);
       String userTyped = theEdit.getText().toString();

        Switch rb = findViewById(R.id.cbox);
        ImageButton btn = findViewById(R.id.btn);
        btn.setOnClickListener( (v) -> rb.setChecked(false)  );

        rb.setOnCheckedChangeListener( (whatClicked, newState) -> {
           // Toast.makeText(MainActivity.this, "Your button is:" + newState, Toast.LENGTH_LONG).show();
            Snackbar.make(myTextView, "Your button is:" + newState, Snackbar.LENGTH_SHORT)
                    .setAction("Hello class", (v) -> whatClicked.setChecked(false))
                    .show();
        });
    }
}