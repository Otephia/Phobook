package com.example.phobook.Books;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.phobook.R;
import com.github.barteksc.pdfviewer.PDFView;

public class StefanSatrancPDF extends AppCompatActivity {

    PDFView satranc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stefan_satranc_pdf);


        satranc = (PDFView) findViewById(R.id.satrancpdf);
        satranc.fromAsset("satranc.pdf").load();
    }
}
