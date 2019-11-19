public class Counter {
    public int count(int a,String flag,int b){//接收参数
        int temp = a / b;//定义一个变量记录最后返回值
        if(flag.equals("+")){//判断如果输入加号则进行加计算
            temp = a + b;
        }
        if(flag.equals("-")){//判断如果输入减号则进行减计算
            temp = a - b;
        }
        if(flag.equals("*")){//判断如果输入乘号则进行乘计算
            temp = a * b;
        }
        return temp;
    }
}
