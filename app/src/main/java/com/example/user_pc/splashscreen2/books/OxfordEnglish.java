package com.example.user_pc.splashscreen2.books;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.example.user_pc.splashscreen2.R;

public class OxfordEnglish extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oxford_english);
    }

    public void downloadPdf(View view) {
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
}
