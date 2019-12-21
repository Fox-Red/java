package Leetcode;

public class Solution2_simple {
    public boolean canThreePartsEqualSum(int[] A) {
        //先求出平均属
        int sum = summation(0, A);
        int average = sum / 3;
        int first = 0;
        for (int i = 0; i < A.length; i++) {
            int second = 0;
            int third = 0;

            first += A[i];
            if (first == average && summation(i + 1, A) / 2 == average) {
                for (int j = i + 1; j < A.length; j++) {
                    second += A[j];
                    if (second == average && summation(j + 1, A) == average) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //求和的方法
    private int summation(int index, int[] array) {
        int sum = 0;
        for (int i = index; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }
}
