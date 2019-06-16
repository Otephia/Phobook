package com.example.phobook.Books;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.phobook.R;

public class KafkaDonusumActivity extends AppCompatActivity {

    MediaPlayer donusum;
    Button baslat,durdur,pdfbtn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kafka_donusum);

        donusum = MediaPlayer.create(KafkaDonusumActivity.this, R.raw.bertolt1);

        baslat = (Button) findViewById(R.id.buttonbaslat1);
        durdur = (Button) findViewById(R.id.buttondurdur1);
        pdfbtn1 = (Button) findViewById(R.id.pdfbtn1);

        pdfbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(KafkaDonusumActivity.this, KafkaDonusumPDF.class);
                startActivity(i);
            }
        });
        baslat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                donusum.start();
            }
        });

        durdur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                donusum.pause();
            }
        });
    }
}
