package com.bugscript.pharmaroot;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    public Button sampleLoginButton;
    public EditText retailersEmailRegistered,retailersPasswordRegistered;

    private ProgressDialog progressDialogue;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth= FirebaseAuth.getInstance();
        progressDialogue = new ProgressDialog(this);

        sampleLoginButton=(Button) findViewById(R.id.retailersloginButton);
        sampleLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  registrationFunction();
            }
        });


        retailersEmailRegistered=(EditText) findViewById(R.id.retailerEmail);
        retailersPasswordRegistered=(EditText) findViewById(R.id.retailerPassword);


    }

    private void registrationFunction(){
        String email=retailersEmailRegistered.getText().toString().trim();
        String password=retailersPasswordRegistered.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Please enter valid informations",Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Please enter valid informations",Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialogue.setMessage("Processing.. Hold on a Second..");
        progressDialogue.show();

        firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity.this,"You have Registered Successfully",Toast.LENGTH_SHORT).show();
                            progressDialogue.dismiss();
                            Intent i=new Intent(MainActivity.this,RetailerContent.class);
                            startActivity(i);

                        }else{
                            Toast.makeText(MainActivity.this,"Registration insuccessfull.. Try again",Toast.LENGTH_SHORT).show();
                        }
                    }
                });


    }
}
