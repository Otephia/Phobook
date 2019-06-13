package com.example.phobook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String EXTRA_NUMBER = "com.example.application.example.EXTRA_NUMBER";
    public static final String EXTRA_TEXT = "com.example.application.example.EXTRA_TEXT";

    EditText editText1,editText2;
    Button button,button2;
    DatabaseOpenHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        myDb = new DatabaseOpenHelper(getApplicationContext());


        button = (Button) findViewById(R.id.button1);
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText)findViewById(R.id.editText2);
        button2 = findViewById(R.id.button2);

        button.setOnClickListener(this);
        button2.setOnClickListener(this);

    }

    public void openActivity2(){

        String text = editText1.getText().toString();
        int number = Integer.parseInt(editText2.getText().toString());

        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
        intent.putExtra(EXTRA_TEXT, text);
        intent.putExtra(EXTRA_NUMBER,number);
        startActivity(intent);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.button1:
                login();
                break;
            case R.id.button2:
                register();
                break;
        }
    }


    private void login(){
        String email= String.valueOf(editText1.getText());
        String password= String.valueOf(editText2.getText());

        if (editText1.length()==0){
            editText1.setError("Boş Giriş Yapılamaz!");
        }
        else if (editText2.length()==0){
            editText2.setError("Boş Giriş Yapılamaz!");
        }
        else {

            Toast.makeText(getApplicationContext(),"Kullanıcı Bulunamadı! Lütfen Girdiğiniz Bilgilerle Kayıt Olmak İçin Kayıt Ol'a Tıklayın!",Toast.LENGTH_LONG).show();

            List<User> userList =  myDb.getAllUsers();

            for(User user : userList){
                if(user.getEmail().equals(email) && user.getPassword().equals(password)){
                    Toast.makeText(getApplicationContext()," Giriş Başarılı",Toast.LENGTH_LONG).show();
                    openActivity2();

                }

            }
        }




    }

    private void register(){
        String email = String.valueOf(editText1.getText());
        String password = String.valueOf(editText2.getText());

        User newUser = new User(email,password);

        myDb.addUser(newUser);

        Toast.makeText(getApplicationContext(),"Kayıt Oldunuz! Tekrar Giriş Yap'a Tıklayın!",Toast.LENGTH_LONG).show();
    }
}
