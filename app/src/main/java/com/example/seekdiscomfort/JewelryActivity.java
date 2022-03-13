package com.example.seekdiscomfort;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class JewelryActivity extends AppCompatActivity {

    Button prod_one_cart, prod_one_plus, prod_one_minus,
            prod_two_cart,prod_two_plus, prod_two_minus,
            prod_three_cart, prod_three_plus, prod_three_minus,
            prod_four_cart, prod_four_plus, prod_four_minus,
            prod_five_cart, prod_five_plus, prod_five_minus,
            proceed;
    FloatingActionButton floatingActionButton;
    TextView prod_one_quantity, prod_two_quantity, prod_three_quantity, prod_four_quantity, prod_five_quantity;
    int quantity_of_prod_one =0, quantity_of_prod_two =0, quantity_of_prod_three =0, quantity_of_prod_four =0, quantity_of_prod_five =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jewelry);

        floatingActionButton = findViewById(R.id.floating_button);

        prod_one_cart = findViewById(R.id.prod_one_cart_button);
        prod_one_plus = findViewById(R.id.plus_prod_one);
        prod_one_minus = findViewById(R.id.minus_prod_one);
        prod_one_quantity = findViewById(R.id.prod_one_quantity_text);

        prod_two_cart = findViewById(R.id.prod_two_cart_button);
        prod_two_plus = findViewById(R.id.plus_prod_two);
        prod_two_minus = findViewById(R.id.minus_prod_two);
        prod_two_quantity = findViewById(R.id.prod_two_quantity_text);

        prod_three_cart = findViewById(R.id.prod_three_cart_button);
        prod_three_plus = findViewById(R.id.plus_prod_three);
        prod_three_minus = findViewById(R.id.minus_prod_three);
        prod_three_quantity = findViewById(R.id.prod_three_quantity_text);

        prod_four_cart = findViewById(R.id.prod_four_cart_button);
        prod_four_plus = findViewById(R.id.plus_prod_four);
        prod_four_minus = findViewById(R.id.minus_prod_four);
        prod_four_quantity = findViewById(R.id.prod_four_quantity_text);

        prod_five_cart = findViewById(R.id.prod_five_cart_button);
        prod_five_plus = findViewById(R.id.plus_prod_five);
        prod_five_minus = findViewById(R.id.minus_prod_five);
        prod_five_quantity = findViewById(R.id.prod_five_quantity_text);

        prod_one_quantity.setVisibility(View.INVISIBLE);
        prod_one_plus.setVisibility(View.INVISIBLE);
        prod_one_minus.setVisibility(View.INVISIBLE);

        prod_two_quantity.setVisibility(View.INVISIBLE);
        prod_two_plus.setVisibility(View.INVISIBLE);
        prod_two_minus.setVisibility(View.INVISIBLE);

        prod_three_quantity.setVisibility(View.INVISIBLE);
        prod_three_plus.setVisibility(View.INVISIBLE);
        prod_three_minus.setVisibility(View.INVISIBLE);

        prod_four_quantity.setVisibility(View.INVISIBLE);
        prod_four_plus.setVisibility(View.INVISIBLE);
        prod_four_minus.setVisibility(View.INVISIBLE);

        prod_five_quantity.setVisibility(View.INVISIBLE);
        prod_five_plus.setVisibility(View.INVISIBLE);
        prod_five_minus.setVisibility(View.INVISIBLE);

        proceed = findViewById(R.id.proceed_button);

        prod_one_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prod_one_cart.setVisibility(View.INVISIBLE);

                prod_one_minus.setVisibility(View.VISIBLE);
                prod_one_plus.setVisibility(View.VISIBLE);
                prod_one_quantity.setVisibility(View.VISIBLE);
            }
        });


        prod_one_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quantity_of_prod_one == 0)
                {
                    quantity_of_prod_one = 0;
                }
                else
                {
                    YoYo.with(Techniques.FadeInLeft).duration(800).repeat(0).playOn(floatingActionButton);
                    quantity_of_prod_one = quantity_of_prod_one - 1;
                }
                prod_one_quantity.setText(String.valueOf(quantity_of_prod_one));
            }
        });

        prod_one_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                YoYo.with(Techniques.DropOut).duration(800).repeat(0).playOn(floatingActionButton);

                quantity_of_prod_one = quantity_of_prod_one + 1;

                prod_one_quantity.setText(String.valueOf(quantity_of_prod_one));
            }
        });

        prod_two_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prod_two_cart.setVisibility(View.INVISIBLE);

                prod_two_minus.setVisibility(View.VISIBLE);
                prod_two_plus.setVisibility(View.VISIBLE);
                prod_two_quantity.setVisibility(View.VISIBLE);
            }
        });

        prod_two_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quantity_of_prod_two == 0)
                {
                    quantity_of_prod_two = 0;
                }
                else
                {
                    YoYo.with(Techniques.FadeInLeft).duration(800).repeat(0).playOn(floatingActionButton);
                    quantity_of_prod_two = quantity_of_prod_two -1;
                }
                prod_two_quantity.setText(String.valueOf(quantity_of_prod_two));
            }
        });

        prod_two_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YoYo.with(Techniques.DropOut).duration(800).repeat(0).playOn(floatingActionButton);

                quantity_of_prod_two = quantity_of_prod_two+1;

                prod_two_quantity.setText(String.valueOf(quantity_of_prod_two));
            }
        });

        prod_three_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prod_three_cart.setVisibility(View.INVISIBLE);

                prod_three_minus.setVisibility(View.VISIBLE);
                prod_three_plus.setVisibility(View.VISIBLE);
                prod_three_quantity.setVisibility(View.VISIBLE);
            }
        });

        prod_three_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quantity_of_prod_three == 0)
                {
                    quantity_of_prod_three = 0;
                }
                else
                {
                    YoYo.with(Techniques.FadeInLeft).duration(800).repeat(0).playOn(floatingActionButton);
                    quantity_of_prod_three = quantity_of_prod_three -1;
                }
                prod_three_quantity.setText(String.valueOf(quantity_of_prod_three));
            }
        });

        prod_three_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YoYo.with(Techniques.DropOut).duration(800).repeat(0).playOn(floatingActionButton);
                quantity_of_prod_three = quantity_of_prod_three+1;

                prod_three_quantity.setText(String.valueOf(quantity_of_prod_three));
            }
        });

        prod_four_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prod_four_cart.setVisibility(View.INVISIBLE);

                prod_four_minus.setVisibility(View.VISIBLE);
                prod_four_plus.setVisibility(View.VISIBLE);
                prod_four_quantity.setVisibility(View.VISIBLE);
            }
        });

        prod_four_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quantity_of_prod_four == 0)
                {
                    quantity_of_prod_four = 0;
                }
                else
                {
                    YoYo.with(Techniques.FadeInLeft).duration(800).repeat(0).playOn(floatingActionButton);
                    quantity_of_prod_four = quantity_of_prod_four -1;
                }
                prod_four_quantity.setText(String.valueOf(quantity_of_prod_four));
            }
        });

        prod_four_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YoYo.with(Techniques.DropOut).duration(800).repeat(0).playOn(floatingActionButton);
                quantity_of_prod_four = quantity_of_prod_four+1;

                prod_four_quantity.setText(String.valueOf(quantity_of_prod_four));
            }
        });

        prod_five_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prod_five_cart.setVisibility(View.INVISIBLE);

                prod_five_minus.setVisibility(View.VISIBLE);
                prod_five_plus.setVisibility(View.VISIBLE);
                prod_five_quantity.setVisibility(View.VISIBLE);
            }
        });

        prod_five_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quantity_of_prod_five == 0)
                {
                    quantity_of_prod_five = 0;
                }
                else
                {
                    YoYo.with(Techniques.FadeInLeft).duration(800).repeat(0).playOn(floatingActionButton);
                    quantity_of_prod_five = quantity_of_prod_five -1;
                }
                prod_five_quantity.setText(String.valueOf(quantity_of_prod_five));
            }
        });

        prod_five_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YoYo.with(Techniques.DropOut).duration(800).repeat(0).playOn(floatingActionButton);
                quantity_of_prod_five = quantity_of_prod_five+1;

                prod_five_quantity.setText(String.valueOf(quantity_of_prod_five));
            }
        });

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quantity_of_prod_one == 0 && quantity_of_prod_two == 0 && quantity_of_prod_three == 0 && quantity_of_prod_four == 0 && quantity_of_prod_five == 0)
                {
                    proceed.setError("NO ITEM SELECTED");
                    Toast.makeText(JewelryActivity.this, "No Item is Selected.", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String s1 = String.valueOf(quantity_of_prod_one);
                    String s2 = String.valueOf(quantity_of_prod_two);
                    String s3 = String.valueOf(quantity_of_prod_three);
                    String s4 = String.valueOf(quantity_of_prod_four);
                    String s5 = String.valueOf(quantity_of_prod_five);

                    Intent intent = new Intent(JewelryActivity.this, CartActivity.class);
                    intent.putExtra("key_one", s1);
                    intent.putExtra("key_two", s2);
                    intent.putExtra("key_three", s3);
                    intent.putExtra("key_four", s4);
                    intent.putExtra("key_five", s5);
                    startActivity(intent);
                }
            }
        });


        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quantity_of_prod_one == 0 && quantity_of_prod_two == 0 && quantity_of_prod_three == 0 && quantity_of_prod_four == 0 && quantity_of_prod_five == 0)
                {
                    proceed.setError("NO ITEM SELECTED");
                    Toast.makeText(JewelryActivity.this, "No Item is Selected.", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String s1 = String.valueOf(quantity_of_prod_one);
                    String s2 = String.valueOf(quantity_of_prod_two);
                    String s3 = String.valueOf(quantity_of_prod_three);
                    String s4 = String.valueOf(quantity_of_prod_four);
                    String s5 = String.valueOf(quantity_of_prod_five);

                    Intent intent = new Intent(JewelryActivity.this, JewelryOrderActivity.class);
                    intent.putExtra("key_one", s1);
                    intent.putExtra("key_two", s2);
                    intent.putExtra("key_three", s3);
                    intent.putExtra("key_four", s4);
                    intent.putExtra("key_five", s5);
                    startActivity(intent);
                }
            }
        });
    }
}