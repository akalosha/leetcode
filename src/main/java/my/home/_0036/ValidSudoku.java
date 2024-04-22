package my.home._0036;

import java.util.ArrayList;
import java.util.List;

public class ValidSudoku {

    public static void main(String[] args) {
        char board[][] = {{'5' , '3' , '.' , '.' , '7' , '.' , '.' , '.' , '.'}
                , {'6' , '.' , '.' , '1' , '9' , '5' , '.' , '.' , '.'}
                , {'.' , '9' , '8' , '.' , '.' , '.' , '.' , '6' , '.'}
                , {'8' , '.' , '.' , '.' , '6' , '.' , '.' , '.' , '3'}
                , {'4' , '.' , '.' , '8' , '.' , '3' , '.' , '.' , '1'}
                , {'7' , '.' , '.' , '.' , '2' , '.' , '.' , '.' , '6'}
                , {'.' , '6' , '.' , '.' , '.' , '.' , '2' , '8' , '.'}
                , {'.' , '.' , '.' , '4' , '1' , '9' , '.' , '.' , '5'}
                , {'.' , '.' , '.' , '.' , '8' , '.' , '.' , '7' , '9'}};
        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            List<Character> existed = new ArrayList<>();
            for (int j = 0; j < 9; j++) {
                if (existed.contains(board[i][j])) {
                    return false;
                } else if (board[i][j] != '.') {
                    existed.add(board[i][j]);
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            List<Character> existed = new ArrayList<>();
            for (int j = 0; j < 9; j++) {
                if (existed.contains(board[j][i])) {
                    return false;
                } else if (board[j][i] != '.') {
                    existed.add(board[j][i]);
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            List<Character> existed = new ArrayList<>();
            for (int j = 0; j < 9; j++) {
                if (existed.contains(board[j][i])) {
                    return false;
                } else if (board[j][i] != '.') {
                    existed.add(board[j][i]);
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!isAreaValid(i, j, board))
                    return false;
            }
        }
        return true;
    }

    private static boolean isAreaValid(int i, int j, char[][] board) {
        List<Character> existed = new ArrayList<>();
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                char tempChar = board[i * 3 + x][j * 3 + y];
                if (existed.contains(tempChar)) {
                    return false;
                } else if (tempChar != '.') {
                    existed.add(tempChar);
                }
            }
        }
        return true;
    }
}