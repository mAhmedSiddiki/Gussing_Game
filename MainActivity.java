package com.example.gussinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText text;
    private Button button;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.edit_text);
        button = findViewById(R.id.ok_button);
        result = findViewById(R.id.result);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String num = text.getText().toString();

        if(num.isEmpty()){
            error_message("Please enter a valid number");
        }else {
            int number = new Integer(text.getText().toString());
            if(number<1 || number>10){
                error_message("Please enter a number <1-10>");
                text.setText("");
            }else{
                Random random = new Random();
                int random_number = random.nextInt(10)+1;
                if(number == random_number){
                    result.setText("You On This Match ❤ [ random number is: "+random_number+" ]");
                }else{
                    result.setText("You Are Lose ❤ [ random number is: "+random_number+" ]");
                }
            }
        }
    }
    void error_message(String v){
        text.setError(v);
        text.requestFocus();
        return;
    }
}
