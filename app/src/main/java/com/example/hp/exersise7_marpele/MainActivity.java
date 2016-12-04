package com.example.hp.exersise7_marpele;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout[] LL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LL = new LinearLayout[10];
        Button btn1 = new Button(this);
        btn1.setText("btn1");
        Button btn2 = new Button(this);
        btn2.setText("btn2");
        Button btn3 = new Button(this);
        btn3.setText("ggggggg");

        LinearLayout parentLayout = (LinearLayout) findViewById(R.id.LL);

        LL[0] = new LinearLayout(this);
        LL[0].setOrientation(LinearLayout.HORIZONTAL);
        LL[0].setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT));
        parentLayout.addView(LL[0]);
        LL[0].addView(btn1);
        LL[0].addView(btn2);

        LL[1] = new LinearLayout(this);
        LL[1].setOrientation(LinearLayout.HORIZONTAL);
        LL[1].setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT));
        parentLayout.addView(LL[1]);
        LL[1].addView(btn3);



    }
}
