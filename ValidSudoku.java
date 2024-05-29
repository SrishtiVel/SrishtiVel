class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 81; i++) {
            if (board[i/9][i-(9*(i/9))] == '.') {
                continue;
            }
            for (int j = i-(9*(i/9))+1; j < 9; j++) {
                if (board[i/9][i-(9*(i/9))] == board[i/9][j]) {
                    //System.out.println("Look at row");
                    return false;
                }
            }
            for (int j = i/9+1; j < 9; j++) {
                if (board[i/9][i-(9*(i/9))] == board[j][i-(9*(i/9))]) {
                    //System.out.println("Look at column");
                    return false;
                }
            }
            //System.out.println("["+i/9+", "+(i-(9*(i/9)))+"]");
            for (int c = i-(9*(i/9)); c < ((i-(9*(i/9)))/3)*3 + 3; c++) {
                for (int r = ((i/9)/3)*3; r < ((i/9)/3)*3 + 3; r++) {
                    //System.out.println("["+i/9+", "+(i-(9*(i/9)))+"] and ["+r+", "+c+"]");
                    if (board[i/9][i-(9*(i/9))] == board[r][c] && r != i/9 && c!= i-(9*(i/9))) {
                        //System.out.println("Look at square");
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
