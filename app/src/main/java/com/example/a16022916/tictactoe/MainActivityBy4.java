package com.example.a16022916.tictactoe;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivityBy4 extends AppCompatActivity {

    ImageButton ib00;

    ImageButton ib10;

    ImageButton ib20;

    ImageButton ib01;

    ImageButton ib11;

    ImageButton ib21;

    ImageButton ib02;

    ImageButton ib12;

    ImageButton ib22;

    ImageButton ib03;

    ImageButton ib13;

    ImageButton ib23;

    ImageButton ib33;

    ImageButton ib30;

    ImageButton ib31;

    ImageButton ib32;

    Button btnStart;

    SeekBar seekBar;

    int progress = 24;

    boolean player1 = true;

    Game newGame = new Game(4);

    Game.Piece[][] pastMoves = new Game.Piece[4][4];

    ImageButton[][] imageButtons = new ImageButton[4][4];

    ImageButton[] pastImage = new ImageButton[5];


//    public CheckGameOver game = new CheckGameOver();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_by4);

        ib00 = (ImageButton) findViewById(R.id.ib00);
        ib00.setTag("ib00");
        String imageName = (String) ib00.getTag();

        imageButtons[0][0] = ib00;

        ib10 = (ImageButton) findViewById(R.id.ib10);
        imageButtons[1][0] = ib10;
        ib10.setTag("ib10");

        ib20 = (ImageButton) findViewById(R.id.ib20);
        imageButtons[2][0] = ib20;
        ib20.setTag("ib20");

        ib01 = (ImageButton) findViewById(R.id.ib01);
        imageButtons[0][1] = ib01;
        ib01.setTag("ib01");

        ib11 = (ImageButton) findViewById(R.id.ib11);
        imageButtons[1][1] = ib11;
        ib11.setTag("ib11");

        ib21 = (ImageButton) findViewById(R.id.ib21);
        imageButtons[2][1] = ib21;
        ib21.setTag("ib21");

        ib02 = (ImageButton) findViewById(R.id.ib02);
        imageButtons[0][2] = ib02;
        ib02.setTag("ib02");

        ib12 = (ImageButton) findViewById(R.id.ib12);
        imageButtons[1][2] = ib12;
        ib00.setTag("00");

        ib22 = (ImageButton) findViewById(R.id.ib22);
        imageButtons[2][2] = ib22;
        ib00.setTag("00");

        ib03 = (ImageButton) findViewById(R.id.ib03);
        imageButtons[0][3] = ib03;
        ib00.setTag("00");

        ib13 = (ImageButton) findViewById(R.id.ib13);
        imageButtons[1][3] = ib13;
        ib00.setTag("00");

        ib23 = (ImageButton) findViewById(R.id.ib23);
        imageButtons[2][3] = ib23;
        ib00.setTag("00");

        ib33 = (ImageButton) findViewById(R.id.ib33);
        imageButtons[3][3] = ib33;
        ib00.setTag("00");

        ib30 = (ImageButton) findViewById(R.id.ib30);
        imageButtons[3][0] = ib30;
        ib00.setTag("00");

        ib31 = (ImageButton) findViewById(R.id.ib31);
        imageButtons[3][1] = ib31;
        ib00.setTag("00");

        ib32 = (ImageButton) findViewById(R.id.ib32);
        imageButtons[3][2] = ib32;
        ib00.setTag("00");

        btnStart = (Button) findViewById(R.id.btnStart);

//        newGame onRetainNonConfigurationInstance(true);

        if (savedInstanceState != null) {
            pastMoves = (Game.Piece[][]) savedInstanceState.getSerializable("pastMoves");

            if (pastMoves != null) {
                reloadPieces();
            }
        }

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int height = size.y;
        int width = size.x;

        LinearLayout boardLayout = (LinearLayout) findViewById(R.id.boardLayout);

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
        {

            ViewGroup.LayoutParams params = boardLayout.getLayoutParams();

            //because of header

            params.height = height-200;
            params.width = height-200;

            boardLayout.setLayoutParams(new LinearLayout.LayoutParams(params));
        }
        else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
        {
            ViewGroup.LayoutParams params = boardLayout.getLayoutParams();

            params.height = width;
            params.width = width;

            boardLayout.setLayoutParams(new LinearLayout.LayoutParams(params));
        }

        Intent intent = getIntent();

        ib00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(newGame.getState() == Game.STATE.P)
                {
                    gamePlay(0, 0, ib00);
                }
            }
        });

        ib10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(newGame.getState() == Game.STATE.P)
                {
                    gamePlay(1, 0, ib10);
                }
            }
        });

        ib20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(newGame.getState() == Game.STATE.P)
                {
                    gamePlay(2, 0, ib20);
                }
            }
        });

        ib01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(newGame.getState() == Game.STATE.P)
                {
                    gamePlay(0, 1, ib01);
                }
            }
        });

        ib02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(newGame.getState() == Game.STATE.P)
                {
                    gamePlay(0, 2, ib02);
                }
            }
        });


        ib11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(newGame.getState() == Game.STATE.P)
                {
                    gamePlay(1, 1, ib11);
                }
            }
        });

        ib21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(newGame.getState() == Game.STATE.P)
                {
                    gamePlay(2, 1, ib21);
                }
            }
        });

        ib12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(newGame.getState() == Game.STATE.P)
                {
                    gamePlay(1, 2, ib12);
                }
            }
        });

        ib22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(newGame.getState() == Game.STATE.P)
                {
                    gamePlay(2, 2, ib22);
                }
            }
        });

        ib03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(newGame.getState() == Game.STATE.P)
                {
                    gamePlay(0, 3, ib03);
                }
            }
        });

        ib13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(newGame.getState() == Game.STATE.P)
                {
                    gamePlay(1, 3, ib13);
                }
            }
        });

        ib23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(newGame.getState() == Game.STATE.P)
                {
                    gamePlay(2, 3, ib23);
                }
            }
        });

        ib33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(newGame.getState() == Game.STATE.P)
                {
                    gamePlay(3, 3, ib33);
                }
            }
        });

        ib30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(newGame.getState() == Game.STATE.P)
                {
                    gamePlay(3, 0, ib30);
                }
            }
        });

        ib31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(newGame.getState() == Game.STATE.P)
                {
                    gamePlay(3, 1, ib31);
                }
            }
        });

        ib32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(newGame.getState() == Game.STATE.P)
                {
                    gamePlay(3, 2, ib32);
                }
            }
        });

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newGame.resetBoard();;
                reloadPastMoves();
                for (int i = 0; i < pastMoves.length; i++){
                    for (int j = 0; j < pastMoves.length; j++){
                        reset(imageButtons[i][j]);
                    }
                }
            }
        });

    }

    public void gamePlay(int x, int y, ImageButton ib) {


        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; i++){
                String alpha = "ib[" + String.valueOf(i) + "][" + String.valueOf(j) + "]";
//                String ibTag = (String) ib.getTag();
//                if(ibTag == alpha){
                    Toast.makeText(MainActivityBy4.this, alpha, Toast.LENGTH_SHORT).show();
//                    break;
//                }
            }

        }
//        imageButtons[0][1];


        newGame.move(x, y);
        if (newGame.getState() == Game.STATE.E1)  //if state is E1
        {
            Toast.makeText(MainActivityBy4.this, "Move not allowed!", Toast.LENGTH_SHORT).show();
            newGame.setState(Game.STATE.P);
        }
        else if (newGame.getState() == Game.STATE.P)
        {
            placeTurn(ib);
            pastImage[newGame.getTurnCount()] = imageButtons[x][y];
            newGame.nextTurn();
        }
        else if (newGame.getState() == Game.STATE.W)
        {
            Toast.makeText(MainActivityBy4.this, "Win", Toast.LENGTH_SHORT).show();
            pastImage[newGame.getTurnCount()] = imageButtons[x][y];
            placeTurn(ib);
        }
        else if (newGame.getState() == Game.STATE.D)
        {
            Toast.makeText(MainActivityBy4.this, "Draw", Toast.LENGTH_SHORT).show();
            pastImage[newGame.getTurnCount()] = imageButtons[x][y];
            placeTurn(ib);
        }


//        if (newGame.getState() == Game.STATE.E1)  //if state is E1
//        {
//            Toast.makeText(MainActivityBy4.this, "Move not allowed!", Toast.LENGTH_SHORT).show();
//            newGame.setState(Game.STATE.P);
//        }
//        else if (newGame.getState() == Game.STATE.P)
//        {
//            placeTurn(ib);
//            pastImage[newGame.getTurnCount()] = imageButtons[x][y];
//            newGame.nextTurn();
//        }
//        else if (newGame.getState() == Game.STATE.W)
//        {
//            Toast.makeText(MainActivityBy4.this, "Win", Toast.LENGTH_SHORT).show();
//            pastImage[newGame.getTurnCount()] = imageButtons[x][y];
//            placeTurn(ib);
//        }
//        else if (newGame.getState() == Game.STATE.D)
//        {
//            Toast.makeText(MainActivityBy4.this, "Draw", Toast.LENGTH_SHORT).show();
//            pastImage[newGame.getTurnCount()] = imageButtons[x][y];
//            placeTurn(ib);
//        }
    }

    private void reset(ImageButton ib){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            ib.setImageDrawable(getResources().getDrawable(R.drawable.nothing, getApplicationContext().getTheme()));
        }
        else
        {
            ib.setImageDrawable(getResources().getDrawable(R.drawable.nothing));
        }
    }

    private void placeTurn(ImageButton ib){
        if (newGame.getCurrentPiece() == Game.Piece.X)
        {
            placeX(ib);
        }
        else
        {
            placeO(ib);
        }
    }

    private void placeX(ImageButton ib){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            ib.setImageDrawable(getResources().getDrawable(R.drawable.piecex, getApplicationContext().getTheme()));
        }
        else
        {
            ib.setImageDrawable(getResources().getDrawable(R.drawable.piecex));
        }
    }

    private void placeO(ImageButton ib){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            ib.setImageDrawable(getResources().getDrawable(R.drawable.o, getApplicationContext().getTheme()));
        }
        else
        {
            ib.setImageDrawable(getResources().getDrawable(R.drawable.o));
        }
    }

    private void reloadPieces(){

        for(int i = 0; i < pastImage.length; i++){
//            gamePlay(pastImage[i]);
        }

        for (int i = 0; i < pastMoves.length; i++)
        {
            for (int j = 0; j < pastMoves.length; j++)
            {
                if(pastMoves[i][j] == Game.Piece.X)
                {
                    placeX(imageButtons[i][j]);
                    newGame.placeXManual(i,j);
                }
                else if (pastMoves[i][j] == Game.Piece.O)
                {
                    placeO(imageButtons[i][j]);
                    newGame.placeOManual(i,j);
                }
            }
        }
    }
    private void reloadPastMoves(){
        for (int i = 0; i < pastMoves.length; i++)
        {
            for (int j = 0; j < pastMoves.length; j++)
            {
                pastMoves[i][j] = null;
            }
        }

    }
    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putSerializable("pastMoves",pastMoves);

    }


}
