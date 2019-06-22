package com.example.phobook.Books;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.phobook.R;
import com.github.barteksc.pdfviewer.PDFView;

public class NietzscheBoyleBuyurduActivity extends AppCompatActivity {


    MediaPlayer boylebuyurdu;
    Button baslat,durdur,pdfbtn,add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nietzsche_boyle_buyurdu);

        boylebuyurdu = MediaPlayer.create(NietzscheBoyleBuyurduActivity.this, R.raw.bertolt1);

        baslat = (Button) findViewById(R.id.buttonbaslat);
        durdur = (Button) findViewById(R.id.buttondurdur);
        pdfbtn = (Button) findViewById(R.id.pdfbtn);
        add = (Button) findViewById(R.id.addList);

        pdfbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NietzscheBoyleBuyurduActivity.this, NietzscheBoyleBuyurduPDF.class);
                startActivity(intent);
            }
        });

        baslat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boylebuyurdu.start();
            }
        });

        durdur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boylebuyurdu.pause();
            }
        });

    }

}
