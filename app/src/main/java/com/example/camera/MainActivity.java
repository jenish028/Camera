package com.example.camera;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;


public class MainActivity extends AppCompatActivity {

    ImageView imag_img;
    private Button galary,camara_btn;
    private AutoCompleteTextView spin;
    String[] city = {"kamadhiya", "rajkot", "surat", "amadavad", "vadodara", "baruch"};
    int[] img=
            {
                R.drawable.ic_launcher_foreground,
                R.drawable.ic_launcher_foreground,
                R.drawable.ic_launcher_foreground,
                R.drawable.ic_launcher_foreground,
                R.drawable.ic_launcher_foreground,
                R.drawable.ic_launcher_foreground};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        blinding();

//        My_Rv_Adpter my_rv_adpter = new My_Rv_Adpter(MainActivity.this,city,img);
        ArrayAdapter arrayAdapter=new ArrayAdapter(MainActivity.this, android.R.layout.simple_expandable_list_item_1,city);
//        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        spin.setAdapter(arrayAdapter);

//        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });


        galary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 100);
            }
        });

        camara_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent i1=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i1,200);
            }
        });

    }


    private void blinding() {

        imag_img = findViewById(R.id.imag_img);
        galary = findViewById(R.id.galary);
        camara_btn = findViewById(R.id.camara_btn);
        spin =findViewById(R.id.spinner);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==100)
        {

            Uri uri=data.getData();
            imag_img.setImageURI(uri);

        }
        else if(requestCode==200)
        {

          Bitmap bm  = (Bitmap) data.getExtras().get("data");
          imag_img.setImageBitmap(bm);

        }
    }

}
