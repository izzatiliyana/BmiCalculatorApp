package net.izzatiliyana.bmicalculatorapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class bmiactivity extends AppCompatActivity {

    android.widget.Button mrecalculatebmi;

    TextView mbmidisplay,mbmicategory,mgender,mhealthrisk, mrange;
    Intent intent;
    ImageView mimageview;
    String mbmi;
    Float intbmi;

    String height;
    String weight;
    float intheight,intweight;
    RelativeLayout mbackground;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmiactivity);

        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"white\"></font"));
        getSupportActionBar().setTitle("Result");
        ColorDrawable colorDrawable=new ColorDrawable(Color.parseColor("#1E1D1D"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);

        intent=getIntent();

        mbmidisplay=findViewById(R.id.bmidisplay);
        mbmicategory=findViewById(R.id.bmicategory);
        mrange=findViewById(R.id.range);
        mhealthrisk=findViewById(R.id.healthrisk);
        mgender=findViewById(R.id.genderdisplay);
        mbackground=findViewById(R.id.contentlayout);
        mimageview=findViewById(R.id.imageview);
        mrecalculatebmi=findViewById(R.id.recalculatebmi);

        height=intent.getStringExtra("height");
        weight=intent.getStringExtra("weight");

        intheight=Float.parseFloat(height);
        intweight=Float.parseFloat(weight);

        intheight=intheight/100;

        intbmi=intweight/(intheight*intheight);

        mbmi=Float.toString(intbmi);

        if(intbmi<18.5)
        {
            mbmicategory.setText("Underweight");
            mrange.setText("Range = 18.4 and below");
            mhealthrisk.setText("Health risk = Malnutrition risk");
            mimageview.setImageResource(R.drawable.crosss);
        }
        else if (intbmi<25 && intbmi>18.4)
        {
            mbmicategory.setText("Normal weight");
            mrange.setText("Range = 18.5 - 24.9");
            mhealthrisk.setText("Health risk = Low risk");
            mimageview.setImageResource(R.drawable.ok);
        }
        else if (intbmi<30 && intbmi>24)
        {
            mbmicategory.setText("Overweight");
            mrange.setText("Range = 25 - 29.9");
            mhealthrisk.setText("Health risk = Enhanced risk");
            mimageview.setImageResource(R.drawable.warning);
        }
        else if (intbmi<35 && intbmi>29)
        {
            mbmicategory.setText("Moderately Obese");
            mrange.setText("Range = 30 - 34.9");
            mhealthrisk.setText("Health risk = Medium risk");
            mimageview.setImageResource(R.drawable.warning);
        }
        else if (intbmi<40 && intbmi>34)
        {
            mbmicategory.setText("Severely Obese");
            mrange.setText("Range = 35 - 39.9");
            mhealthrisk.setText("Health risk = High risk");
            mimageview.setImageResource(R.drawable.warning);
        }
        else if (intbmi>39)
        {
            mbmicategory.setText("Very Severely Obese");
            mrange.setText("Range = 40 and above");
            mhealthrisk.setText("Health risk = Very High risk");
            mimageview.setImageResource(R.drawable.warning);
        }

        mgender.setText(intent.getStringExtra("gender"));
        mbmidisplay.setText(mbmi);


        mrecalculatebmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(bmiactivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}