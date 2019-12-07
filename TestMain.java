package testMain;

import machine.ExaminationMachine;
import person.Student;
import person.Teacher;
import person.User;

import java.util.Arrays;
import java.util.Scanner;

public class TestMain {
    public static void main(String[] args) {
        ExaminationMachine examinationMachine = new ExaminationMachine();
        User user = TestMain.login();
        String[] out = user.operation(examinationMachine.getAnswers());
        System.out.println(Arrays.toString(out));
    }
    private static User login() {
        Scanner input = new Scanner(System.in);
        boolean breakWhile = true;
        User user = new Student("x","0");
        System.out.println("欢迎来到考试系统,请输入你的姓名");
        String name = input.nextLine();
        System.out.println("请输入你的id");
        String id = input.nextLine();
        while (breakWhile) {
            System.out.println("请输入你的身份");
            String login = input.nextLine();
            if (login.equals("学生")) {
                user = new Student(name, id);
                breakWhile = false;
            } else if (login.equals("老师")) {
                user = new Teacher(name, id);
                breakWhile = false;
            }
        }
        return user;
    }
}
