package com.example.esguerra_activity_finalmidtermgrades;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class GetGradeData extends AppCompatActivity {

    private Button bGatherGrade;
    private TextView bFinalGrade;
    private TextView bMidtermGrade;
    private TextView bStatus;
    private TextView bConvert;
    private TextView bOverall;
    private DatabaseReference gatherRef;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getgrade);


        bGatherGrade = findViewById(R.id.buttonGather);
        bFinalGrade = findViewById(R.id.finalGatherGrade);
        bMidtermGrade = findViewById(R.id.midtermGatherGrade);
        bStatus = findViewById(R.id.statusGatherGrade);
        bConvert = findViewById(R.id.convertGatherGrade);
        bOverall = findViewById(R.id.overallGatherGrade);

        gatherRef = (DatabaseReference) FirebaseDatabase.getInstance().getReference().child("Student1");

        gatherRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String FinalGrade = String.valueOf(snapshot.);
                System.out.println(FinalGrade);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });







    }
}
