package com.example.seekdiscomfort;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class OrdersListActivity extends AppCompatActivity {
    TextView order_id, products, price;
    Button submit;
    RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders_list);

        order_id = findViewById(R.id.order_id_textview);
        products = findViewById(R.id.products_textview);
        price = findViewById(R.id.price_textview);
        submit = findViewById(R.id.submit_button);
        ratingBar = findViewById(R.id.rating_bar);


        Intent intent = getIntent();
        String s1 = intent.getStringExtra("key");
        String s2 = intent.getStringExtra("prod_one");
        String s3 = intent.getStringExtra("prod_two");
        String s4 = intent.getStringExtra("prod_three");
        String s5 = intent.getStringExtra("prod_four");
        String s6 = intent.getStringExtra("prod_five");
        String s7 = intent.getStringExtra("total");

        order_id.setText(s1);
        products.setText(s2+" "+s3+" "+s4+" "+s5+" "+s6);
        price.setText(s7);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String r = String.valueOf(ratingBar.getRating());
                Toast.makeText(getApplicationContext(), "Thank you for giving us "+r+" Star",
                        Toast.LENGTH_SHORT).show();
                startActivity(new Intent(OrdersListActivity.this, MainActivity.class));
            }
        });


    }
}