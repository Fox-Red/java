import java.io.*;

public class Storage {
    //用来创建学生对象
    private Student Storage(String name, Integer id, String sex, int age) {
        Student stu = new Student(name, id, sex, age);
        return stu;
    }

    //用来将学生的信息写入文件
    public void StorageStudent(String name, Integer id, String sex, int age) {
        //创建一个流
        try {
            FileOutputStream fos = new FileOutputStream(new File("src//student"));
            //用低级流创建高级流
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            //先创建student对象，再用高级流将Student对象写入文件
            oos.writeObject(Storage(name, id, sex, age));
            oos.flush();
            Student.num++;
            System.out.println("存储成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //读出要找的学生对象
    public Student read(int id) {
        FileInputStream fos = null;
        try {
            fos = new FileInputStream(new File("src//student"));
            //用低级流创建高级流
            ObjectInputStream ois = new ObjectInputStream(fos);
            //读出学生信息
            Student stu = (Student) ois.readObject();
            //查找学生
            while (Student.num-- != 0) {
                if (stu.getid() == id) {
                    return stu;
                }
            }
        } catch (Exception e) {
            System.out.println("没找到该学生信息，请重新核对");
        }
        return null;
    }
}
