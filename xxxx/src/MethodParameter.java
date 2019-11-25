import java.util.Arrays;

public class MethodParameter {
    //冒泡排序的方法
    public static void BubbleSort(int[] a) {
        //第一个for循环决定冒泡次数
        for (int i=0; i<a.length-1; i++) {
            //第二层来执行冒泡
            for (int j=0; j<a.length-i-1; j++) {
                if (a[j] > a[j+1]) {
                    int tem = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tem;
                }
            }
        }
    }
    public static void BubbleSort2(int[] a) {
        //第一个for循环决定冒泡次数
        for (int i=0; i<a.length-1; i++) {
            //第二层来执行冒泡
            for (int j=1; j<a.length-i; j++) {
                if (a[j-1] > a[j]) {
                    int tem = a[j];
                    a[j] = a[j-1];
                    a[j-1] = tem;
                }
            }
        }
    }
    //二分查找的方法
    public static int BinarySearch(int[] a,int index) {
        int left = 0;
        int right = a.length-1;
        while (left <= right) {
            int temp = (right + left)/2;
            if (a[temp] == index) {
                return temp;
            }else if (a[temp] < index) {
                left = temp + 1;
            }else {
                right = temp - 1;
            }
        }
        return -1;
    }
    //辅助新数组的方法
    public static int[] CopyOf(int[] a,int length){
        int[] newArray = new int[length];
        for (int i=0; i<length; i++) {
            if (i < a.length) {
                newArray[i] = a[i];
            }else {
                break;
            }
        }
        return newArray;
    }
    //复制数组
    public static int[] copyOfRange(int[] a, int from, int to) {
        int[] newArray = new int[to - from];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = a[from];
            from++;
        }
        return newArray;
    }
    public static void main(String[] args) {
        //需要一个数组
        int[] ar1 = { 1, 2, 3, 4, 5, 7, 9};
//        //需要一个方法来实现冒泡排序
//        BubbleSort2(ar1);
//        System.out.println(Arrays.toString(ar1));
        //需要一个方法来实现二分查找
//        int x = BinarySearch(ar1,5);
//        System.out.println(x);
        //需要一个方法来辅助数组；
//        int[] x = CopyOf(ar1,12);
//        System.out.println(Arrays.toString(x));
        //需要一个方法区完成数组复制
    }
}
