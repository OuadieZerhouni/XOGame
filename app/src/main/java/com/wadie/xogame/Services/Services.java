package com.wadie.xogame.Services;

public class Services {

    private char[][] gameBoard;
    private String curentPlayer="X";
    public static Services instance;

    public static Services getInstance() {
        if (instance == null) {
            instance = new Services();
        }
        return instance;
    }

    private Services() {
        gameBoard = new char[3][3];
    }


    public char makeMove(int row, int col) {
       
          boolean isX = curentPlayer.equals("X");
          gameBoard[row][col] = isX ? 'X' : 'O';
          if (isX) {
              curentPlayer = "O";
              return 'X';
          } else {
              curentPlayer = "X";
              return 'O';
          }

    }


    public char checkForWinner() {
        // Check rows for a win
        for (int i = 0; i < 3; i++) {
            if (gameBoard[i][0] == gameBoard[i][1] && gameBoard[i][1] == gameBoard[i][2]) {
                if (gameBoard[i][0] != '\u0000') { // Empty cells should not count as wins
                    return gameBoard[i][0];
                }
            }
        }

        for (int j = 0; j < 3; j++) {
            if (gameBoard[0][j] == gameBoard[1][j] && gameBoard[1][j] == gameBoard[2][j]) {
                if (gameBoard[0][j] != '\u0000') {
                    return gameBoard[0][j];
                }
            }
        }

        if (gameBoard[0][0] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][2]) {
            if (gameBoard[0][0] != '\u0000') {
                return gameBoard[0][0];
            }
        }

        if (gameBoard[0][2] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][0]) {
            if (gameBoard[0][2] != '\u0000') {
                return gameBoard[0][2];
            }
        }

        boolean isTie = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameBoard[i][j] == '\u0000') {
                    isTie = false;
                    break;
                }
            }
        }
        if (isTie) {
            return 'T';
        }

        return 'N';
    }

    public void reset() {
        gameBoard = new char[3][3];
    }
}