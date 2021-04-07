package com.example.esguerra_activity_finalmidtermgrades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FinalGradeActivity extends AppCompatActivity {
    public EditText quiz1,quiz2,quiz3,seatwork1,seatwork2,assignment1,assignment2,midterm,res;
    public Button btnCompute;
    public double sixty,forty,mtGrade;

    float ave_sw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        quiz1 = findViewById(R.id.q1);
        quiz2 = findViewById(R.id.q2);
        quiz3 = findViewById(R.id.q3);
        seatwork1 = findViewById(R.id.sw1);
        seatwork2 = findViewById(R.id.sw2);
        assignment1 = findViewById(R.id.as1);
        assignment2 = findViewById(R.id.as2);
        midterm = findViewById(R.id.mt);
        res = findViewById(R.id.txt_res);

        btnCompute = findViewById(R.id.btn_compute);

        btnCompute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(res==null)
                {
                    res.setText("");
                }
                else
                {
                    float quiz11 = new Float(quiz1.getText().toString());
                    float quiz21 = new Float(quiz2.getText().toString());
                    float quiz31 = new Float(quiz3.getText().toString());
                    float seatwork11 = new Float(seatwork1.getText().toString());
                    float seatwork21 = new Float(seatwork2.getText().toString());
                    float ass11 = new Float(assignment1.getText().toString());
                    float ass21 = new Float(assignment2.getText().toString());
                    float examScore = new Float(midterm.getText().toString());

                    ave_sw = ((seatwork11+seatwork21)/2);

                    sixty = (((quiz11+quiz21+quiz31+ave_sw+ass11+ass21)/6)*0.6);
                    forty = (examScore*0.4);

                    mtGrade = (sixty+forty);

                    res.setText(Double.toString(mtGrade));

                }



            }
        });


    }

    @Override
    public void onBackPressed() {

        String data = res.getText().toString();

        Intent intent = new Intent();
        intent.putExtra("finalGrade", data);
        setResult(RESULT_OK, intent);
        finish();

    }
}
