package com.example.a16022916.tictactoe;

import java.util.List;
import java.util.Stack;

/**
 * Created by 16022916 on 14/3/2018.
 */

public class Game {

    private static final String TAG = "Game";

    private int turnCount = 0;

    private int numRows;

    private Piece[][] board = new Piece[numRows][numRows];

    private STATE gameState = STATE.P;

//    private int prevMove[] = new int[2];

    private Piece currentPiece = Piece.X;

    public enum Piece {E, X, O};

    public enum STATE {P, W, D, E1}; //P for place; W for Win; D for Draw; Error1 for Cannot place there

    public Game(int numRows)
    {
        this.numRows = numRows;
        this.board = new Piece[numRows][numRows];
        resetBoard();
    }

    public Piece getCurrentPiece()
    {
        return currentPiece;
    }

    public STATE getState()
    {
        return gameState;
    }

    public void setState(STATE state)
    {
        gameState = state;
    }

    public void setCurrentPiece(Piece piece){
        currentPiece = piece;
    }
    public void move(int x, int y)
    {
        if (board[x][y] == Piece.E)
        {
            board[x][y] = currentPiece;
            turnCount ++;
//            prevMove[0] = x;
//            prevMove[1] = y;
            checkGameState(x,y);

        }
        else
        {
            gameState = STATE.E1;
        }
    }

    public int getTurnCount(){
        return turnCount;
    }


//    public void reverse()
//    {
//        nextTurn();
//        board[prevMove[0]][prevMove[1]] = Piece.E;
//    }

    public void placeXManual(int x, int y){
        board[x][y] = Piece.X;
    }

    public void placeOManual(int x, int y){
        board[x][y] = Piece.O;
    }
    private STATE checkGameState(int x, int y)
    {
        int stateVal = 0;

        for (int i = 0; i < numRows; i++) //cols
        {
            if (board[i][y] != currentPiece)
            {
                stateVal = 0;
                for (int a = 0; a < numRows; a++) //row
                {
                    if (board[x][a] != currentPiece)
                    {
                        stateVal = 0;
                        for (int b = 0; b < numRows; b++) //Diag
                        {
                            if (board[b][b] != currentPiece)
                            {
                                stateVal = 0;
                                for (int c = 0; c < numRows; c++){
                                    if (board[c][(numRows - 1) - c] != currentPiece)
                                    {
                                        stateVal = 0;
                                        break;
                                    }
                                    else
                                    {
                                        stateVal = 1;
                                    }
                                }
                                break;
                            }
                            else
                            {
                                stateVal = 1; //Win
                            }
                        }
                        break;
                    }
                    else
                    {
                        stateVal = 1; //Win
                    }
                }
                break;
            }
            else
            {
                stateVal = 1; //Win

            }
        }





        if(stateVal != 1) {
            if (turnCount == numRows * numRows) //Draw
            {
                stateVal = 2; //Display Draw
            }
        }

        if (stateVal == 1) //stateVal to STATE
        {
            return gameState = STATE.W;
        }
        else if (stateVal == 2)
        {
            return gameState = STATE.D;
        }
        else
        {
            return gameState = STATE.P;
        }
    }

    public void resetBoard()
    {
        turnCount = 0;
        currentPiece = Piece.X;
        gameState = STATE.P;
        for (int i = 0; i < numRows; i++)
        {
            for (int j = 0; j < board[i].length; j++) //if in the future progress: m * n board
            {
                board[i][j] = Piece.E;
            }
        }
    }

    public void nextTurn()
    {
        if(currentPiece == Piece.X)
        {
            currentPiece = Piece.O;
        }
        else
        {
            currentPiece = Piece.X;
        }
    }
}

