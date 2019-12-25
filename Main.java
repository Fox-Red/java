import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请选择操作");
        System.out.println("1.添加学生信息");
        System.out.println("2.查找学生信息");
        int choose = input.nextInt();
        if (choose == 1) {
            System.out.println("请输入学生姓名");
            String name = input.next();
            System.out.println("请输入学生学号");
            int id = input.nextInt();
            System.out.println("请输入学生年龄");
            int age = input.nextInt();
            System.out.println("请输入学生性别");
            String sex = input.next();
            new Storage().StorageStudent(name, id, sex, age);
        }
        if (choose == 2) {
            System.out.println("请输入要查找学生的学号");
            int id = input.nextInt();
            Student stu = new Storage().read(id);
            System.out.println(stu);
        }
    }
}
