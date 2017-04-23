package com.bugscript.pharmaroot;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
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
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageMetadata;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.util.UUID;

import static android.R.attr.bitmap;

public class WholeSalersContent extends AppCompatActivity {

    private FirebaseStorage storage=FirebaseStorage.getInstance();

    private ProgressDialog progressDialogue;


    public Button ScanForBinding,BindAndSearch;
    public EditText wholeSalersStandardCode;
    ImageView wholeScannedCustomCode;
    public String stdCodeForWholeSalers;
    public Bitmap photo;
    private static final int CAMERA_REQUEST=122;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whole_salers_content);
        ScanForBinding=(Button) findViewById(R.id.wholesalerScan);
        BindAndSearch=(Button) findViewById(R.id.wholesalerPostInformation);

        progressDialogue = new ProgressDialog(this);

        wholeSalersStandardCode=(EditText) findViewById(R.id.wholestdCode);
        wholeScannedCustomCode=(ImageView) findViewById(R.id.wholeImageSet);


        ScanForBinding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,CAMERA_REQUEST);
            }
        });

        BindAndSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stdCodeForWholeSalers=wholeSalersStandardCode.getText().toString().trim();
                Intent i=new Intent(WholeSalersContent.this,MainWholeSalersActivity.class);
                i.putExtra("StdCode",stdCodeForWholeSalers);
                startActivity(i);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==CAMERA_REQUEST&& resultCode== Activity.RESULT_OK){
            photo=(Bitmap) data.getExtras().get("data");
            wholeScannedCustomCode.setImageBitmap(photo);

            ByteArrayOutputStream boas=new ByteArrayOutputStream();
            photo.compress(Bitmap.CompressFormat.PNG,100,boas);

            byte[] byteArray = boas.toByteArray();


            String path= "Pharma_root/"+ UUID.randomUUID()+".png";
            StorageReference firebaseRef=storage.getReference(path);


            stdCodeForWholeSalers=wholeSalersStandardCode.getText().toString().trim();
            StorageMetadata metadata =new StorageMetadata.Builder()
                    .setCustomMetadata("Tablet_ID",stdCodeForWholeSalers)
                    .build();

            progressDialogue.setMessage("Uploading Image.. Hold On..");
            progressDialogue.show();

            UploadTask uploadTask=firebaseRef.putBytes(byteArray,metadata);
            uploadTask.addOnSuccessListener(WholeSalersContent.this,new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    progressDialogue.dismiss();
                    Toast.makeText(WholeSalersContent.this,"The Image has Successfully been Uploaded..",Toast.LENGTH_SHORT).show();
                }
            });
            uploadTask.addOnFailureListener(WholeSalersContent.this, new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    progressDialogue.dismiss();
                    Toast.makeText(WholeSalersContent.this,"The Image upload was cancelled due to technical errors..",Toast.LENGTH_SHORT).show();
                }
            });




        }
    }
}


