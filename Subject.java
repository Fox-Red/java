package machine;

import java.util.HashMap;
import java.util.Scanner;

public class Subject {
    private static HashMap<String, HashMap<String, String>> subject = new HashMap<>();
    {
        HashMap<String, String> choose = new HashMap<>();
        choose.put("A", "short");
        choose.put("B", "boolean");
        choose.put("C", "String");
        choose.put("D", "char");
        subject.put("1.以下哪个选项不是Java的基本类型?", choose);
    }

    public static HashMap<String, HashMap<String, String>> getSubject() {
        return subject;
    }

    public static void add() {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入题目");
        String newSubject = input.nextLine();
        System.out.println("请输入A选项答案");
        String A = input.nextLine();
        System.out.println("请输入B选项答案");
        String B = input.nextLine();
        System.out.println("请输入C选项答案");
        String C = input.nextLine();
        System.out.println("请输入D选项答案");
        String D = input.nextLine();
        HashMap<String, String> temp = new HashMap<>();
        temp.put("A", A);
        temp.put("B", B);
        temp.put("C", C);
        temp.put("D", D);
        subject.put(newSubject, temp);
    }
    public void sub() {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入要删除的题目");
        String removeSubject = input.nextLine();
        subject.remove(removeSubject);
    }
}
