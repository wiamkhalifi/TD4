package com.example.td4_activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Button ok=(Button) findViewById(R.id.ok);
        TextView txt=(TextView)findViewById(R.id.textt);
        Intent intent = getIntent();
        if (intent != null){
            String str = "";
            if (intent.hasExtra("login")){
                str = intent.getStringExtra("login");
            }
            txt.setText(str);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DetailsActivity.this,NewsActivity.class);
                startActivity(intent);
                finish();
               }
        });
    }
    }

     @Override
    public void onBackPressed(){
        Intent a = new Intent(DetailsActivity.this,NewsActivity.class);
      //  a.addCategory(Intent.CATEGORY_HOME);
       // a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
    }
}
