import java.sql.SQLOutput;
import java.util.Scanner;

public class UserMain {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("请输入第一个数");
        int x = input.nextInt();
        while(true){
            System.out.println("请输入计算的符号，如+ - * /");
            String f = input.next();
            System.out.println("请输入下一个数");
            int y = input.nextInt();
            Counter result = new Counter();
            x = result.count(x,f,y);
            System.out.println(x);
        }
    }
}
