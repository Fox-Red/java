import java.io.Serializable;

public class Student implements Serializable {
    //学生的属性
    private long serialVersionUID = -440948515215806088L;
    //姓名
    private String name;
    //学号
    private Integer id;
    //性别
    private String sex;
    //年龄
    private int age;
    //构造方法
    public Student(String name, Integer id, String sex, int age) {
        this.age = age;
        this.id = id;
        this.name = name;
        this.sex = sex;
    }

    public int getid() {
        return this.id;
    }
    //toString方法，方便打印
    @Override
    public String toString() {
        return "Student{" +
                "serialVersionUID=" + serialVersionUID +
                ", name='" + name + '\'' +
                ", id=" + id +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}
