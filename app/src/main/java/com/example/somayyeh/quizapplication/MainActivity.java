package com.example.somayyeh.quizapplication;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    int[] correctIds={R.id.q1a4,R.id.q1a1,R.id.q1a2,R.id.q1a3};
    String[][] QAs=new String[][]{
            {"Question 2: What does TCP breaks data into?","Packets","Binary","Bits","Files"},
            {"Question 3: What language does the computer use and understand?","High-level","Machine","Assembly","None of the above"},
            {"Question 4: What cable connects a cable modem to a wireless router?","Coaxial cable","RJ-11 cable","CAT5 cable","No wire"}

    };

    int flag=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View backgroundimage = findViewById(R.id.background);
        Drawable background = backgroundimage.getBackground();
        background.setAlpha(130);

        LinearLayout first = (LinearLayout) findViewById(R.id.firstQuiz);
        first.setVisibility(View.INVISIBLE);

    }
    public void startQuiz(View v)
    {
        ImageButton start = (ImageButton) findViewById(R.id.start);
        start.setVisibility(v.GONE);

        LinearLayout first = (LinearLayout) findViewById(R.id.firstQuiz);
        first.setVisibility(v.VISIBLE);

        Button next = (Button) findViewById(R.id.Next);
        next.setVisibility(View.INVISIBLE);
    }


    public void showNextQuestion(View v)
    {

            RadioGroup radioAnswerGroup = (RadioGroup)findViewById(R.id.Answers);
            radioAnswerGroup.clearCheck();
            TextView question = (TextView)findViewById(R.id.Question);
            question.setText(QAs[flag][0]);
            RadioButton answer = (RadioButton)findViewById(R.id.q1a1);
            answer.setText(QAs[flag][1]);
            answer = (RadioButton)findViewById(R.id.q1a2);
            answer.setText(QAs[flag][2]);
            answer = (RadioButton)findViewById(R.id.q1a3);
            answer.setText(QAs[flag][3]);
            answer = (RadioButton)findViewById(R.id.q1a4);
            answer.setText(QAs[flag][4]);
            TextView result = (TextView)findViewById(R.id.Result);
            result.setText("");
        flag++;
        Button next = (Button)findViewById(R.id.Next);
        next.setVisibility(v.GONE);


    }
    public void submitAnswer(View v)
    {
        int selectedId = isSelected();
        if(selectedId == -1)
       {
           Toast.makeText(MainActivity.this,
                   "Please answer the question", Toast.LENGTH_SHORT).show();
       }
        else
       {
           TextView result = (TextView)findViewById(R.id.Result);
           if (selectedId==correctIds[flag])
           {
               result.setText("CORRECT");
           }
else  {
               result.setText("INCORRECT");
           }
           if (flag!=3) {

               Button next = (Button) findViewById(R.id.Next);
               next.setVisibility(View.VISIBLE);
           }

       }
    }
    public int isSelected()
    {
        RadioGroup radioAnswerGroup = (RadioGroup)findViewById(R.id.Answers);
        int selectedId = radioAnswerGroup.getCheckedRadioButtonId();
        return selectedId;
    }
}
