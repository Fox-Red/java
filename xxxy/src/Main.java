class Person{
    private String name;
    private int high;
    private int age;
    private int weigh;

    public int getWeigh() {
        return weigh;
    }

    public void setWeigh(int weigh) {
        this.weigh = weigh;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void eat () {
        System.out.println(name + "可以吃饭");
    }
    public void run () {
        System.out.println(name + "可以跑步");
    }
    public void sandOut () {
        System.out.println(name + "可以吃饭");
    }
}
public class Main {
}
