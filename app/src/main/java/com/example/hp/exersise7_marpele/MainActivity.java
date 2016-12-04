package com.example.hp.exersise7_marpele;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout[] LL;
    Button[] btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LL = new LinearLayout[11];
        btn = new Button[101];


        LinearLayout parentLayout = (LinearLayout) findViewById(R.id.LL);
        int k;
        for (int i = 1; i <= 10; i++) {
            LL[i] = new LinearLayout(this);
            LL[i].setOrientation(LinearLayout.HORIZONTAL);
            LL[i].setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT));
            parentLayout.addView(LL[i]);
            for (int j = 1; j <= 10; j++) {
                k = i * j;
                btn[k] = new Button(this);
                btn[k].setText("btn");
                LL[i].addView(btn[k]);
            }
        }


    }
}
