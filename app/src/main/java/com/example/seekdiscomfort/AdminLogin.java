package com.example.seekdiscomfort;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLogin extends AppCompatActivity {

    EditText email, password;
    Button login_button;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        email = findViewById(R.id.admin_email_field);
        password = findViewById(R.id.admin_password_field);
        login_button = findViewById(R.id.admin_login_button);
        count =0;

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                String admin_email, admin_pass;

                admin_email = email.getText().toString();
                admin_pass = password.getText().toString();

                if (admin_email.equals("admin") && admin_pass.equals("14315229"))
                {
                    Intent intent = new Intent(AdminLogin.this, AdminPanelActivity.class);
                    startActivity(intent);
                }
                else
                {
                    if (count==3)
                    {
                        Toast.makeText(AdminLogin.this, "Maximum Limit Reached.\nYou are Terminated.", Toast.LENGTH_SHORT).show();
                        count =0;
                        Intent intent = new Intent(AdminLogin.this, LoginActivity.class);
                        startActivity(intent);
                    }
                    else
                        Toast.makeText(AdminLogin.this, "Wrong Information Provided.", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}