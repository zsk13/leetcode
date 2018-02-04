package leetcode.practice36;

import java.util.HashSet;

public class Solution1 {
    public boolean isValidSudoku(char[][] board) {
        HashSet row = new HashSet<Character>();
        HashSet column = new HashSet<Character>();
        for(int i =0;i<9;i++){
            row.clear();
            column.clear();
            for(int j = 0;j<9;j++){
                if(board[i][j]!='.'&&!row.add(board[i][j])){
                    return false;
                }
                if(board[j][i]!='.'&&!column.add(board[j][i])){
                    return false;
                }
            }
        }
        HashSet cube = new HashSet<Character>();
        for(int i = 0;i<9;i++){
            cube.clear();
            int starti = i/3 *3;
            int startj = i%3 *3;
            for(int m = 0;m<3;m++)
                for(int n=0;n<3;n++)
                    if(board[starti+m][startj+n]!='.'&&!cube.add(board[starti+m][startj+n])){
                        return false;
                    }
        }
        return true;
    }
}
