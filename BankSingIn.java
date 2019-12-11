import java.io.*;
import java.rmi.server.ExportException;
import java.util.ArrayList;

public class BankSingIn implements Serializable {
    private long serialVersionUID = 912215447995848244L;
    //账户对象
    private class User implements Serializable {
        private long serialVersionUID = 5354377876410543341L;
        private String name;
        private String password;
        private int balance;
        User(String name, String password, int balance) {
            this.balance = balance;
            this.name = name;
            this.password = password;
        }
    }

    public void readUser (String path) {

        try {
            FileInputStream fis = new FileInputStream(path);
            //定义一个对象输入流来得到集合
            if (fis.read() != -1) {
                ObjectInputStream ois = new ObjectInputStream(fis);
                //取得集合
                ArrayList<ArrayList<String>> users = (ArrayList<ArrayList<String>>) ois.readObject();
                for (ArrayList<String> s: users) {
                    for (String s2 : s) {
                        System.out.println(s2);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("捕获的了异常");
            e.printStackTrace();
        }
    }

    public void writeUesr(String path, User user) {
        ArrayList<ArrayList<String>> users = new ArrayList<ArrayList<String>>();
        ArrayList<String> list = new ArrayList<>();
        list.add(user.name);
        list.add(user.password);
        list.add("" + user.balance);
        users.add(list);
        try {
            //定义一个低级的文件输出流并确保是在文件后面增加而不是覆盖文件原内容
            FileOutputStream fos = new FileOutputStream(path, true);
            //用低级文件输出流来构建一个对象输出流
            ObjectOutputStream oof = new ObjectOutputStream(fos);
            //用bof来将用户以对象的形式存储
            oof.writeObject(users);
            System.out.println("开户成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //开户的方法
    public User ceartUser (String name, String password, int balance) {
        //创建一个用户对象
        return new User(name, password, balance);
    }

    //复用的验证用户名和密码的方法，需要返回所有的对象，以便后续操作
//    private ArrayList<User> verification(String name, String password) {
//        //定义一个容器来存放取出来的用户对象
//        ArrayList<User> users = new ArrayList<>();
//        try {
//            //定义一个低级文件输入流来读取所有的对象
//            File file = new File("F:\\User.txt");
//            FileInputStream fis = new FileInputStream(file);
//            //定义一个对象输入流来获取每个用户对象
//            ObjectInputStream ois = new ObjectInputStream(fis);
//            users.add((User) ois.readObject());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
