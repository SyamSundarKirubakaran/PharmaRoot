package com.bugscript.pharmaroot;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class WholeSalers extends AppCompatActivity {

    public Button sampleLoginButton;
    public EditText wholesalersEmailRegistered,wholesalersPasswordRegistered;

    private ProgressDialog progressDialogue;

    private FirebaseAuth firebaseAuth;

    public Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whole_salers);

        firebaseAuth= FirebaseAuth.getInstance();
        progressDialogue = new ProgressDialog(this);

        loginButton=(Button) findViewById(R.id.wholesalersLogin);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wholeRegistrationFunction();
            }
        });

        wholesalersEmailRegistered=(EditText) findViewById(R.id.wholesalerEmail);
        wholesalersPasswordRegistered=(EditText) findViewById(R.id.wholesallersPassword);

    }


    private void wholeRegistrationFunction(){
        String email=wholesalersEmailRegistered.getText().toString().trim();
        String password=wholesalersPasswordRegistered.getText().toString().trim();

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
                            Toast.makeText(WholeSalers.this,"You have Registered Successfully",Toast.LENGTH_SHORT).show();
                            progressDialogue.dismiss();
                            Intent i=new Intent(WholeSalers.this,WholeSalersContent.class);
                            startActivity(i);

                        }else{
                            Toast.makeText(WholeSalers.this,"Registration insuccessfull.. Try again",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
