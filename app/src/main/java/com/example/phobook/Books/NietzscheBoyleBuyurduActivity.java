package com.example.phobook.Books;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.phobook.R;

public class NietzscheBoyleBuyurduActivity extends AppCompatActivity {


    MediaPlayer boylebuyurdu;
    Button baslat,durdur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nietzsche_boyle_buyurdu);

        boylebuyurdu = MediaPlayer.create(NietzscheBoyleBuyurduActivity.this, R.raw.bertolt1);

        baslat = (Button) findViewById(R.id.buttonbaslat);
        durdur = (Button) findViewById(R.id.buttondurdur);

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
