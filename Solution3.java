package Leetcode;

import java.util.*;

public class Solution3 {
    public int findJudge(int N, int[][] trust) {
        //法官的入度和出度之和为n-1
        //用cur来记录出入度
        int[] cur = new int[N + 1];
        for (int[] val : trust) {
            cur[val[0]]--;//出度
            cur[val[1]]++;//入度
        }
        for (int i = 1; i <= N; i++) {
            if (cur[i] == N - 1){
                return i;
            }
        }
        return -1;
    }
}
