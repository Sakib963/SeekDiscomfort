package com.example.seekdiscomfort;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CartActivity extends AppCompatActivity {

    TextView textview_no_one, textview_no_two, textview_no_three, textview_no_four,textview_no_five,textview_no_six,textview_no_seven,textview_no_eight,
            textview_name_one, textview_name_two, textview_name_three, textview_name_four,textview_name_five,textview_name_six,textview_name_seven,textview_name_eight,
            textview_quantity_one,textview_quantity_two,textview_quantity_three,textview_quantity_four,textview_quantity_five,textview_quantity_six,textview_quantity_seven,textview_quantity_eight,
            textview_price_one, textview_price_two, textview_price_three, textview_price_four,textview_total_price,textview_price_five,textview_price_six,textview_price_seven;
    Button order_now;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        textview_no_one = findViewById(R.id.row_two_textview_one);
        textview_no_two = findViewById(R.id.row_three_textview_one);
        textview_no_three = findViewById(R.id.row_four_textview_one);
        textview_no_four = findViewById(R.id.row_five_textview_one);
        textview_no_five = findViewById(R.id.row_six_textview_one);

        textview_name_one = findViewById(R.id.row_two_textview_two);
        textview_name_two = findViewById(R.id.row_three_textview_two);
        textview_name_three = findViewById(R.id.row_four_textview_two);
        textview_name_four = findViewById(R.id.row_five_textview_two);
        textview_name_five = findViewById(R.id.row_six_textview_two);
        textview_name_six = findViewById(R.id.row_seven_textview_two);
        textview_name_seven = findViewById(R.id.row_eight_textview_two);

        textview_quantity_one = findViewById(R.id.row_two_textview_three);
        textview_quantity_two = findViewById(R.id.row_three_textview_three);
        textview_quantity_three = findViewById(R.id.row_four_textview_three);
        textview_quantity_four = findViewById(R.id.row_five_textview_three);
        textview_quantity_five = findViewById(R.id.row_six_textview_three);
        textview_quantity_six = findViewById(R.id.row_seven_textview_three);
        textview_quantity_seven = findViewById(R.id.row_eight_textview_three);

        textview_price_one = findViewById(R.id.row_two_textview_four);
        textview_price_two = findViewById(R.id.row_three_textview_four);
        textview_price_three = findViewById(R.id.row_four_textview_four);
        textview_price_four = findViewById(R.id.row_five_textview_four);
        textview_price_five = findViewById(R.id.row_six_textview_four);
        textview_price_six = findViewById(R.id.row_seven_textview_four);
        textview_total_price = findViewById(R.id.row_eight_textview_four);

        order_now = findViewById(R.id.order_now_button);

        Intent intent = getIntent();
        String quantity_one = intent.getStringExtra("key_one");
        Integer i1 = Integer.parseInt(quantity_one);

        String quantity_two = intent.getStringExtra("key_two");
        Integer i2 = Integer.parseInt(quantity_two);

        String quantity_three = intent.getStringExtra("key_three");
        Integer i3 = Integer.parseInt(quantity_three);

        String quantity_four = intent.getStringExtra("key_four");
        Integer i4 = Integer.parseInt(quantity_four);

        String quantity_five = intent.getStringExtra("key_five");
        Integer i5 = Integer.parseInt(quantity_five);

        Double sub_total = 60.0, price = 0.0;

        if (i1 != 0)
        {
            price = i1*1200.0;
            sub_total = sub_total+price;

            textview_name_one.setText("Seek Discomfort Ring");
            textview_quantity_one.setText(String.valueOf(i1));
            textview_price_one.setText(String.valueOf(price));
            price = 0.0;
        }

        if (i2 != 0)
        {
            price = i2*500.0;
            sub_total = sub_total+price;

            textview_name_two.setText("Rope Bracelet");
            textview_quantity_two.setText(String.valueOf(i2));
            textview_price_two.setText(String.valueOf(price));
            price = 0.0;
        }
        if (i3!=0)
        {
            price = i3*700.0;
            sub_total = sub_total+price;

            textview_name_three.setText("Extra Necklace Chain");
            textview_quantity_three.setText(String.valueOf(i3));
            textview_price_three.setText(String.valueOf(price));
            price = 0.0;
        }
        if (i4!=0)
        {
            price = i4*1000.0;
            sub_total = sub_total+price;

            textview_name_four.setText("Love Over Fear Ring");
            textview_quantity_four.setText(String.valueOf(i4));
            textview_price_four.setText(String.valueOf(price));
            price = 0.0;
        }
        if (i5!=0)
        {
            price = i5*900.0;
            sub_total = sub_total+price;

            textview_name_five.setText("Mantra Necklace");
            textview_quantity_five.setText(String.valueOf(i5));
            textview_price_five.setText(String.valueOf(price));
            price = 0.0;
        }

        textview_total_price.setText(String.valueOf(sub_total));

        order_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = String.valueOf(i1);
                String s2 = String.valueOf(i2);
                String s3 = String.valueOf(i3);
                String s4 = String.valueOf(i4);
                String s5 = String.valueOf(i5);

                Intent intent = new Intent(CartActivity.this, JewelryOrderActivity.class);
                intent.putExtra("key_one", s1);
                intent.putExtra("key_two", s2);
                intent.putExtra("key_three", s3);
                intent.putExtra("key_four", s4);
                intent.putExtra("key_five", s5);
                startActivity(intent);
            }
        });
    }
}