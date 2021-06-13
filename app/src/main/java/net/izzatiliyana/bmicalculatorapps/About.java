package net.izzatiliyana.bmicalculatorapps;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class About extends AppCompatActivity {

    android.widget.Button mrecalculatebmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        mrecalculatebmi=findViewById(R.id.recalculatebmi);

        mrecalculatebmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(About.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });



    }
}