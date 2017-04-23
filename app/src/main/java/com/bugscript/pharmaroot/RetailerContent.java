package com.bugscript.pharmaroot;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageMetadata;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.util.UUID;

public class RetailerContent extends AppCompatActivity {

    private FirebaseStorage storage=FirebaseStorage.getInstance();

    private ProgressDialog progressDialogue;

    public Button getInfoButton,scanResults;
    public EditText stdCodeClient;
    public String stdvalue;
    ImageView clientScaningImage;
    private static final int CAMERA_REQUEST=123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retailer_content);
        stdCodeClient=(EditText) findViewById(R.id.stdcode);
        clientScaningImage=(ImageView) findViewById(R.id.clientImage);

        getInfoButton=(Button) findViewById(R.id.getInfo);
        getInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  Intent i=new Intent(RetailerContent.this,RetailerScannedContent.class);
                  stdvalue=stdCodeClient.getText().toString().trim();
                  i.putExtra("value",stdvalue);
                  startActivity(i);
                  finish();
            }
        });

        scanResults=(Button) findViewById(R.id.clientScan);
        scanResults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,CAMERA_REQUEST);
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==CAMERA_REQUEST&& resultCode== Activity.RESULT_OK){
            Bitmap photo=(Bitmap) data.getExtras().get("data");
            clientScaningImage.setImageBitmap(photo);

        }
    }
}
