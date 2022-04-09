package com.example.seekdiscomfort;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CartActivity extends AppCompatActivity {

    TextView textview_name_one, textview_name_two, textview_name_three, textview_name_four,textview_name_five,textview_name_six,textview_name_seven,textview_name_eight,
            textview_quantity_one,textview_quantity_two,textview_quantity_three,textview_quantity_four,textview_quantity_five,textview_quantity_six,textview_quantity_seven,textview_quantity_eight,
            textview_price_one, textview_price_two, textview_price_three, textview_price_four,textview_total_price,textview_price_five,textview_price_six,textview_price_seven;
    Button order_now, minus_one, minus_two, minus_three, minus_four, minus_five, plus_one, plus_two, plus_three, plus_four, plus_five;

    int one =0, two =0, three =0, four =0, five =0;
    double price_one =0.0, price_two =0.0, price_three =0.0, price_four =0.0, price_five =0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        textview_name_one = findViewById(R.id.text_one_layout_two);
        textview_name_two = findViewById(R.id.text_one_layout_three);
        textview_name_three = findViewById(R.id.text_one_layout_four);
        textview_name_four = findViewById(R.id.text_one_layout_five);
        textview_name_five = findViewById(R.id.text_one_layout_six);

        textview_quantity_one = findViewById(R.id.quantity_layout_two);
        textview_quantity_two = findViewById(R.id.quantity_layout_three);
        textview_quantity_three = findViewById(R.id.quantity_layout_four);
        textview_quantity_four = findViewById(R.id.quantity_layout_five);
        textview_quantity_five = findViewById(R.id.quantity_layout_six);

        textview_price_one = findViewById(R.id.price_layout_two);
        textview_price_two = findViewById(R.id.price_layout_three);
        textview_price_three = findViewById(R.id.price_layout_four);
        textview_price_four = findViewById(R.id.price_layout_five);
        textview_price_five = findViewById(R.id.price_layout_six);

        order_now = findViewById(R.id.order_now_button);

        minus_one = findViewById(R.id.minus_button_layout_two);
        minus_two = findViewById(R.id.minus_button_layout_three);
        minus_three = findViewById(R.id.minus_button_layout_four);
        minus_four = findViewById(R.id.minus_button_layout_five);
        minus_five = findViewById(R.id.minus_button_layout_six);

        plus_one = findViewById(R.id.plus_button_layout_two);
        plus_two = findViewById(R.id.plus_button_layout_three);
        plus_three = findViewById(R.id.plus_button_layout_four);
        plus_four = findViewById(R.id.plus_button_layout_five);
        plus_five = findViewById(R.id.plus_button_layout_six);

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

        Double sub_total = 0.0, price = 0.0;


        one = i1;
        if (i1 != 0)
        {
            price = i1*1200.0;

            textview_name_one.setText("Seek Discomfort Ring");
            textview_quantity_one.setText(String.valueOf(i1));
            textview_price_one.setText(String.valueOf(price));

            minus_one.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (one == 0)
                    {
                        one = 0;
                    }
                    else
                    {
                        one = one -1;
                        textview_quantity_one.setText(String.valueOf(one));
                        price_one = one*1200.0;
                        textview_price_one.setText(String.valueOf(price_one));
                    }
                }
            });
            plus_one.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    one = one +1;
                    textview_quantity_one.setText(String.valueOf(one));
                    price_one = one*1200.0;
                    textview_price_one.setText(String.valueOf(price_one));
                }
            });
            price = one*1200.0;
            sub_total = sub_total + price;

            price =0.0;
        }
        else
        {
            minus_one.setVisibility(View.INVISIBLE);
            plus_one.setVisibility(View.INVISIBLE);
        }

        two = i2;
        if (i2 != 0)
        {
            price = i2*500.0;

            textview_name_two.setText("Rope Bracelet");
            textview_quantity_two.setText(String.valueOf(i2));
            textview_price_two.setText(String.valueOf(price));

            minus_two.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (two == 0)
                    {
                        two = 0;
                    }
                    else
                    {
                        two = two -1;
                        textview_quantity_two.setText(String.valueOf(two));
                        price_two = two*500.0;
                        textview_price_two.setText(String.valueOf(price_two));
                    }
                }
            });
            plus_two.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    two = two +1;
                    textview_quantity_two.setText(String.valueOf(two));
                    price_two = two*500.0;
                    textview_price_two.setText(String.valueOf(price_two));
                }
            });
            price = two*500.0;
            sub_total = sub_total + price;

            price =0.0;
        }
        else
        {
            minus_two.setVisibility(View.INVISIBLE);
            plus_two.setVisibility(View.INVISIBLE);
        }
        three = i3;
        if (i3!=0)
        {
            price = i3*700.0;
            textview_name_three.setText("Extra Necklace Chain");
            textview_quantity_three.setText(String.valueOf(i3));
            textview_price_three.setText(String.valueOf(price));

            minus_three.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (three == 0)
                    {
                        three = 0;
                    }
                    else
                    {
                        three = three -1;
                        textview_quantity_three.setText(String.valueOf(three));
                        price_three = three*700.0;
                        textview_price_three.setText(String.valueOf(price_three));
                    }
                }
            });
            plus_three.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    three = three +1;
                    textview_quantity_three.setText(String.valueOf(three));
                    price_three = three*700.0;
                    textview_price_three.setText(String.valueOf(price_three));
                }
            });
            price = three*700.0;
            sub_total = sub_total + price;

            price =0.0;
        }
        else
        {
            minus_three.setVisibility(View.INVISIBLE);
            plus_three.setVisibility(View.INVISIBLE);
        }
        four = i4;
        if (i4!=0)
        {
            price = i4*1000.0;
            sub_total = sub_total+price;

            textview_name_four.setText("Love Over Fear Ring");
            textview_quantity_four.setText(String.valueOf(i4));
            textview_price_four.setText(String.valueOf(price));

            minus_four.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (four == 0)
                    {
                        four = 0;
                    }
                    else
                    {
                        four = four -1;
                        textview_quantity_four.setText(String.valueOf(four));
                        price_four = four*1000.0;
                        textview_price_four.setText(String.valueOf(price_four));
                    }
                }
            });
            plus_four.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    four = four +1;
                    textview_quantity_four.setText(String.valueOf(four));
                    price_four = four*1000.0;
                    textview_price_four.setText(String.valueOf(price_four));
                }
            });
            price = four*1000.0;
            sub_total = sub_total + price;

            price =0.0;
        }
        else
        {
            minus_four.setVisibility(View.INVISIBLE);
            plus_four.setVisibility(View.INVISIBLE);
        }
        five = i5;
        if (i5!=0)
        {
            price = i5*900.0;
            sub_total = sub_total+price;

            textview_name_five.setText("Mantra Necklace");
            textview_quantity_five.setText(String.valueOf(i5));
            textview_price_five.setText(String.valueOf(price));

            minus_five.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (five == 0)
                    {
                        five = 0;
                    }
                    else
                    {
                        five = five -1;
                        textview_quantity_five.setText(String.valueOf(five));
                        price_five = five*900.0;
                        textview_price_five.setText(String.valueOf(price_five));
                    }
                }
            });
            plus_five.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    five = five +1;
                    textview_quantity_five.setText(String.valueOf(five));
                    price_five = five*900.0;
                    textview_price_five.setText(String.valueOf(price_five));
                }
            });
            price = five*900.0;
            sub_total = sub_total + price;

            price =0.0;
        }
        else
        {
            minus_five.setVisibility(View.INVISIBLE);
            plus_five.setVisibility(View.INVISIBLE);
        }


        order_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = String.valueOf(one);
                String s2 = String.valueOf(two);
                String s3 = String.valueOf(three);
                String s4 = String.valueOf(four);
                String s5 = String.valueOf(five);

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