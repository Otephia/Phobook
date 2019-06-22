package com.example.phobook;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private Button register;
    private EditText emailR;
    private EditText passwordR;
    private TextView signIn;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        firebaseAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(this);
        register = (Button)findViewById(R.id.register);
        emailR = (EditText) findViewById(R.id.emailR);
        passwordR = (EditText)findViewById(R.id.passwordR);
        signIn = (TextView) findViewById(R.id.loginback);

        register.setOnClickListener(this);
        signIn.setOnClickListener(this);


    }

    @Override
    protected void onStart() {
        super.onStart();

        if (firebaseAuth.getCurrentUser() != null){

        }
    }

    public void registerUser(){

        final String email = emailR.getText().toString().trim();
        final String password  = passwordR.getText().toString().trim();

        if (TextUtils.isEmpty(email)){
            Toast.makeText(this, "E-mail Boş Bırakılamaz",Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(password)){
            Toast.makeText(this, "Şifre Boş Bırakılamaz",Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("Kayıt Ediliyor...");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            
                            progressDialog.dismiss();
                            Toast.makeText(RegisterActivity.this, "Kayıt Başarılı!", Toast.LENGTH_SHORT).show();

                            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));

                        }else {
                            progressDialog.dismiss();
                            Toast.makeText(RegisterActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    }
                });

    }

    @Override
    public void onClick(View v) {
        if (v == register){
            registerUser();
        }

        if (v == signIn){
            Intent intnt = new Intent(RegisterActivity.this,LoginActivity.class);
            startActivity(intnt);
        }

    }
}
