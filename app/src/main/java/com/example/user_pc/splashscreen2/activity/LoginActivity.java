package com.example.user_pc.splashscreen2.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user_pc.splashscreen2.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Intent intent = getIntent();
        setContentView(R.layout.activity_login);

        final EditText etName = (EditText) findViewById(R.id.etName);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        Button btnLogin = (Button) findViewById(R.id.btnLogin);
        Button btnRegister = (Button) findViewById(R.id.btnRegister);

        btnLogin.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String user = etName.getText().toString();
                String password = etPassword.getText().toString();
                SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);

                if (user.equalsIgnoreCase("")) {
                    Toast.makeText(LoginActivity.this, "Please input user name", Toast.LENGTH_LONG).show();
                    return;
                } else if (password.equalsIgnoreCase("")) {
                    Toast.makeText(LoginActivity.this, "Please input password", Toast.LENGTH_LONG).show();
                    return;
                } else {
                    String userDetails = preferences.getString(user + password + "data","No information on that user.");
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("display",userDetails);
                    editor.commit();

//                     SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);
//                    String display = preferences.getString("display", "");
//                    Toast.makeText(LoginActivity.this, ""+display, Toast.LENGTH_LONG).show();
                    Intent displayScreen = new Intent(LoginActivity.this, DisplayScreen.class);
                    startActivity(displayScreen);
                }

//                LoginActivity.this.finish();

            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerScreen = new Intent(LoginActivity.this, Register.class);
                startActivity(registerScreen);
            }
        });
    }
}
