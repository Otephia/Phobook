package com.example.phobook.Books;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.phobook.R;
import com.github.barteksc.pdfviewer.PDFView;

public class KafkaDonusumPDF extends AppCompatActivity {


    PDFView donusum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kafka_donusum_pdf);



        donusum = (PDFView) findViewById(R.id.donusumpdf);
        donusum.fromAsset("donusum.pdf").load();
    }
}
