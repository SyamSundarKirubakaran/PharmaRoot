package com.bugscript.pharmaroot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class LocationCrossed extends AppCompatActivity {

    public Button locationalEntitiesCrossed;
    public Firebase li1,li2,li3,li4;
    public String lll,mainLink;
    public TextView p1,p2,p3,p4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_crossed);


        p1=(TextView) findViewById(R.id.l1);
        p2=(TextView) findViewById(R.id.l2);
        p3=(TextView) findViewById(R.id.l3);
        p4=(TextView) findViewById(R.id.l4);


        lll=getIntent().getExtras().getString("vvvalue");
        Toast.makeText(LocationCrossed.this,lll,Toast.LENGTH_SHORT).show();

        mainLink="https://pharmaroot-cca44.firebaseio.com/";
        String sec1=mainLink+lll+"/loc1";

        li1=new Firebase(sec1);
        li1.addValueEventListener(new com.firebase.client.ValueEventListener() {
            @Override
            public void onDataChange(com.firebase.client.DataSnapshot dataSnapshot) {
                String sam= dataSnapshot.getValue(String.class);
                p1.setText("-> "+sam);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                p1.setText("Cancelled..");
            }
        });

        String sec2=mainLink+lll+"/loc2";

        li2=new Firebase(sec2);
        li2.addValueEventListener(new com.firebase.client.ValueEventListener() {
            @Override
            public void onDataChange(com.firebase.client.DataSnapshot dataSnapshot) {
                String sam= dataSnapshot.getValue(String.class);
                p2.setText("-> "+sam);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                p2.setText("Cancelled..");
            }
        });

        String sec3=mainLink+lll+"/loc3";


        li3=new Firebase(sec3);
        li3.addValueEventListener(new com.firebase.client.ValueEventListener() {
            @Override
            public void onDataChange(com.firebase.client.DataSnapshot dataSnapshot) {
                String sam= dataSnapshot.getValue(String.class);
                p3.setText("-> "+sam);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                p3.setText("Cancelled..");
            }
        });

        String sec4=mainLink+lll+"/loc4";

        li4=new Firebase(sec4);
        li4.addValueEventListener(new com.firebase.client.ValueEventListener() {
            @Override
            public void onDataChange(com.firebase.client.DataSnapshot dataSnapshot) {
                String sam= dataSnapshot.getValue(String.class);
                p4.setText("-> "+sam);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                p4.setText("Cancelled..");
            }
        });



        locationalEntitiesCrossed=(Button) findViewById(R.id.locationchecked);
        locationalEntitiesCrossed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(LocationCrossed.this,MainWholeSalersActivity.class);
                i.putExtra("StdCode",lll);
                startActivity(i);
            }
        });

    }




}
