package com.example.tactic;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean iswinner = false;
    int imageclick =-1;
    int player=1;//cross
    int [][]winningstates={{0,1,2},{3,4,5},{6,7,8},{0,4,8},{0,3,6},{2,4,6},{1,4,7},{2,5,8}};
    int []gamestate ={-1,-1,-1,-1,-1,-1,-1,-1,-1};

    public void load (View view) {


        ImageView v = (ImageView) view;
        int tag = Integer.parseInt(v.getTag().toString());
        imageclick = gamestate[tag];
        if (iswinner == false && imageclick == -1) {
            if (player == 1) {
                v.setImageResource(R.drawable.cross);
                gamestate[tag] = player;
                Toast.makeText(this, tag + " " + "CROSS", Toast.LENGTH_SHORT).show();
                player = 0;
            } else {
                v.setImageResource(R.drawable.zero);
                gamestate[tag] = player;
                Toast.makeText(this, tag + " " + "ZERO", Toast.LENGTH_SHORT).show();
                player = 1;

            }
            for (int i = 0; i < winningstates.length; i++) {
                if (gamestate[winningstates[i][0]] == gamestate[winningstates[i][1]] && gamestate[winningstates[i][1]] == gamestate[winningstates[i][2]] && gamestate[winningstates[i][0]] > -1) {
                    Toast.makeText(this, "winner is " + (player == 0 ? 1 : 0), Toast.LENGTH_SHORT).show();
                    iswinner = true;
                }
            }
        }
    }
    public void reset(View view){
        GridLayout gridLayout = findViewById((R.id.gridLayout));
        int total_images= gridLayout.getChildCount();
        for (int i =0;i<total_images;i++){
            ImageView v = (ImageView) gridLayout.getChildAt(i);
            v.setImageDrawable(null);
        }
        iswinner=false;
        imageclick =-1;
        player =1;
        for (int i =0;i< gamestate.length;i++){
            gamestate[i]=-1;
        }



    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
