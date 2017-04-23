package com.bugscript.pharmaroot;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static android.view.View.Y;


public class RetailerScannedContent extends AppCompatActivity {


    public Button checkedForCorrectnessButton,ReportedClients;
    public String key;
    private Firebase firebasesample,f2,f3,f4,f5,f6,f7,f8,f9;
    public TextView d1,d2,d3,d4,d5,d6,d7,d8,d9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retailer_scanned_content);

        Firebase.setAndroidContext(this);

        //Newer version of Firebase
        if(!FirebaseApp.getApps(this).isEmpty()) {
            FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        }



        d1=(TextView) findViewById(R.id.id1);
        d2=(TextView) findViewById(R.id.id2);
        d3=(TextView) findViewById(R.id.id3);
        d4=(TextView) findViewById(R.id.id4);
        d5=(TextView) findViewById(R.id.id5);
        d6=(TextView) findViewById(R.id.id6);
        d7=(TextView) findViewById(R.id.id7);
        d8=(TextView) findViewById(R.id.id8);
        d9=(TextView) findViewById(R.id.id9);



        key=getIntent().getExtras().getString("value");
        Toast.makeText(RetailerScannedContent.this,key,Toast.LENGTH_LONG).show();

//        if(key=="9131"){
//            AlertDialog.Builder builder=new AlertDialog.Builder(this);
//            builder.setCancelable(false);
//            builder.setTitle("Detected Fault");
//            builder.setMessage("The scanned tablet is expired..");
//            builder.setPositiveButton("Report!!",new DialogInterface.OnClickListener(){
//
//                @Override
//                public void onClick(DialogInterface dialogInterface,int id) {
//                    Toast.makeText(RetailerScannedContent.this,"You have reported to the Government..",Toast.LENGTH_SHORT).show();
//                    finish();
//                }
//            })
//                    .setNegativeButton("Automate",new DialogInterface.OnClickListener(){
//
//                @Override
//                public void onClick(DialogInterface dialogInterface,int id) {
//                    Toast.makeText(RetailerScannedContent.this,"This Process is been Automated for you..",Toast.LENGTH_SHORT).show();
//                    finish();
//                }
//            });}




        String mainParameter="https://pharmaroot-cca44.firebaseio.com/"+key;
        String sp1=mainParameter+"/tabletName";

        firebasesample=new Firebase(sp1);

        firebasesample.addValueEventListener(new com.firebase.client.ValueEventListener() {
            @Override
            public void onDataChange(com.firebase.client.DataSnapshot dataSnapshot) {
                String sam= dataSnapshot.getValue(String.class);
                d1.setText(sam);
                AlertDialog.Builder builder=new AlertDialog.Builder(RetailerScannedContent.this);
                builder.setCancelable(false);
                builder.setTitle("Detected Fault");
                builder.setMessage("The scanned tablet is expired..");
                builder.setPositiveButton("Report!!",new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialogInterface,int id) {
                        Toast.makeText(RetailerScannedContent.this,"You have reported to the Government..",Toast.LENGTH_SHORT).show();
                    }
                })
                        .setNegativeButton("Automate",new DialogInterface.OnClickListener(){

                            @Override
                            public void onClick(DialogInterface dialogInterface,int id) {
                                Toast.makeText(RetailerScannedContent.this,"This Process is been Automated for you..",Toast.LENGTH_SHORT).show();
                            }
                        });
                builder.create().show();
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                d1.setText("Cancelled..");
            }
        });

        String sp2=mainParameter+"/batchNumber";

        f2=new Firebase(sp2);
        f2.addValueEventListener(new com.firebase.client.ValueEventListener() {
            @Override
            public void onDataChange(com.firebase.client.DataSnapshot dataSnapshot) {
                String sam= dataSnapshot.getValue(String.class);
                d2.setText(sam);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                d2.setText("Cancelled..");
            }
        });

        String sp3=mainParameter+"/manuDate";
        f3=new Firebase(sp3);

        f3.addValueEventListener(new com.firebase.client.ValueEventListener() {
            @Override
            public void onDataChange(com.firebase.client.DataSnapshot dataSnapshot) {
                String sam= dataSnapshot.getValue(String.class);
                d3.setText(sam);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                d3.setText("Cancelled..");
            }
        });

        String sp4=mainParameter+"/expDate";
        f4=new Firebase(sp4);

        f4.addValueEventListener(new com.firebase.client.ValueEventListener() {
            @Override
            public void onDataChange(com.firebase.client.DataSnapshot dataSnapshot) {
                String sam= dataSnapshot.getValue(String.class);
                d4.setText(sam);

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                d4.setText("Cancelled..");
            }
        });

        String sp5=mainParameter+"/mrp";
        f5=new Firebase(sp5);

        f5.addValueEventListener(new com.firebase.client.ValueEventListener() {
            @Override
            public void onDataChange(com.firebase.client.DataSnapshot dataSnapshot) {
                String sam= dataSnapshot.getValue(String.class);
                d5.setText(sam);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                d5.setText("Cancelled..");
            }
        });

        String sp6=mainParameter+"/licenceNumber";
        f6=new Firebase(sp6);

        f6.addValueEventListener(new com.firebase.client.ValueEventListener() {
            @Override
            public void onDataChange(com.firebase.client.DataSnapshot dataSnapshot) {
                String sam= dataSnapshot.getValue(String.class);
                d6.setText(sam);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                d6.setText("Cancelled..");
            }
        });

        String sp7=mainParameter+"/maximumDosage";
        f7=new Firebase(sp7);

        f7.addValueEventListener(new com.firebase.client.ValueEventListener() {
            @Override
            public void onDataChange(com.firebase.client.DataSnapshot dataSnapshot) {
                String sam= dataSnapshot.getValue(String.class);
                d7.setText(sam);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                d7.setText("Cancelled..");
            }
        });

        String sp8=mainParameter+"/diseaseCured";
        f8=new Firebase(sp8);

        f8.addValueEventListener(new com.firebase.client.ValueEventListener() {
            @Override
            public void onDataChange(com.firebase.client.DataSnapshot dataSnapshot) {
                String sam= dataSnapshot.getValue(String.class);
                d8.setText(sam);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                d8.setText("Cancelled..");
            }
        });

        String sp9=mainParameter+"/companyName";
        f9=new Firebase(sp9);

        f9.addValueEventListener(new com.firebase.client.ValueEventListener() {
            @Override
            public void onDataChange(com.firebase.client.DataSnapshot dataSnapshot) {
                String sam= dataSnapshot.getValue(String.class);
                d9.setText(sam);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                d9.setText("Cancelled..");
            }
        });


        checkedForCorrectnessButton=(Button) findViewById(R.id.checkedForCorrectness);
        checkedForCorrectnessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(RetailerScannedContent.this,Base.class);
                startActivity(i);

            }
        });

        ReportedClients=(Button) findViewById(R.id.clientsReport);
        ReportedClients.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(RetailerScannedContent.this,"Report Function has not yet been Implemented",Toast.LENGTH_LONG).show();
            }
        });





    }
}
