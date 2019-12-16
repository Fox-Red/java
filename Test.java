import java.lang.reflect.Field;

public class Test {
    public static void main(String[] args) {
        //测试一下反射技术；
        //首先需要一个引用，这里用String代替
        String str = "wjw";
        //假设不知道str的类型,现在要获取str的类类型，类信息和类属性
        //此时获得了str的类类型
        Class cla1 = str.getClass();
        //下面获取他的类名字
        String s1 = cla1.getName();
        //获取他的类简单名
        String s2 = cla1.getSimpleName();
        //获取修饰符
        int p = cla1.getModifiers();
        //获取他的父类
        Class cla2 = cla1.getSuperclass();
        //获取它的接口
        Class[] classes = cla1.getInterfaces();
        //获取它的公有属性和父类的公有属性
//        try {
//            Field f = cla1.getField("value");//getFields()一样就不演示了,value是私有元素，这里只是用来示范的
//            //属性名
//            String s3 = f.getName();
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        }
        try {
            //拿到str的私有属性
            Field f2 = cla1.getDeclaredField("value");
            //现在拿到了str的属性
            //查看一下value的类型
            Class cla3 = f2.getType();
            //将value的私有改成可以被改变的
            f2.setAccessible(true);
            //然后使用get方法得到数组
            char[] chars = (char[])f2.get(str);
            //改变数组的值就可以改变str的值
            chars[0] = '王';
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
