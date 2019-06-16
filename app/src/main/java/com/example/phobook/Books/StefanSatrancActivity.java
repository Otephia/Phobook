package com.example.phobook.Books;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.phobook.R;

public class StefanSatrancActivity extends AppCompatActivity {
    MediaPlayer satranc;
    Button baslat,durdur,pdfbtn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stefan_satranc);

        satranc = MediaPlayer.create(StefanSatrancActivity.this, R.raw.bertolt1);

        baslat = (Button) findViewById(R.id.buttonbaslat2);
        durdur = (Button) findViewById(R.id.buttondurdur2);
        pdfbtn2 = (Button) findViewById(R.id.pdfbtn2);

        pdfbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StefanSatrancActivity.this, StefanSatrancPDF.class);
                startActivity(intent);
            }
        });

        baslat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                satranc.start();
            }
        });

        durdur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                satranc.pause();
            }

    });
}

}

