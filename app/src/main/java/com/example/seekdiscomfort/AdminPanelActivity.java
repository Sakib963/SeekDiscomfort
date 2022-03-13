package com.example.seekdiscomfort;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminPanelActivity extends AppCompatActivity {
    Button logout, add_product, delete_product, orders, promo_code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_panel);

        logout = findViewById(R.id.logout_admin_button);
        add_product = findViewById(R.id.add_new_product_button);
        delete_product = findViewById(R.id.delete_product_button);
        orders = findViewById(R.id.orders_button);
        promo_code = findViewById(R.id.add_promo_code_button);


        add_product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminPanelActivity.this, AddProductActivity.class);
                startActivity(intent);
            }
        });


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
    }
}