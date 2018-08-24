package medium;

import java.util.Arrays;

public class ValidSudoku {
    //暴力循环 n^3
    public boolean isValidSudoku1(char[][] board) {
        boolean solution = true;

        //row
        for(int i = 0; i < 9; i++) {
            int[] temp = {-1,-1,-1,-1,-1,-1,-1,-1,-1};
            for(int j = 0; j < 9; j++) {
                if(board[i][j] == '.') continue;
                else if(temp[board[i][j] - '0' - 1] != -1) return false;
                else temp[board[i][j] - '0' - 1] = 1;
            }
        }

        //col
        for(int i = 0; i < 9; i++) {
            int[] temp = {-1,-1,-1,-1,-1,-1,-1,-1,-1};
            for(int j = 0; j < 9; j++) {
                if(board[j][i] == '.') continue;
                else if(temp[board[j][i] - '0' - 1] != -1) return false;
                else temp[board[j][i] - '0' - 1] = 1;
            }
        }

        //sub


        return true;
    }


    //jiuzhang solution
    public boolean isValidSudoku(char[][] board) {
        boolean[] visited = new boolean[9];

        // row
        for(int i = 0; i<9; i++){
            Arrays.fill(visited, false);
            for(int j = 0; j<9; j++){
                if(!process(visited, board[i][j]))
                    return false;
            }
        }

        //col
        for(int i = 0; i<9; i++){
            Arrays.fill(visited, false);
            for(int j = 0; j<9; j++){
                if(!process(visited, board[j][i]))
                    return false;
            }
        }

        // sub matrix
        for(int i = 0; i<9; i+= 3){
            for(int j = 0; j<9; j+= 3){
                Arrays.fill(visited, false);
                for(int k = 0; k<9; k++){
                    if(!process(visited, board[i + k/3][ j + k%3]))
                        return false;
                }
            }
        }
        return true;

    }

    private boolean process(boolean[] visited, char digit){
        if(digit == '.'){
            return true;
        }

        int num = digit - '0';
        if ( num < 1 || num > 9 || visited[num-1]){
            return false;
        }

        visited[num-1] = true;
        return true;
    }


}
