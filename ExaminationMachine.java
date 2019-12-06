package machine;

import java.lang.reflect.Array;
import java.util.*;

public class ExaminationMachine {
    private static String[] answer = new String[5];

    public static void addSubject() {
        boolean continueAdd = true;
        Scanner input = new Scanner(System.in);
        while (continueAdd) {
            Subject.add();
            System.out.println("是否还要继续增加题目？请输入true或false");
            continueAdd = input.nextBoolean();
        }
    };
    public static void correction() {};
    public static void answerSubject() {
        Scanner input = new Scanner(System.in);
        HashMap<String, HashMap<String, String>> subject=  Subject.getSubject();
        Set<String> set = subject.keySet();
        List<String> list = new ArrayList<>(set);
        HashSet<Integer> getElementArray = new HashSet<>(5);
        Random random = new Random();
        for (int i = 1; i <= 5;) {
            Integer x = random.nextInt(list.size() + 1);
            getElementArray.add(x);
            i = getElementArray.size();
        }
        List<Integer> subList = new ArrayList<>(getElementArray);
        for (int i = 0; i < 5; i++) {
            System.out.println(list.get(subList.get(i)));
            System.out.println("请输入答案");
            answer[i] = input.nextLine();
        }
    }
}
