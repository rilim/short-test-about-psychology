package com.example.android.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Finds first question's radio group
        RadioGroup q1 = (RadioGroup) findViewById(R.id.question1);
        q1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            //checks which answer was checked, and if it was right answer, adds +1 point to final score
            public void onCheckedChanged(RadioGroup q1, int checkedId) {
                switch (checkedId) {
                    case R.id.question1A:
                        break;
                    case R.id.question1B:
                        break;
                    case R.id.question1C:
                        score += 1;
                        break;
                    case R.id.question1D:
                        break;
                }
            }
        });

        //Finds second question's radio group
        RadioGroup q2 = (RadioGroup) findViewById(R.id.question2);
        q2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            //checks which answer was checked, and if it was right answer, adds +1 point to final score
            public void onCheckedChanged(RadioGroup q2, int checkedId) {
                switch (checkedId) {
                    case R.id.question2A:
                        break;
                    case R.id.question2B:
                        score += 1;
                        break;
                }
            }
        });

        //Finds third question's radio group
        RadioGroup q3 = (RadioGroup) findViewById(R.id.question3);
        q3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            //checks which answer was checked, and if it was right answer, adds +1 point to final score
            public void onCheckedChanged(RadioGroup q3, int checkedId) {
                switch (checkedId) {
                    case R.id.question3A:
                        score += 1;
                        break;
                    case R.id.question3B:
                        break;
                }
            }
        });

    }


    public void submit(View v) {

        // Finds what number was written, as an answer to question 4, in EditText view
        EditText numberOfLevels = (EditText) findViewById(R.id.question4);
        String number = numberOfLevels.getText().toString();
        // int numbers = Integer.parseInt(number);
        // if (numbers == 3) {
        //Checks if it was the right answer
        if (number.equals("3")) {
            score += 1;
        }

        // Finds fifth question's answers
        CheckBox answer1 = (CheckBox) findViewById(R.id.question5_checkbox1);
        boolean isAnswer1Checked = answer1.isChecked();
        CheckBox answer2 = (CheckBox) findViewById(R.id.question5_checkbox2);
        boolean isAnswer2Checked = answer2.isChecked();
        CheckBox answer3 = (CheckBox) findViewById(R.id.question5_checkbox3);
        boolean isAnswer3Checked = answer3.isChecked();
        CheckBox answer4 = (CheckBox) findViewById(R.id.question5_checkbox4);
        boolean isAnswer4Checked = answer4.isChecked();

        //Checks if the right answers are checked and the wrong answer not checked, if so then adds +1 point to final score
        if (isAnswer1Checked && !isAnswer2Checked && isAnswer3Checked && isAnswer4Checked) {
            score += 1;
        }

        //Finds button and disables it
        Button btn = (Button) findViewById(R.id.button_submit);
        btn.setEnabled(false);

        //Opens answers activity
        Intent answers = new Intent(MainActivity.this, Answers.class);
        startActivity(answers);

        //Shows toast message
        if (score == 5 || score == 4 ){
           Toast.makeText(this, getString(R.string.toast) + " " + score, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, getString(R.string.score_text) + " " + score, Toast.LENGTH_SHORT).show();
        }

    }

}
