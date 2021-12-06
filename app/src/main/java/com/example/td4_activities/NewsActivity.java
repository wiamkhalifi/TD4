package com.example.td4_activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        setTitle(getLocalClassName());
       Button logout=(Button) findViewById(R.id.logout);
       Button details=(Button) findViewById(R.id.details);
       Button about=(Button) findViewById(R.id.about);
        final TextView username=(TextView) findViewById(R.id.textView);
        final NewsListApplication app = (NewsListApplication) getApplicationContext();
        username.setText(app.getLogin());

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(NewsActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
        details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(NewsActivity.this,DetailsActivity.class);
                intent.putExtra("login",username.getText().toString());
                startActivity(intent);
                finish();
            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url="https://news.google.com/";
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
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
