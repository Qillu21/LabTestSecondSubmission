package com.example.mindsharpener;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mindsharpener.R;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView number1, number2, operation, pointNumber;
    Button button;
    EditText enterResult;

    int difficulty = 0;
    int point = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1 = (TextView) findViewById(R.id.firstNumber);
        number2 = (TextView) findViewById(R.id.secondNumber);
        operation = (TextView) findViewById(R.id.operation);
        pointNumber = (TextView) findViewById(R.id.pointNumber);
        button = findViewById(R.id.button);
        enterResult = (EditText) findViewById(R.id.enterResult);

        clickEasy(null);
    }

    public void clickEasy(View view){
        difficulty = 1;

        Toast.makeText(this, "Easy Mode", Toast.LENGTH_SHORT).show();

        Random random = new Random();
        int randomNumber = random.nextInt(9);
        int randomNumber2 = random.nextInt(9);

        number1.setText(String.valueOf(randomNumber));
        number2.setText(String.valueOf(randomNumber2));

        int randomOp = random.nextInt(4);

        if(randomOp == 0){
            operation.setText("+");
        }else if(randomOp == 1){
            operation.setText("-");
        }else if(randomOp == 2){
            operation.setText("*");
        }else if(randomOp == 3){
            operation.setText("/");
        }
    }
    public void clickMedium(View view){
        difficulty = 2;

        Toast.makeText(this, "Medium Mode", Toast.LENGTH_SHORT).show();

        Random random = new Random();
        int randomNumber = random.nextInt(99);
        int randomNumber2 = random.nextInt(99);

        number1.setText(String.valueOf(randomNumber));
        number2.setText(String.valueOf(randomNumber2));

        int randomOp = random.nextInt(4);

        if(randomOp == 0){
            operation.setText("+");
        }else if(randomOp == 1){
            operation.setText("-");
        }else if(randomOp == 2){
            operation.setText("*");
        }else if(randomOp == 3){
            operation.setText("/");
        }
    }
    public void clickHard(View view){
        difficulty = 3;

        Toast.makeText(this, "Hard Mode", Toast.LENGTH_SHORT).show();

        Random random = new Random();
        int randomNumber = random.nextInt(999);
        int randomNumber2 = random.nextInt(999);

        number1.setText(String.valueOf(randomNumber));
        number2.setText(String.valueOf(randomNumber2));

        int randomOp = random.nextInt(4);

        if(randomOp == 0){
            operation.setText("+");
        }else if(randomOp == 1){
            operation.setText("-");
        }else if(randomOp == 2){
            operation.setText("*");
        }else if(randomOp == 3){
            operation.setText("/");
        }
    }
    public void clickButt(View view){
        int num1 = Integer.parseInt(number1.getText().toString());
        int num2 = Integer.parseInt(number2.getText().toString());
        int result;

        if(operation.getText().toString() == "+"){
            result = num1 + num2;
        } else if(operation.getText().toString() == "-"){
            result = num1 - num2;
        } else if(operation.getText().toString() == "*"){
            result = num1 * num2;
        } else{
            result = num1 / num2;
        }

        if(Integer.parseInt(enterResult.getText().toString()) == result){
            Toast.makeText(this, "Correct Answer", Toast.LENGTH_SHORT).show();

            point = point + 1;
        } else{
            Toast.makeText(this, "Wrong Answer", Toast.LENGTH_SHORT).show();

            point = point - 1;
        }

        pointNumber.setText("POINT: " + point);

        if(difficulty == 1){
            clickEasy(null);
        } else if(difficulty == 2){
            clickMedium(null);
        } else if (difficulty == 3){
            clickHard(null);
        }

        enterResult.setText("");
    }
}