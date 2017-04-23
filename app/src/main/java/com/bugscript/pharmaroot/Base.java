package com.bugscript.pharmaroot;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Base extends AppCompatActivity {

    public ImageView saler,customer;

    public ImageView entryOfData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        saler=(ImageView) findViewById(R.id.wholesaler);
        customer=(ImageView) findViewById(R.id.clientid);
        entryOfData=(ImageView) findViewById(R.id.parmaid);

        saler.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent i=new Intent(Base.this,WholeSalers.class);
                startActivity(i);
            }
        });

        customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Base.this,MainActivity.class);
                startActivity(i);
            }
        });

        entryOfData.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent i=new Intent(Base.this,DataEntry.class);
                startActivity(i);
            }
        });

    }
}
