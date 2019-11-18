public class UserEntry {
    //需要输入两个字符；比较是否正确；不需要返回值；
    public void UserTest(String name,String password){
        //定义一个判断是否输出对不起用户名或密码错误的变量
        boolean k = true;
        //1比较用户名是否正确
        String[][] userNum = {{"王继文","123"},{"西安工业大学","666"},{"陕西","888"}};//存储的数据
        for(int i=0;i<3;i++){//依次用户名的循环
            if(userNum[i][0] == name){//判断是否用户名正确
                if(userNum[i][1] == password){//判断密码是否正确
                    System.out.println("恭喜你登录成功");
                    k = false;
                    break;
                }
            }

        }
        if(k){
            System.out.println("对不起,用户名或密码错误的变量");
        }

    }
}
