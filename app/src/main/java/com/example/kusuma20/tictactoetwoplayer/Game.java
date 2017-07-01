package com.example.kusuma20.tictactoetwoplayer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by kusuma20 on 17/6/17.
 */

public class Game extends Activity {
    String p1;
    String p2;
    static int i=0;
    int j;
    GridView gridview;
    static final String[] symbols=new String[]{"","","","","","","","",""};
    int visitedp1[]={-1,-1,-1,-1,-1,-1,-1,-1,-1};
    int visitedp2[]={-1,-1,-1,-1,-1,-1,-1,-1,-1};

    final Context context=this;
    public void check(int visitedp1[], int visitedp2[])
    {
        int flag=0;
        String winner=null;

        //player1
        if((visitedp1[0]==1)&& (visitedp1[4]==1) &&(visitedp1[8]==1))
        {
            flag=1;
            winner="Player 1";
        }
        else if((visitedp1[2]==1)&& (visitedp1[4]==1) &&(visitedp1[6]==1))
        {
            flag=1;
            winner="Player 1";
        }
        else if((visitedp1[0]==1)&& (visitedp1[3]==1) &&(visitedp1[6]==1))
        {
            flag=1;
            winner="Player 1";
        }
        else if((visitedp1[1]==1)&& (visitedp1[4]==1) &&(visitedp1[7]==1))
        {
            flag=1;
            winner="Player 1";
        }
        else if((visitedp1[2]==1)&& (visitedp1[5]==1) &&(visitedp1[8]==1))
        {
            flag=1;
            winner="Player 1";
        }
        else if((visitedp1[0]==1)&& (visitedp1[1]==1) &&(visitedp1[2]==1))
        {
            flag=1;
            winner="Player 1";
        }
        else if((visitedp1[3]==1)&& (visitedp1[4]==1) &&(visitedp1[5]==1))
        {
            flag=1;
            winner="Player 1";
        }
        else if((visitedp1[6]==1)&& (visitedp1[7]==1) &&(visitedp1[8]==1))
        {
            flag=1;
            winner="Player 1";
        }

        //player2
        if((visitedp2[0]==1)&& (visitedp2[4]==1) &&(visitedp2[8]==1))
        {
            flag=1;
            winner="Player 2";
        }
        else if((visitedp2[2]==1)&& (visitedp2[4]==1) &&(visitedp2[6]==1))
        {
            flag=1;
            winner="Player 2";
        }
        else if((visitedp2[0]==1)&& (visitedp2[3]==1) &&(visitedp2[6]==1))
        {
            flag=1;
            winner="Player 2";
        }
        else if((visitedp2[1]==1)&& (visitedp2[4]==1) &&(visitedp2[7]==1))
        {
            flag=1;
            winner="Player 2";
        }
        else if((visitedp2[2]==1)&& (visitedp2[5]==1) &&(visitedp2[8]==1))
        {
            flag=1;
            winner="Player 2";
        }
        else if((visitedp2[0]==1)&& (visitedp2[1]==1) &&(visitedp2[2]==1))
        {
            flag=1;
            winner="Player 2";
        }
        else if((visitedp2[3]==1)&& (visitedp2[4]==1) &&(visitedp2[5]==1))
        {
            flag=1;
            winner="Player 2";
        }
        else if((visitedp2[6]==1)&& (visitedp2[7]==1) &&(visitedp2[8]==1))
        {
            flag=1;
            winner="Player 2";
        }

        if(flag==1)
        {
            Intent i=new Intent(context,Win.class);
            i.putExtra("winner",winner);
            startActivity(i);

        }
        if(i==8)
        {
            Intent gamedraw=new Intent(context,DrawGame.class);
            startActivity(gamedraw);
        }
    }
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        for(int k=0;k<9;++k)
        {
            visitedp1[k]=-1;
            visitedp2[k]=-1;
        }
        i=0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_layout);

        Intent intent = getIntent();
        p1=intent.getStringExtra("Player1");
        p2=intent.getStringExtra("Player2");

        if(p1.equalsIgnoreCase(p2))
        {
            Toast.makeText(context,"Both players cannot choose same symbol",Toast.LENGTH_LONG).show();
            finish();
        }
        else
        {

            gridview=(GridView)findViewById(R.id.gridview1);

            ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.game_layout2,symbols);
            gridview.setAdapter(adapter);

            gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    int flag=0;
                    t=(TextView)view.findViewById(R.id.txt);
                    for(j=0;j<9;++j)
                    {
                        if(visitedp1[position]==1 || visitedp2[position]==1)
                        {
                            flag=1;
                            Toast.makeText(context,"Invalid....",Toast.LENGTH_LONG).show();
                            break;
                        }
                    }
                    if(flag==0)
                    {

                        if(i%2==0)
                        {
                            //Toast.makeText(context,"Player1.....",50).show();
                            t.setText(p1);
                            visitedp1[position]=1;


                        }
                        else
                        {
                            //Toast.makeText(context,"Player2.....",50).show();
                            t.setText(p2);
                            visitedp2[position]=1;

                        }
                        check(visitedp1,visitedp2);
                        i=i+1;

                    }
                }
            });

        }
    }
}
