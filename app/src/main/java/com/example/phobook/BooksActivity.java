package com.example.phobook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.example.phobook.Books.KafkaDonusumActivity;
import com.example.phobook.Books.NietzscheBoyleBuyurduActivity;
import com.example.phobook.Books.StefanSatrancActivity;

public class BooksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);
    }

    public void satranc(View view) {
        Intent intent = new Intent(this, StefanSatrancActivity.class);
        startActivity(intent);
    }

    public void donusum(View view) {
        Intent intent = new Intent(this, KafkaDonusumActivity.class);
        startActivity(intent);
    }

    public void boylebuyurduzerdust(View view) {
        Intent intent = new Intent(this, NietzscheBoyleBuyurduActivity.class);
        startActivity(intent);
    }
}
