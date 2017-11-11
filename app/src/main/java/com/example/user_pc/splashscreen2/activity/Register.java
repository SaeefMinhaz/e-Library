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

/**
 * Created by USER-pC on 04/29/17.
 */

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        final EditText userName = (EditText) findViewById(R.id.etNewName);
        final EditText password = (EditText) findViewById(R.id.etNewPassword);
//        final EditText email = (EditText) findViewById(R.id.etNewEmail);
        Button btnRegister = (Button) findViewById(R.id.btnNewRegister);

        btnRegister.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);
                String newUser  = userName.getText().toString();
                String newPassword = password.getText().toString();
//                String newEmail = email.getText().toString();

                SharedPreferences.Editor editor = preferences.edit();

//                editor.putString(newUser + newPassword + "data", newUser + "\n" + newEmail);
//                editor.commit();
//


                editor.putString(newUser,newUser);
                editor.commit();
                editor.putString(newPassword, newPassword);
                editor.commit();

                Toast.makeText(Register.this, "Congratulations!", Toast.LENGTH_LONG).show();
//                editor.putString(newUser + newPassword + "data", newUser + "\n" + newEmail);
//                editor.commit();

                Intent LoginScreen = new Intent(Register.this, LoginActivity.class);
                startActivity(LoginScreen);

            }
        });

    }
}
