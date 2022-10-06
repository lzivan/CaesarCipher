package com.example.caesarcipher;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public ShiftDefineActivity shiftDefineActivity;
    private EditText userInput;
    private Button encryptBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userInput = findViewById(R.id.input);
        encryptBtn = (Button) findViewById(R.id.encrypt);
    }

    public void setShift(View view){
        Intent intent = new Intent(this, ShiftDefineActivity.class);
        startActivity(intent);
    }

    public static StringBuffer encrypt(String text, int s)
    {
        StringBuffer result= new StringBuffer();

        for (int i=0; i<text.length(); i++)
        {
            if (Character.isUpperCase(text.charAt(i)))
            {
                char ch = (char)(((int)text.charAt(i) +
                        s - 65) % 26 + 65);
                result.append(ch);
            }
            else
            {
                char ch = (char)(((int)text.charAt(i) +
                        s - 97) % 26 + 97);
                result.append(ch);
            }
        }
        return result;
    }

    public void onClickEncrypt (View view){
        if (shiftDefineActivity.shift_num == 0){
            encryptBtn.setEnabled(false);
            Toast.makeText(this, "Please define shift number first", Toast.LENGTH_SHORT).show();
        } else {
            String getInput = userInput.getText().toString();
            String result = encrypt(getInput, shiftDefineActivity.shift_num).toString();
            TextView output = findViewById(R.id.result);
            output.setText(result);
            InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
            imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
        }
    }
}