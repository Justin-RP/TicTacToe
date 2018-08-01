package com.example.a16022916.tictactoe;

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
import android.widget.Toast;

public class MainActivityBy3 extends AppCompatActivity {

    ImageButton ib00;

    ImageButton ib10;

    ImageButton ib20;

    ImageButton ib01;

    ImageButton ib11;

    ImageButton ib21;

    ImageButton ib02;

    ImageButton ib12;

    ImageButton ib22;

    Button btnStart;

    boolean player1 = true;

    Game newGame = new Game(3);

    Game.Piece[][] pastMoves = new Game.Piece[3][3];

    ImageButton[][] imageButtons = new ImageButton[3][3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_by3);

        ib00 = (ImageButton) findViewById(R.id.ib00);

        ib10 = (ImageButton) findViewById(R.id.ib10);

        ib20 = (ImageButton) findViewById(R.id.ib20);

        ib01 = (ImageButton) findViewById(R.id.ib01);

        ib11 = (ImageButton) findViewById(R.id.ib11);

        ib21 = (ImageButton) findViewById(R.id.ib21);

        ib02 = (ImageButton) findViewById(R.id.ib02);

        ib12 = (ImageButton) findViewById(R.id.ib12);

        ib22 = (ImageButton) findViewById(R.id.ib22);


        btnStart = (Button) findViewById(R.id.btnStart);

        if (savedInstanceState != null) {
            pastMoves = (Game.Piece[][]) savedInstanceState.getSerializable("pastMoves");
            boolean isXTurn = (boolean) savedInstanceState.get("isXTurn");
            if(isXTurn){
                newGame.setCurrentPiece(Game.Piece.X);
            }
            else
            {
                newGame.setCurrentPiece(Game.Piece.O);
            }
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

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newGame.resetBoard();;
                reset(ib00);
                reset(ib10);
                reset(ib20);
                reset(ib01);
                reset(ib02);
                reset(ib11);
                reset(ib21);
                reset(ib12);
                reset(ib22);
                pastMoves = new Game.Piece[3][3];
            }
        });

    }

    public void gamePlay(int x, int y, ImageButton ib) {


        newGame.move(x, y);

        if (newGame.getState() == Game.STATE.E1)
        {
            Toast.makeText(MainActivityBy3.this, "Move not allowed!", Toast.LENGTH_SHORT).show();
            newGame.setState(Game.STATE.P);
        }
        else if (newGame.getState() == Game.STATE.P)
        {
            placeTurn(ib);
            if (newGame.getCurrentPiece() == Game.Piece.X)
            {
                pastMoves[x][y] = Game.Piece.X;
            }
            else
            {
                pastMoves[x][y] = Game.Piece.O;
            }
            newGame.nextTurn();
        }
        else if (newGame.getState() == Game.STATE.W)
        {
            Toast.makeText(MainActivityBy3.this, "Win", Toast.LENGTH_SHORT).show();
            placeTurn(ib);
        }
        else if (newGame.getState() == Game.STATE.D)
        {
            Toast.makeText(MainActivityBy3.this, "Draw", Toast.LENGTH_SHORT).show();
            placeTurn(ib);
        }
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
        if (pastMoves[0][0] == Game.Piece.X)
        {
            placeX(ib00);
            newGame.placeXManual(0,0);
        }
        else if (pastMoves[0][0] == Game.Piece.O)
        {
            placeO(ib00);
            newGame.placeOManual(0,0);
        }

        if (pastMoves[0][1] == Game.Piece.X)
        {
            placeX(ib01);
            newGame.placeXManual(0,1);
        }
        else if (pastMoves[0][1] == Game.Piece.O)
        {
            placeO(ib01);
            newGame.placeOManual(0,1);
        }

        if (pastMoves[0][2] == Game.Piece.X)
        {
            placeX(ib02);
            newGame.placeXManual(0,2);
        }
        else if (pastMoves[0][2] == Game.Piece.O)
        {
            placeO(ib02);
            newGame.placeOManual(0,2);
        }

        if (pastMoves[1][0] == Game.Piece.X)
        {
            placeX(ib10);
            newGame.placeXManual(1,0);
        }
        else if (pastMoves[1][0] == Game.Piece.O)
        {
            placeO(ib10);
            newGame.placeOManual(1,0);
        }
        if (pastMoves[2][0] == Game.Piece.X)
        {
            placeX(ib20);
            newGame.placeXManual(2,0);
        }
        else if (pastMoves[2][0] == Game.Piece.O)
        {
            placeO(ib20);
            newGame.placeOManual(2,0);
        }
        if (pastMoves[1][1] == Game.Piece.X)
        {
            placeX(ib11);
            newGame.placeXManual(1,1);
        }
        else if (pastMoves[1][1] == Game.Piece.O)
        {
            placeO(ib11);
            newGame.placeOManual(1,1);
        }
        if (pastMoves[1][2] == Game.Piece.X)
        {
            placeX(ib12);
            newGame.placeXManual(1,2);
        }
        else if (pastMoves[1][2] == Game.Piece.O)
        {
            placeO(ib12);
            newGame.placeOManual(1,2);
        }
        if (pastMoves[2][2] == Game.Piece.X)
        {
            placeX(ib12);
            newGame.placeXManual(2,2);
        }
        else if (pastMoves[2][2] == Game.Piece.O)
        {
            placeO(ib12);
            newGame.placeOManual(2,2);
        }
        if (pastMoves[2][1] == Game.Piece.X)
        {
            placeX(ib21);
            newGame.placeXManual(2,1);
        }
        else if (pastMoves[2][1] == Game.Piece.O)
        {
            placeO(ib21);
            newGame.placeOManual(2,1);
        }
    }
    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putSerializable("pastMoves",pastMoves);
        boolean isXTurn;
        if(newGame.getCurrentPiece() == Game.Piece.X){
            isXTurn = true;
        }
        else
        {
            isXTurn = false;
        }
        outState.putBoolean("isXTurn",isXTurn);
    }


}

