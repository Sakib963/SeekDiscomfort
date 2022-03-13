package com.example.seekdiscomfort;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class OrderActivity extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference = database.getReference().child("Orders");
    FirebaseAuth mAuth;

    TextView textview_no_one, textview_no_two, textview_no_three, textview_no_four,
            textview_name_one, textview_name_two, textview_name_three, textview_name_four,textview_name_five,
            textview_quantity_one,textview_quantity_two,textview_quantity_three,textview_quantity_four,textview_quantity_five,
            textview_price_one, textview_price_two, textview_price_three, textview_price_four,textview_price_five,
            textview_total_price;

    EditText full_name, contact_number, street_address, city, promo;
    Button go_back, confirm_order,apply;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        full_name = findViewById(R.id.full_name_address);
        contact_number = findViewById(R.id.contact_number_address);
        street_address = findViewById(R.id.street_address);
        city = findViewById(R.id.city_address);

        go_back = findViewById(R.id.go_back_button);
        confirm_order = findViewById(R.id.order_confirm_button);

        textview_no_one = findViewById(R.id.row_two_textview_one);
        textview_no_two = findViewById(R.id.row_three_textview_one);
        textview_no_three = findViewById(R.id.row_four_textview_one);
        textview_no_four = findViewById(R.id.row_five_textview_one);

        textview_name_one = findViewById(R.id.row_two_textview_two);
        textview_name_two = findViewById(R.id.row_three_textview_two);
        textview_name_three = findViewById(R.id.row_four_textview_two);
        textview_name_four = findViewById(R.id.row_five_textview_two);
        textview_name_five = findViewById(R.id.row_six_textview_two);

        textview_quantity_one = findViewById(R.id.row_two_textview_three);
        textview_quantity_two = findViewById(R.id.row_three_textview_three);
        textview_quantity_three = findViewById(R.id.row_four_textview_three);
        textview_quantity_four = findViewById(R.id.row_five_textview_three);
        textview_quantity_five = findViewById(R.id.row_six_textview_three);

        textview_price_one = findViewById(R.id.row_two_textview_four);
        textview_price_two = findViewById(R.id.row_three_textview_four);
        textview_price_three = findViewById(R.id.row_four_textview_four);
        textview_price_four = findViewById(R.id.row_five_textview_four);
        textview_price_five = findViewById(R.id.row_six_textview_four);


        textview_total_price = findViewById(R.id.table_two_textview_eight);
        apply = findViewById(R.id.apply_btn);
        promo = findViewById(R.id.promo_code_edit_text);

        mAuth = FirebaseAuth.getInstance();

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
            price = i1*800.0;
            sub_total = sub_total+price;

            textview_name_one.setText("Seeker LS Tee");
            textview_quantity_one.setText(String.valueOf(i1));
            textview_price_one.setText(String.valueOf(price));
            price = 0.0;
        }

        if (i2 != 0)
        {
            price = i2*500.0;
            sub_total = sub_total+price;

            textview_name_two.setText("Seeker Fashion Tee");
            textview_quantity_two.setText(String.valueOf(i2));
            textview_price_two.setText(String.valueOf(price));
            price = 0.0;
        }
        if (i3!=0)
        {
            price = i3*400.0;
            sub_total = sub_total+price;

            textview_name_three.setText("High Rise Pant");
            textview_quantity_three.setText(String.valueOf(i3));
            textview_price_three.setText(String.valueOf(price));
            price = 0.0;
        }
        if (i4!=0)
        {
            price = i4*600.0;
            sub_total = sub_total+price;

            textview_name_four.setText("Seeker Sweatpants");
            textview_quantity_four.setText(String.valueOf(i4));
            textview_price_four.setText(String.valueOf(price));
            price = 0.0;
        }
        if (i5!=0)
        {
            price = i5*900.0;
            sub_total = sub_total+price;

            textview_name_five.setText("Seeker SweatShirt");
            textview_quantity_five.setText(String.valueOf(i5));
            textview_price_five.setText(String.valueOf(price));
            price = 0.0;
        }

        textview_total_price.setText(String.valueOf(sub_total));


        go_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(OrderActivity.this, SeekersEssential.class);
                startActivity(intent2);
            }
        });

        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String promo_code, price_string;
                promo_code = promo.getText().toString();
                price_string = textview_total_price.getText().toString();

                Double price_code;
                price_code = Double.parseDouble(String.valueOf(price_string));

                if (promo_code.equals("Seek100"))
                {
                    price_code = price_code -100.0;

                    textview_total_price.setText(String.valueOf(price_code));
                }
                else if (promo_code.equals("Seek200"))
                {
                    price_code = price_code -200;

                    textview_total_price.setText(String.valueOf(price_code));
                }
                apply.setEnabled(false);
            }
        });

        confirm_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!TextUtils.isEmpty(full_name.getText().toString()) && !TextUtils.isEmpty(contact_number.getText().toString()) && !TextUtils.isEmpty(street_address.getText().toString()) && !TextUtils.isEmpty(city.getText().toString()))
                {
                    String user_full_name = full_name.getText().toString();
                    String user_phone_number = contact_number.getText().toString();
                    String user_street_address = street_address.getText().toString();
                    String user_city = city.getText().toString();

                    String food_name_one = textview_name_one.getText().toString();
                    String food_name_two= textview_name_two.getText().toString();
                    String food_name_three = textview_name_three.getText().toString();
                    String food_name_four = textview_name_four.getText().toString();
                    String food_name_five = textview_name_five.getText().toString();

                    String quantity_food_one = textview_quantity_one.getText().toString();
                    String quantity_food_two= textview_quantity_two.getText().toString();
                    String quantity_food_three = textview_quantity_three.getText().toString();
                    String quantity_food_four = textview_quantity_four.getText().toString();
                    String quantity_food_five = textview_quantity_five.getText().toString();

                    String sub_total = textview_total_price.getText().toString();
                    String order_id = databaseReference.push().getKey();

                    HashMap<String, String> usermap = new HashMap<>();
                    usermap.put("orderID", order_id);
                    usermap.put("name", user_full_name);
                    usermap.put("phoneNumber", user_phone_number);
                    usermap.put("streetAddress", user_street_address);
                    usermap.put("city", user_city);

                    usermap.put("prodOne", food_name_one);
                    usermap.put("prodTwo", food_name_two);
                    usermap.put("prodThree", food_name_three);
                    usermap.put("prodFour", food_name_four);
                    usermap.put("prodFive", food_name_five);

                    usermap.put("quaOne", quantity_food_one);
                    usermap.put("quaTwo", quantity_food_two);
                    usermap.put("quaThree", quantity_food_three);
                    usermap.put("quaFour", quantity_food_four);
                    usermap.put("quaFive", quantity_food_five);

                    usermap.put("total", sub_total);

                    databaseReference.child("OrderID").child(order_id).setValue(usermap);

                    Toast.makeText(OrderActivity.this, "Order Successfully Received\nThanks for Ordering", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(OrderActivity.this, OrdersListActivity.class);
                    i.putExtra("key", order_id);
                    i.putExtra("prod_one", food_name_one);
                    i.putExtra("prod_two", food_name_two);
                    i.putExtra("prod_three", food_name_three);
                    i.putExtra("prod_four", food_name_four);
                    i.putExtra("prod_five", food_name_five);
                    i.putExtra("total", sub_total);
                    startActivity(i);
                }

                else
                {
                    confirm_order.setError("Address field must be filled");

                    if (TextUtils.isEmpty(full_name.getText().toString()))
                    {
                        full_name.setError("");
                        Toast.makeText(OrderActivity.this, "Full Name must be Filled", Toast.LENGTH_SHORT).show();
                    }
                    if (TextUtils.isEmpty(contact_number.getText().toString()))
                    {
                        contact_number.setError("");
                        Toast.makeText(OrderActivity.this, "Contact Number must be Filled", Toast.LENGTH_SHORT).show();
                    }
                    if (TextUtils.isEmpty(street_address.getText().toString()))
                    {
                        street_address.setError("");
                        Toast.makeText(OrderActivity.this, "Street Address must be Filled", Toast.LENGTH_SHORT).show();
                    }
                    if (TextUtils.isEmpty(city.getText().toString()))
                    {
                        city.setError("");
                        Toast.makeText(OrderActivity.this, "City Name must be Filled", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

}