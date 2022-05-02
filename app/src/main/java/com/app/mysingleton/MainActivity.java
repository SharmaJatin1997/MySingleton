package com.app.mysingleton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.app.mysingleton.Utils.App;

public class MainActivity extends AppCompatActivity {

    private EditText user_email, user_password;
    private Button btnLogin1;
    private String email2, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogin1 = findViewById(R.id.btnLogin1);
        user_email = findViewById(R.id.user_email);
        user_password = findViewById(R.id.user_password);
    }

    public void onClickLogin(View view) {
        email2 = user_email.getText().toString();
        pass = user_password.getText().toString();
        if (email2.isEmpty()) {
            user_email.setError("please enter the email");
            user_email.requestFocus();
        } else if (pass.isEmpty()) {
            user_password.setError("please enter the password");
            user_password.requestFocus();
        } else {
            App.getSingleton().setData(email2);
            Intent send = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(send);
        }
    }
}