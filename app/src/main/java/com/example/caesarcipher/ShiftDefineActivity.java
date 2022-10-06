package com.example.caesarcipher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ShiftDefineActivity extends AppCompatActivity {
    public static int shift_num = 0;
    private EditText userInput;
    private Button submitBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shift_define);

        userInput = findViewById(R.id.shiftInput);
        submitBtn = findViewById(R.id.button);
    }

    public void setSubmit(View view){
        String input = userInput.getText().toString();
        shift_num = Integer.valueOf(input);
        if (shift_num < 1 || shift_num > 25){
            Toast.makeText(this, "Please enter a number between 1 and 25", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
}