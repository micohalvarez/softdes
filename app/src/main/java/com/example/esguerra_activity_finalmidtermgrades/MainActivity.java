package com.example.esguerra_activity_finalmidtermgrades;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.DataInput;


public class MainActivity extends AppCompatActivity {
    private Button button;
    private Button finalButton,compute;
    private Button Buttonsave;
    public Intent intent;
    TextView midTermGrade,finalGrade,overAllGrade,Status,Convert;
    private Double Stat;
    DatabaseReference myreff;
    Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        student = new Student();
        midTermGrade = findViewById(R.id.midtermGrade);
        finalGrade = findViewById(R.id.finalGrade);
        overAllGrade = findViewById(R.id.overAllGrade);
        Status = findViewById(R.id.status);
        Convert = findViewById(R.id.convert);

        compute = findViewById(R.id.compute);
        button =  findViewById(R.id.midtermbutton);
        Buttonsave = findViewById(R.id.btnSave);

        midTermGrade.setText("0");
        finalGrade.setText("0");
        Status.setText("0");
        Convert.setText("0");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });

        finalButton = findViewById(R.id.finalGradeButton);
        finalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFinalGradeActivity();
            }
        });

        compute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                overAllGrade.setText(Double.toString((Double.parseDouble(finalGrade.getText().toString())*.7 +
                        Double.parseDouble(midTermGrade.getText().toString())*.3)));
                Stat = (Double.parseDouble(finalGrade.getText().toString())*.7 +
                        Double.parseDouble(midTermGrade.getText().toString())*.3);
                {if(Stat <75)
                {
                    Status.setText("Fail");
                    Convert.setText("F");
                }
                else if (Stat > 75)
                {
                    Status.setText("Pass");
                }}
                if (Stat==95 || Stat>95 )
                {
                    Convert.setText("A");
                }
                else if ((Stat==92 || Stat>92) && (Stat<94 || Stat==94))
                {
                    Convert.setText("B");
                }
                else if ((Stat==87 || Stat>87) && (Stat<91 || Stat==91))
                {
                    Convert.setText("C");
                }
                else if ((Stat==80 || Stat>80) && (Stat<86 || Stat==86))
                {
                    Convert.setText("D");
                }
                else if ((Stat==75 || Stat>75) && (Stat<79 || Stat==79))
                {
                    Convert.setText("E");
                }

            }
        });
//        myreff = FirebaseDatabase.getInstance().getReference().child("message");
//        myreff.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//
//                   System.out.println(dataSnapshot.getChildrenCount());
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });

        myreff = FirebaseDatabase.getInstance().getReference().child("Student");


        Buttonsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    student.setFinalmidterm("0");
                    student.setFinalfinal("0");
                    student.setFinalconvertgrade("0");
                    student.setFinaloverall("0");
                    student.setFinalstatus("0");

                    String key = myreff.push().getKey();
                    myreff.child(key).setValue(student);
                    System.out.println(myreff.getKey());

                    Toast.makeText(MainActivity.this, "Data Submitted Successfully", Toast.LENGTH_LONG).show();

            }
        });


    }

    public void openActivity2(){
            intent = new Intent(this, Activity2.class);
            startActivityForResult(intent, 1);
        }

    public void openFinalGradeActivity(){
        intent = new Intent(this, FinalGradeActivity.class);
        startActivityForResult(intent, 1);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

            if(resultCode == RESULT_OK) {
                if(data.hasExtra("midTermGrade")) {
                    String strEditText = data.getStringExtra("midTermGrade");
                    midTermGrade.setText(strEditText);
                }
                else if(data.hasExtra("finalGrade")) {
                    String strEditText = data.getStringExtra("finalGrade");
                    finalGrade.setText(strEditText);
                }
            }


    }

}
