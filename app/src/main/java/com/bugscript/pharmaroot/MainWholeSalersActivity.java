package com.bugscript.pharmaroot;

import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.FirebaseDatabase;

public class MainWholeSalersActivity extends AppCompatActivity{

    public Button updateButtonWhole,LogoutButtonWhole,crossedLocationWhole,CurrentLocationWhole;
    private Firebase firebasesample,f2,f3,f4;
    public String key;
    public EditText authucodereceived;
    public TextView wTabName,wBatchNumber,wManuDate,wExpDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_whole_salers);


        Firebase.setAndroidContext(this);

        //Newer version of Firebase
        if(!FirebaseApp.getApps(this).isEmpty()) {
            FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        }


        key =getIntent().getExtras().getString("StdCode");
        Toast.makeText(MainWholeSalersActivity.this,key,Toast.LENGTH_SHORT).show();


        authucodereceived=(EditText) findViewById(R.id.authucode);

        updateButtonWhole=(Button) findViewById(R.id.wholeSalersUpdate);
        LogoutButtonWhole=(Button) findViewById(R.id.wholesalerReport);
        crossedLocationWhole=(Button) findViewById(R.id.ViewCrossedLocationalValueButton);
        CurrentLocationWhole=(Button) findViewById(R.id.MarkCurrentLocationalValueButtons);


        updateButtonWhole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String subordinateKey=authucodereceived.getText().toString().trim();
                if(subordinateKey.equalsIgnoreCase("1111")) {
                    Intent i = new Intent(MainWholeSalersActivity.this, EditWholeSalers.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(MainWholeSalersActivity.this,"Invalid Authentication Code",Toast.LENGTH_SHORT).show();
                }
            }
        });

        LogoutButtonWhole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainWholeSalersActivity.this,Base.class);
                startActivity(i);
                Toast.makeText(MainWholeSalersActivity.this,"You have Successfully Logged out..",Toast.LENGTH_SHORT).show();
            }
        });

        crossedLocationWhole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainWholeSalersActivity.this,LocationCrossed.class);
                i.putExtra("vvvalue",key);
                startActivity(i);
            }
        });

        CurrentLocationWhole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("geo:15.3647,75.1240"));
                Intent chooser=Intent.createChooser(i,"Launch Maps");
                startActivity(chooser);
            }
        });



        wTabName=(TextView) findViewById(R.id.tabNameWhole);
        wBatchNumber=(TextView) findViewById(R.id.wholebatchNumber);
        wManuDate=(TextView) findViewById(R.id.manuDateWhole);
        wExpDate=(TextView) findViewById(R.id.expiryDateWhole);

        String mainParameter="https://pharmaroot-cca44.firebaseio.com/"+key;
        String sp1=mainParameter+"/tabletName";

        firebasesample=new Firebase(sp1);

        firebasesample.addValueEventListener(new com.firebase.client.ValueEventListener() {
            @Override
            public void onDataChange(com.firebase.client.DataSnapshot dataSnapshot) {
                String sam= dataSnapshot.getValue(String.class);
                wTabName.setText(sam);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                wTabName.setText("Cancelled..");
            }
        });

        String sp2=mainParameter+"/batchNumber";

        f2=new Firebase(sp2);
        f2.addValueEventListener(new com.firebase.client.ValueEventListener() {
            @Override
            public void onDataChange(com.firebase.client.DataSnapshot dataSnapshot) {
                String sam= dataSnapshot.getValue(String.class);
                wBatchNumber.setText(sam);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                wBatchNumber.setText("Cancelled..");
            }
        });

        String sp3=mainParameter+"/manuDate";
        f3=new Firebase(sp3);

        f3.addValueEventListener(new com.firebase.client.ValueEventListener() {
            @Override
            public void onDataChange(com.firebase.client.DataSnapshot dataSnapshot) {
                String sam= dataSnapshot.getValue(String.class);
                wManuDate.setText(sam);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                wManuDate.setText("Cancelled..");
            }
        });


        String sp4=mainParameter+"/expDate";
        f4=new Firebase(sp4);

        f4.addValueEventListener(new com.firebase.client.ValueEventListener() {
            @Override
            public void onDataChange(com.firebase.client.DataSnapshot dataSnapshot) {
                String sam= dataSnapshot.getValue(String.class);
                wExpDate.setText(sam);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                wExpDate.setText("Cancelled..");
            }
        });









    }


}
