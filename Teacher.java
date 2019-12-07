package person;

import machine.ExaminationMachine;
import machine.Subject;

import java.util.*;

public class Teacher extends User {

    public Teacher(String name, String id) {
        super(name, id);
    }

    public void Add(List<Subject> subjects) {//老师的操作，添加题目，由于进行了解引用，所以不需要返回值，直接修改
        Scanner input = new Scanner(System.in);
            System.out.println("请输入题目");
            String title = input.nextLine();
            System.out.println("请输入这道题的正确答案");
            String answer = input.nextLine();
            subjects.add(new Subject(title,answer));
    }

    public ArrayList<Subject> remove(List<Subject> subjects) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入要删除的题目");
        String title = input.nextLine();
        HashSet<Subject> hashSet = new HashSet<>(subjects);//将顺序表转化成HashSet表，方便查找删除,
        hashSet.remove(title);
        return new ArrayList<Subject>(hashSet);//由于拷贝的表无法改变原表，所以返回新的顺序表
    }

    public int judge(List<Subject> subjects , String[] answers) {
        int scero = 0;
        for (int i = 0; i < answers.length; i++) {
            if (subjects.get(i).getAnswer().equals(answers[i])) {
                scero += 20;
            }
        }
        return 20;
    }
    private int mune() {
        Scanner input = new Scanner(System.in);
        System.out.println("尊敬的" + super.getName() + "老师，请选择你要进行的操作");
        System.out.println("1.增加题目");
        System.out.println("2.减少题目");
        System.out.println("3.批改题目");
        return input.nextInt();
    }
}
