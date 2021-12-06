package com.example.td4_activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(getLocalClassName());
        final EditText username=(EditText) findViewById(R.id.login);
       final EditText password=(EditText) findViewById(R.id.pwd);
       Button login=(Button) findViewById(R.id.btn);
        final NewsListApplication app = (NewsListApplication) getApplicationContext();



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(username.getText().toString().equals("wiam") && password.getText().toString().equals("1234")){
                    Intent intent=new Intent(LoginActivity.this,NewsActivity.class);
                    app.setLogin(username.getText().toString());
                    //intent.putExtra("login",username.getText().toString());
                    startActivity(intent);
                    finish();
                }else{
                    Toast toast=Toast.makeText(LoginActivity.this,"Login ou mot de passe incorrects",Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
    }

    @Override
    public void onBackPressed(){
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
    }
}
