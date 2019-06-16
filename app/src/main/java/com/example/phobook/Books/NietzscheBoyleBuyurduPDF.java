package com.example.phobook.Books;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.phobook.R;
import com.github.barteksc.pdfviewer.PDFView;

public class NietzscheBoyleBuyurduPDF extends AppCompatActivity {

    PDFView boylebuyurdu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nietzsche_boyle_buyurdu_pdf);

        boylebuyurdu = (PDFView) findViewById(R.id.boylebuyurdupdf);
        boylebuyurdu.fromAsset("boylebuyurduzerdust.pdf").load();
    }
}
