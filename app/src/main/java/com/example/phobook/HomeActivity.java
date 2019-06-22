package com.example.phobook;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomeActivity extends AppCompatActivity implements ListFrag.GondorListener, View.OnClickListener {

    TextView tvDetails;
    private FirebaseAuth firebaseAuth;
    private TextView textViewUserMail;
    private Button logout;
    private Button books;
    private Button booklist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();
        tvDetails = (TextView) findViewById(R.id.tvDetails);
        textViewUserMail = (TextView) findViewById(R.id.textViewUserMail);
        textViewUserMail.setText("Hoşgeldin: " + user.getEmail() );
        logout = (Button) findViewById(R.id.cikis);
        books = (Button) findViewById(R.id.buttonbooks);
        booklist = (Button) findViewById(R.id.buttonlist);

        books.setOnClickListener(this);
        booklist.setOnClickListener(this);
        logout.setOnClickListener(this);

    }

    @Override
    public void onCitySelected(int index) {

        String [] content = getResources().getStringArray(R.array.content);
        tvDetails.setText(content[index]);


    }

    @Override
    public void onClick(View v) {
        if (v == logout){

            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(getApplicationContext(),LoginActivity.class));
            Toast.makeText(HomeActivity.this, "Çıkış Başarılı", Toast.LENGTH_SHORT).show();
        }

        if (v == booklist){

            startActivity(new Intent(getApplicationContext(),BookListActivity.class));

        }

        if (v == books){

            startActivity(new Intent(getApplicationContext(),BooksActivity.class));

        }

    }
}
