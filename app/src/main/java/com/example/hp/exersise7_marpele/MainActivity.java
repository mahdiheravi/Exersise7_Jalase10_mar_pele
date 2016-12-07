package com.example.hp.exersise7_marpele;

import android.app.ActionBar;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Random;
import java.util.logging.Handler;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout[] LL;
    Button[] btn;
    int iteration;
    int counter, direction, random_number, old_counter;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LL = new LinearLayout[11];
        btn = new Button[101];


        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1f);
        layoutParams.weight = 1;
        LinearLayout parentLayout = (LinearLayout) findViewById(R.id.LL);
        final TextView TVshow = (TextView) findViewById(R.id.TVshow);

        int k = 101;
        counter = 0;
        direction = 1;
        iteration = 0;
        for (int i = 1; i <= 10; i++) {
            LL[i] = new LinearLayout(this);
            LL[i].setOrientation(LinearLayout.HORIZONTAL);
            parentLayout.addView(LL[i]);
            direction *= (-1);
            for (int j = 1; j <= 10; j++) {
                if (direction == -1)
                    k--;
                else
                    k++;

                btn[k] = new Button(this);
                btn[k].setText(String.valueOf(k));
                btn[k].setLayoutParams(layoutParams);
                btn[k].setPadding(0, 0, 0, 0);
                btn[k].setTag("btn" + String.valueOf(k));
                btn[k].setBackgroundColor(Color.rgb(208, 173, 136));
                LL[i].addView(btn[k]);


            }

            k = k - 10 + direction;
        }
        InitilizeMAR();

        final Button btntas = (Button) findViewById(R.id.btntas);
        btntas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iteration++;
                Random rnd = new Random();
                random_number = rnd.nextInt(6) + 1;//create Random number Between 1 - 6;
                TVshow.setText(String.valueOf(random_number));
                old_counter = counter;
                if (counter+random_number>100)
                    Toast.makeText(MainActivity.this, "Try again for smaller Number", Toast.LENGTH_SHORT).show();
                else {
                    counter += random_number;
                    counter = IsMAR(counter);
                    
                    btn[counter].setBackgroundColor(Color.BLUE);

                    if (old_counter != 0)
                        btn[old_counter].setBackgroundColor(Color.rgb(208, 173, 136));
                    if (counter== 100)
                    {
                        Toast.makeText(MainActivity.this, "YOU WIN BY "+String.valueOf(iteration)+" Iteration", Toast.LENGTH_SHORT).show();
                        btntas.setEnabled(false);


                    }
                }

            }
        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private void InitilizeMAR() {
        btn[35].setBackgroundColor(Color.RED);
        btn[78].setBackgroundColor(Color.RED);
        btn[90].setBackgroundColor(Color.RED);
        btn[45].setBackgroundColor(Color.RED);
    }

    private int IsMAR(int num) {
        int new_num=-1;
        switch (num) {
            case 35:
                new_num = 12;
                break;
               
            case 78:
                new_num = 12;
                break;
            case 90:
                new_num = 12;
                break;
            case 45:
                new_num = 12;
                break;
        }
        if (new_num!=-1)
        {
            Toast.makeText(MainActivity.this, "Snakebite By "+ String.valueOf(num), Toast.LENGTH_SHORT).show();
            return  new_num;
        }
        return num;
    }

    @Override
    public void onClick(View v) {

    }

}