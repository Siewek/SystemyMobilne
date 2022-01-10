package com.example.zadanie1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PromptActivity extends AppCompatActivity {

    private TextView usuretextview;
    private Button hintbutton;
    private TextView answerTV;
    private Boolean correctanswer;
    public static final String KEY_EXTRA_ANSWER_SHOWN = "answerShown";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prompt);

        usuretextview = findViewById(R.id.usuretextview);
        hintbutton = findViewById(R.id.hint_button);
        answerTV = findViewById(R.id.answer_text_view);

        correctanswer = getIntent().getBooleanExtra(MainActivity.KEY_EXTRA_ANSWER, true);

        hintbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int answer = correctanswer ? R.string.button_true : R.string.button_false;
                answerTV.setText(answer);
                setAnswerShownResult(true);
            }
        });
    }
        private void setAnswerShownResult(boolean answerWasShown)
        {
        Intent resultIntent = new Intent();
        resultIntent.putExtra(KEY_EXTRA_ANSWER_SHOWN,answerWasShown);
        setResult(RESULT_OK,resultIntent);

        }

}