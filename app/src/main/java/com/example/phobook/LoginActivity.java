package com.example.phobook;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.List;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnRegister;
    private Button btnLogin;
    private EditText textEmail;
    private EditText textPassword;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();


        btnRegister = (Button)findViewById(R.id.button2);
        btnLogin = (Button) findViewById(R.id.button1);
        textEmail = (EditText) findViewById(R.id.editText1);
        textPassword = (EditText) findViewById(R.id.editText2);

        progressDialog = new ProgressDialog(this);
        btnLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);

    }

    private void userLogin(){

        String email = textEmail.getText().toString().trim();
        String password = textPassword.getText().toString().trim();

        if (TextUtils.isEmpty(email)){
            Toast.makeText(this, "E-mail Boş Bırakılamaz",Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(password)){
            Toast.makeText(this, "Şifre Boş Bırakılamaz",Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("Giriş Yapılıyor..");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            progressDialog.dismiss();
                            startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                            Toast.makeText(LoginActivity.this, "Giriş Başarılı", Toast.LENGTH_SHORT).show();

                        }else{
                            progressDialog.dismiss();
                            Toast.makeText(LoginActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }
                });


    }


    @Override
    public void onClick(View v) {

        if (v == btnLogin){
            userLogin();

        }

        if (v == btnRegister){

            Intent i = new Intent(LoginActivity.this,RegisterActivity.class);
            startActivity(i);

        }
    }
}