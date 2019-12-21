package Leetcode;

public class Solution2 {
    public boolean canThreePartsEqualSum(int[] A) {
        int first = 0;
        for (int i = 0; i < A.length; i++) {
            int second = 0;
            int third = 0;

            first += A[i];
            int k = i + 1;
            for (; k < A.length; k++) {
                second += A[k];
                if (first == second) {
                    break;
                }
            }
            for (int l = k + 1; l < A.length; l++) {
                third += A[l];
            }
            if (first == second && second == third) {
                return true;
            }
        }
        return false;
    }
}
