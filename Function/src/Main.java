import java.util.Scanner;

public class Main {
    //后一项是前两项的和
    public static int sum(int n){
        if(n == 0||n == 1){
            return 1;
        }else{
            n = sum(n-1)+sum(n-2);
        }
        return n;
    }
    //求n的阶乘需要传入n，返回factorial
    public static int fac(int n){
        if(n == 1){
            return 1;
        }else{
            n = fac(n-1) * n;
        }
        return n;
    }

    //求差的方法
    public static double sub(double a,double b){
        double c = a - b;
        return c;
    }
    //这里是一个计算阶乘的方法，需要传入一个整形的数据并且返回
    public static int factorial(int n){
        //第一步定义一个变量接收阶乘
        int f = 1;
        for(int i=1; i<=n; i++){
            f *= i;
        }
        return f;
    }

    //主函数
    public static void main(String[] args){
     /*   double a = 4.0;
        double b = 5.0;
        double c = sub(a,b);
        System.out.println(c);

        //需要一个方法来求阶乘
        //定义一个变量来接收值
        int f = 0;
        //让用户输入想要计算的阶乘
        Scanner input = new Scanner;
        int n = input.nextInt();
        //需要一个循环来实现阶乘的和
        for(int i=1; i<=n; i++){
            f += factorial(i);
        }
        System.out.println(f);

        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        System.out.println(fac(num));
      */
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        System.out.println(sum(num));
    }
}

