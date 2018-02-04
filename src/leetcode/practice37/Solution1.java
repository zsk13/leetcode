package leetcode.practice37;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 *  ß∞‹¡À23333
 * @author zsk
 *
 */
public class Solution1 {
    public  static void main(String args[]){
        Solution1 a = new Solution1();
        a.solveSudoku(new char[9][9]);
    }
    public void solveSudoku(char[][] board) {
        board = new char[][]      
                {{'.','.','9','7','4','8','.','.','.'},
                {'7','.','.','.','.','.','.','.','.'},
                {'.','2','.','1','.','9','.','.','.'},
                {'.','.','7','.','.','.','2','4','.'},
                {'.','6','4','.','1','.','5','9','.'},
                {'.','9','8','.','.','.','3','.','.'},
                {'.','.','.','8','.','3','.','2','.'},
                {'.','.','.','.','.','.','.','.','6'},
                {'.','.','.','2','7','5','9','.','.'}}
                ;
        HashSet[][] sets = new HashSet[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sets[i][j] = new HashSet<>();
            }
        }
        List<Character> all = Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9');
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {

                } else {
                    sets[i][j].addAll(all);
                }
            }
        }
        while (true) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("___________________________________________");
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] != '.') {
                        for (int k = 0; k < 9; k++) {
                            sets[i][k].remove(board[i][j]);
                            sets[k][j].remove(board[i][j]);
                        }
                        int starti = i / 3 * 3;
                        int startj = j / 3 * 3;
                        for (int m = 0; m < 3; m++) {
                            for (int n = 0; n < 3; n++) {
                                sets[starti + m][startj + n].remove(board[i][j]);
                            }
                        }
                    } else {
                        if (sets[i][j].size() == 1) {
                            board[i][j] = (char) sets[i][j].toArray()[0];
                        }
                    }
                }
            }
            for(int i=0;i<9;i++){
                int[] num = {0,0,0,0,0,0,0,0,0};
                int[] index = new int[9];
                for(int j=0;j<9;j++){
                    for(char c : all){
                        if(sets[i][j].contains(c)){
                            num[c-'1']++;
                            index[c-'1'] = j;
                        }
                    }                    
                }
                for(int j=0;j<9;j++){
                    if(num[j]==1){
                        board[i][index[j]] = (char)(j+49);
                    }
                }
            }
            for(int i=0;i<9;i++){
                int[] num = {0,0,0,0,0,0,0,0,0};
                int[] index = new int[9];
                for(int j=0;j<9;j++){
                    for(char c : all){
                        if(sets[j][i].contains(c)){
                            num[c-'1']++;
                            index[c-'1'] = j;
                        }
                    }                    
                }
                for(int j=0;j<9;j++){
                    if(num[j]==1){
                        board[index[j]][i] = (char)(j+49);
                    }
                }
            }
            for(int i=0;i<9;i++){
                int[] num = {0,0,0,0,0,0,0,0,0};
                int[] index = new int[9];
                int RowIndex = 3*(i/3);
                int ColIndex = 3*(i%3);
                for(int j=0;j<9;j++){
                    for(char c : all){
                        if(sets[RowIndex + j/3][ColIndex + j%3].contains(c)){
                            num[c-'1']++;
                            index[c-'1'] = j;
                        }
                    }                    
                }
                for(int j=0;j<9;j++){
                    if(num[j]==1){
                        board[RowIndex + index[j]/3][ColIndex + index[j]%3] = (char)(j+49);
                    }
                }
            }
            
            boolean fin = true;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] == '.') {
                        fin = false;
                    }
                }
            }
            if(fin){
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        System.out.print(board[i][j] + " ");
                    }
                    System.out.println();
                }
                return;
            }
        }
    }
}
