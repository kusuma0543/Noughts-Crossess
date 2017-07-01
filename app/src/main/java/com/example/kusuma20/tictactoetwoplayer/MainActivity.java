package com.example.kusuma20.tictactoetwoplayer;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    Button b,playg;
    RadioGroup g1;
    RadioGroup g2;
    RadioButton rd;
    String p1;
    String p2;
    Button click;
    final Context context=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        click=(Button)findViewById(R.id.clickHere);
        click.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                setContentView(R.layout.res);
                playg=(Button) findViewById(R.id.about);
                playg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent j=new Intent(MainActivity.this,About.class);
                        startActivity(j);
                    }
                });

                b=(Button)findViewById(R.id.play);
                g1=(RadioGroup)findViewById(R.id.player1);
                g2=(RadioGroup)findViewById(R.id.player2);

                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int sel=g1.getCheckedRadioButtonId();
                        rd=(RadioButton)findViewById(sel);
                        p1=rd.getText().toString();

                        sel=g2.getCheckedRadioButtonId();
                        rd=(RadioButton)findViewById(sel);
                        p2=rd.getText().toString();

                        Intent i=new Intent(context,Game.class);
                        i.putExtra("Player1",p1);
                        i.putExtra("Player2",p2);
                        startActivity(i);
                    }
                });
            }
        });

    }


}
