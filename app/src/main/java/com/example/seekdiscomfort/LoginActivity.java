package com.example.seekdiscomfort;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.jetbrains.annotations.NotNull;

public class LoginActivity extends AppCompatActivity {
    TextView reg_link, admin_link;
    EditText email, password;
    Button login_button;
    FirebaseAuth mAuth;
    ProgressDialog loadingbar;
    int count;
    CheckBox remember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        reg_link = findViewById(R.id.register_link);
        email = findViewById(R.id.email_text_login);
        password = findViewById(R.id.password_text_login);
        login_button = findViewById(R.id.login_button);
        mAuth = FirebaseAuth.getInstance();
        loadingbar = new ProgressDialog(this);
        count = 0;
        admin_link = findViewById(R.id.hudatext);

        FirebaseUser currentUser = mAuth.getCurrentUser();

        if (currentUser != null)
        {
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
        }

        remember = findViewById(R.id.rememberme);


        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingbar.setMessage("Please wait while we're checking....");
                loadingbar.setTitle("Logging In");
                loadingbar.setCanceledOnTouchOutside(false);
                loadingbar.show();
                LoginUser();
            }
        });


        reg_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, RegistationActivity.class);
                startActivity(i);
            }
        });

        admin_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;

                if (count == 5)
                {
                    Toast.makeText(getApplicationContext(), "You are 2 click away to Admin Mode", Toast.LENGTH_SHORT).show();
                }
                if (count == 6)
                {
                    Toast.makeText(getApplicationContext(), "You are 1 click away to Admin Mode", Toast.LENGTH_SHORT).show();
                }
                if (count == 7)
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                    builder.setCancelable(false);
                    builder.setTitle("Are you Sure??");
                    builder.setMessage("You want to go to Admin Mode??!!");

                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });

                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(LoginActivity.this, AdminLogin.class);
                            startActivity(intent);
                        }
                    });
                    builder.show();
                    count=0;
                }
            }
        });
    }

    private void LoginUser() {
        String user_password, user_email;
        user_password = password.getText().toString();
        user_email = email.getText().toString();

        if (TextUtils.isEmpty(user_email)){
            email.setError("Email cannot be empty");
            email.requestFocus();
            loadingbar.dismiss();
        }
        else if (TextUtils.isEmpty(user_password)){
            password.setError("Password cannot be empty");
            password.requestFocus();
            loadingbar.dismiss();
        }
        else{

            mAuth.signInWithEmailAndPassword(user_email, user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                    if(task.isSuccessful())
                    {
                        Toast.makeText(LoginActivity.this, "Logged in Succesfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        loadingbar.dismiss();
                    }
                    else
                    {
                        Toast.makeText(LoginActivity.this, "Login Failed." + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        loadingbar.dismiss();
                    }
                }
            });
        }
        loadingbar.dismiss();
    }
}