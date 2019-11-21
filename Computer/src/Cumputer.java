public class Cumputer {
    //电脑具有开和关两种属性和自己的编号，具有被打开，被使用中，被关闭的方法
    //属性
    private int num;
    private boolean status;
    //构造方法
    public Cumputer(){}
    public Cumputer(int num){
        this.num = num;
    }
    //设计两个方法获取电脑的编号和状态
    public int getNum(){
        return this.num;
    }
    public boolean getStatus(){
        return this.status;
    }
    //描述三种电脑的方法
    public boolean beOpen(){//电脑被打开的方法
        status = true;
        System.out.println("电脑被打开啦");
        return status;
    }
    public boolean isUsing(){//电脑被使用中的方法
        System.out.println("电脑正在被使用中");
        return status;
    }
    public boolean beClose(){//点被关闭的方法
        status = false;
        System.out.println("电脑被关闭啦");
        return status;
    }

}
