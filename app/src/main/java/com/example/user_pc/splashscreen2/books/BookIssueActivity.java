package com.example.user_pc.splashscreen2.books;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.example.user_pc.splashscreen2.R;
import com.example.user_pc.splashscreen2.activity.Wishlist;

public class BookIssueActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_issue);
    }

    public void download(View view) {
        startDownload();
    }

    private void startDownload() {
        DownloadManager mManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        DownloadManager.Request mRqRequest = new DownloadManager.Request(
                Uri.parse("https://www.dropbox.com/s/6j7fmnajtj0f2vp/_Halliday-Resnick-Walker__-_Fundamentals_of_Physics.pdf?dl=1"));
        mRqRequest.setDescription("This is Test File");
//  mRqRequest.setDestinationUri(Uri.parse("give your local path"));
        long idDownLoad=mManager.enqueue(mRqRequest);
    }

    public void wishlist1(View view) {
        // 1. create an intent pass class name or intnet action name
        Intent intent = new Intent("com.example.user_pc.splashscreen2.activity.Wishlist");

        // 2. put key/value data
        intent.putExtra("bookname", "book1");

//        // 3. or you can add data to a bundle
//        Bundle extras = new Bundle();
//        extras.putString("status", "Data Received!");

//        // 4. add bundle to intent
//        intent.putExtras(extras);

        // 5. start the activity
        startActivity(intent);
    }
}
