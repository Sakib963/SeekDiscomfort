package com.example.seekdiscomfort;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.List;

public class AddProductActivity extends AppCompatActivity {

    ImageView imageView;
    Button upload, confirm_btn;
    EditText name_text, price_text, desc_text;

    ActivityResultLauncher<String> mGetContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        imageView = findViewById(R.id.product_image);
        upload = findViewById(R.id.uploadPhoto);
        confirm_btn = findViewById(R.id.add_product_button);
        name_text = findViewById(R.id.product_name_edit_text);
        price_text = findViewById(R.id.product_price_edit_text);
        desc_text = findViewById(R.id.product_description_edit_text);


        mGetContent  = registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
            @Override
            public void onActivityResult(Uri result) {
                imageView.setImageURI(result);
            }
        });

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mGetContent.launch("image/*");
            }
        });



    }
}