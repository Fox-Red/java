package machine;

import java.util.*;

public class ExaminationMachine {
    private List<Subject> answers = new ArrayList<>();

    {
        answers.add(new Subject("以下选项哪个是Java基本数据类型?\n\tA.String\n\tB.Integer\n\tC.boolean\n\tD.Math","C"));
        answers.add(new Subject("以下选项哪个不是Java基本数据类型?\n\tA.String\n\tB.int\n\tC.boolean\n\tD.double","A"));
        answers.add(new Subject("以下选项哪个是Java引用数据类型?\n\tA.String\n\tB.int\n\tC.boolean\n\tD.char","A"));
        answers.add(new Subject("以下选项哪个不是Java引用数据类型?\n\tA.String\n\tB.Integer\n\tC.boolean\n\tD.Math","C"));
        answers.add(new Subject("以下选项哪个是java.util包中的类?\n\tA.String\n\tB.Integer\n\tC.Scanner\n\tD.Math","C"));
        answers.add(new Subject("以下选项哪个不是java.util包中的类?\n\tA.Date\n\tB.Integer\n\tC.Calendar\n\tD.Random","B"));
        answers.add(new Subject("以下选项哪个不是String类中的方法?\n\tA.compareTo\n\tB.append\n\tC.substring\n\tD.concat","B"));
        answers.add(new Subject("以下选项哪个是String类中方法?\n\tA.append\n\tB.delete\n\tC.insert\n\tD.concat","D"));
        answers.add(new Subject("以下选项哪个不是接口中属性的修饰符?\n\tA.public\n\tB.static\n\tC.final\n\tD.abstract","D"));
        answers.add(new Subject("以下选项哪个不是Set集合的方法?\n\tA.set\n\tB.add\n\tC.remove\n\tD.iterator","A"));
    }

    public List<Subject> getAnswers() {
        return this.answers;
    }

    public String[] answerSubject() {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        Set<Subject> set = new HashSet<>();
        while (set.size() < 5) {
            set.add(answers.get(random.nextInt(answers.size() - 1)));
        }
        String[] answers = new String[set.size()];
        List<Subject> subjects = new ArrayList<>(set);
        for (int i = 0; i < subjects.size(); i++) {
            System.out.println(i + 1 + "." + subjects.get(i));
            System.out.println("请输入答案");
            answers[i] = input.nextLine();
        }
        return answers;
    }
}
