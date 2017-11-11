package com.example.user_pc.splashscreen2.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.user_pc.splashscreen2.R;

/**
 * Created by USER-pC on 04/29/17.
 */

public class DisplayScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_info);



        SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);
        String display = preferences.getString("display", "");



        final Button eceBtn = (Button) findViewById(R.id.btnece);
        eceBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(getApplicationContext(),SemesterTabActivity.class);
                startActivity(i);
                finish();
            }
        });


        final Button wishList = (Button) findViewById(R.id.wishlist);
        wishList.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(getApplicationContext(),Wishlist.class);
                startActivity(i);
                finish();
            }
        });

        final Button issueBook = (Button) findViewById(R.id.issued_books);
        issueBook.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(getApplicationContext(),IssuedBooks.class);
                startActivity(i);
                finish();
            }
        });


//
//
//        final Button cseBtn = (Button) findViewById(R.id.btncse);
//        cseBtn.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View v){
//                Intent i = new Intent(getApplicationContext(),SemesterTabActivity.class);
//                startActivity(i);
//                finish();
//            }
//        });
//
//        final Button bbaBtn = (Button) findViewById(R.id.btnbba);
//        bbaBtn.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View v){
//                Intent i = new Intent(getApplicationContext(),SemesterTabActivity.class);
//                startActivity(i);
//                finish();
//            }
//        });

    }


}
