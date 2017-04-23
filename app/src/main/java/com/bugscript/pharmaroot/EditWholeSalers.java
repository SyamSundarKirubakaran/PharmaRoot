package com.bugscript.pharmaroot;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EditWholeSalers extends AppCompatActivity {

    public Button updateNoowMessage;
    public EditText tttanumber,bbbno,mmmmnu,eeenu;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_whole_salers);

        databaseReference= FirebaseDatabase.getInstance().getReference();


        tttanumber=(EditText) findViewById(R.id.tabno);
        bbbno=(EditText) findViewById(R.id.bnumber);
        mmmmnu=(EditText) findViewById(R.id.mnumber);
        eeenu=(EditText) findViewById(R.id.editText);
        updateNoowMessage=(Button) findViewById(R.id.updateContent);


        updateNoowMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sss=tttanumber.getText().toString().trim();
                String ss1=bbbno.getText().toString().trim();
                String ss2=mmmmnu.getText().toString().trim();
                String ss3=eeenu.getText().toString().trim();

                UpdateUserInformation updatedUserInformation=new UpdateUserInformation(ss1,ss2,ss3);

                databaseReference.child("Requested_Updates").setValue(updatedUserInformation);

                Intent i=new Intent(EditWholeSalers.this,MainWholeSalersActivity.class);
                i.putExtra("StdCode",sss);
                startActivity(i);

            }
        });





    }
}
