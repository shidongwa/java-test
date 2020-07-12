package com.stone.train;

/**
 * @Author: shidonghua
 * @Description:
 * @Date: 6/30/20 14:50
 * @Version: 1.0
 */
public class TicTacToe {
    private int[][]arr = new int[3][3];

    /*
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
        0: No one wins.
        1: Player 1 wins.
        2: Player 2 wins.
    */
    public  int move(int row, int col, int player) {
        //棋盘中player 1对应值1， player 2对应值2
        arr[row][col] = player;

        boolean isSuccess = false;
        if(player == 1) {
            isSuccess = isSuccess(1);
        }
        if(!isSuccess) {
            isSuccess = isSuccess(1);
        }

        if(!isSuccess) {
            return 0;
        }

        return 0;
    }

    public boolean isSuccess(int player) {
        // 检查行
        for(int i = 0; i < 3; i++) {
            boolean isSuccess = true;
            for(int j = 0; j < 3; j++) {
                if(arr[i][j] != player) {
                    isSuccess = false;
                    break;
                }
            }
            // 找到一行满足条件
            if(isSuccess) {
                return true;
            }
        }

        // 检查列
        for(int i = 0; i < 3; i++) {
            boolean isSuccess = true;
            for(int j = 0; j < 3; j++) {
                if(arr[j][i] != player) {
                    isSuccess = false;
                    break;
                }
            }
            // 找到一列满足条件
            if(isSuccess) {
                return true;
            }
        }

        boolean isSuccess = true;
        // 检查对角位置
        for(int i = 0; i < 3; i++) {
            if(arr[i][i] != player) {
                isSuccess = false;
                break;
            }
        }

        // 找到一对角满足条件
        if(isSuccess) {
            return true;
        }

        for(int i = 0; i < 3; i++) {
            if(arr[i][2-i] != player) {
                isSuccess = false;
                break;
            }
        }

        return isSuccess;
    }
}
