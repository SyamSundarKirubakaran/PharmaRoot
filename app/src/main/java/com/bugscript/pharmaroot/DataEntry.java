package com.bugscript.pharmaroot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.sql.DataTruncation;

public class DataEntry extends AppCompatActivity {

    public EditText tabnumber,tabname,batchnumber,manudate,expdate,mrp,licencennumber,maxdosage,diseasecured,companyname;
    public Button submitsample;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_entry);

        databaseReference= FirebaseDatabase.getInstance().getReference();

        tabnumber=(EditText) findViewById(R.id.tabletnumber);
        tabname=(EditText) findViewById(R.id.tabletname);
        batchnumber=(EditText) findViewById(R.id.batchnumber);
        manudate=(EditText) findViewById(R.id.mandate);
        expdate=(EditText) findViewById(R.id.expdate);
        mrp=(EditText) findViewById(R.id.mrp);
        licencennumber=(EditText) findViewById(R.id.licencenumber);
        maxdosage=(EditText) findViewById(R.id.maxdosage);
        diseasecured=(EditText) findViewById(R.id.diseasecured);
        companyname=(EditText) findViewById(R.id.companyname);

        submitsample=(Button) findViewById(R.id.submitbuttonfordata);

        submitsample.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=tabnumber.getText().toString().trim();
                String s2=tabname.getText().toString().trim();
                String s3=batchnumber.getText().toString().trim();
                String s4=manudate.getText().toString().trim();
                String s5=expdate.getText().toString().trim();
                String s6=mrp.getText().toString().trim();
                String s7=licencennumber.getText().toString().trim();
                String s8=maxdosage.getText().toString().trim();
                String s9=diseasecured.getText().toString().trim();
                String s10=companyname.getText().toString().trim();

                UserInformation userInformation = new UserInformation(s1,s2,s3,s4,s5,s6,s7,s8,s9,s10);

                databaseReference.child(s1).setValue(userInformation);

                Toast.makeText(DataEntry.this,"Successfully Saved",Toast.LENGTH_SHORT).show();

            }
        });




    }
}
