package com.example.phobook;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity implements ListFrag.GondorListener{

    TextView tvDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tvDetails = (TextView) findViewById(R.id.tvDetails);

        Intent intent = getIntent();
        String text = ((Intent) intent).getStringExtra(LoginActivity.EXTRA_TEXT);
        int number = intent.getIntExtra(LoginActivity.EXTRA_NUMBER,0);

        TextView textView1 = (TextView) findViewById(R.id.textView1);
        TextView textView2 = (TextView) findViewById(R.id.textView2);

        textView1.setText("Hoşgeldin: " + text + " - ");
        textView2.setText("Şifre: " +  "**" + number);
    }

    @Override
    public void onCitySelected(int index) {

        String [] content = getResources().getStringArray(R.array.content);
        tvDetails.setText(content[index]);


    }

    public void kitaplar(View view) {
        Intent intent = new Intent(this,BooksActivity.class);
        startActivity(intent);
    }
}
