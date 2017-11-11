package com.example.user_pc.splashscreen2.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.user_pc.splashscreen2.R;

public class Wishlist extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wishlist);

    }

//        Intent myIntent = getIntent(); // this is just for example purpose
//        myIntent.getExtra("bookname" +);

    TextView showData = (TextView) findViewById(R.id.wishBook1);
    Intent myIntent = getIntent(); // this is just for example purpose



}
