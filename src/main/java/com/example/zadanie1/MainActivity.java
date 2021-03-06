package com.example.zadanie1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button truebutton;
    private Button falsebutton;
    private Button nextbutton;
    private Button hint;
    private TextView questionTextView;
    private static final String QUIZ_TAG = "Main activity";
    private static final String KEY_CURRENT_INDEX = "currentindex";
    public static final String KEY_EXTRA_ANSWER = "pl.edu.pb.wi.quiz.correctanswer";
    private static final int REQUEST_CODE_PROMPT = 0;
    private boolean answerWasShown = false;

    private Question[] questions = new Question[]
            {
                    new Question(R.string.Prostokat, false),
                    new Question(R.string.okrag, true),
                    new Question(R.string.trojkat,false),
                    new Question(R.string.promien, false),
                    new Question(R.string.srednica, true)
            };
    private int currentindex = 0;

    private void checkanswer(Boolean userAnswer)
    {
        boolean correctanswer = questions[currentindex].isTrueAnswer();
        int resultmessageId = 0;
        if(answerWasShown)
        {
            resultmessageId = R.string.answerwasshown;
        }
        else {
            if (userAnswer == correctanswer) {
                resultmessageId = R.string.correct_answer;
            } else {
                resultmessageId = R.string.incorrect_answer;
            }
        }
       Toast.makeText (this,  resultmessageId, Toast.LENGTH_SHORT).show();
    }

    private void setnextquestion()
    {
        questionTextView.setText(questions[currentindex].getQuestionId());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(QUIZ_TAG,"wywo??ana zosta??a metoda cyklu ??ycia onCreate");
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null)
        {
            currentindex = savedInstanceState.getInt(KEY_CURRENT_INDEX);
        }

        truebutton = findViewById(R.id.button_true); //znajduje guzik prawdy
        falsebutton = findViewById(R.id.button_false); // znajduje guzik fa??sz
        nextbutton = findViewById(R.id.button_next); // znajduje guzik nast??pny
        hint = findViewById(R.id.showhint);//znajduje guzik podpowiedzi w main activity

        questionTextView = findViewById(R.id.question_text_view);

        truebutton.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v) {
                    checkanswer( true );
                }
            });//nas??uchiwacz prawdy

        falsebutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                checkanswer( false );
            }
        });//nas??uchiwacz fa??szu

        nextbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentindex = (currentindex+1)%questions.length;
                answerWasShown = false;
                setnextquestion();
            }
        });
        hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this,PromptActivity.class);
            boolean correctAnswer = questions[currentindex].isTrueAnswer();
            intent.putExtra(KEY_EXTRA_ANSWER,correctAnswer);
                //noinspection deprecation
                startActivityForResult(intent, REQUEST_CODE_PROMPT);
            }
        });
        {

        }
        setnextquestion();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode!=RESULT_OK)
        {
            return;
        }
        if(requestCode == REQUEST_CODE_PROMPT)
        {
            if(data == null)
            {
                return;
            }
        answerWasShown = data.getBooleanExtra(PromptActivity.KEY_EXTRA_ANSWER_SHOWN,false);
        }
    }

    @Override
    protected  void onStart()
    {
        super.onStart();
        Log.d(QUIZ_TAG,"wywo??ana zosta??a metoda cyklu ??ycia onStart");
    }
    @Override
    protected  void onPause()
    {
        super.onPause();
        Log.d(QUIZ_TAG,"wywo??ana zosta??a metoda cyklu ??ycia onPause");
    }
    @Override
    protected void onResume()
    {
        super.onResume();
        Log.d(QUIZ_TAG,"wywo??ana zosta??a metoda cyklu ??ycia onResume");
    }
    @Override
    protected void onStop()
    {
        super.onStop();
        Log.d(QUIZ_TAG,"wywo??ana zosta??a metoda cyklu ??ycia onStop");
    }
    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Log.d(QUIZ_TAG,"wywo??ana zosta??a metoda cyklu ??ycia onDestroy");
    }
    @Override
    protected void  onSaveInstanceState(Bundle outstate)
    {
        super.onSaveInstanceState(outstate);
        Log.d(QUIZ_TAG, "wywo????na zosta??a metoda cyklu ??ycia onSaveInstantState");
        outstate.putInt(KEY_CURRENT_INDEX, currentindex);
    }

}