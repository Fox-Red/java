public class ArrayBox {
    //1.必须存在一个数组来接收元素
    private int[] a = new int[10];
    private int size = 0;
    //E方法
    private void removeElement(int index){
        for(int i=index;i<size-1;i++){
            a[i] = a[i+1];
        }
        a[--size] = 0;
    }
    //D方法
    private void rangeChack(int index){
        if(index < 0||index > a.length){
            throw new BoxIndexOutOfBoundsException("Index:"+index+",Size:"+size);
        }
    }
    //C方法
    private int[] copyarray(int[] newarray,int[] oldarry){
        for(int i=0;i<a.length;i++){
            newarray[i] = oldarry[i];
        }
        //清空旧的数组，减少内存占用
        oldarry = null;
        //返回新的数组地址，保持a中的地址指向新的数组
        return newarray;
    }
    //B方法
    private int[] changecapacity(int mincapacity){
        //创建一个新的更大的数组来保存新的值
        int[] mid = new int[mincapacity+size];
        //需要把a数组的值放进b数组里，创建一个方法c来进行
        int[] newarrytwo = this.copyarray(mid,a);
        //需要把新的数组返回
        return newarrytwo;
    }
    //A方法
    private void arraycapacity(int mincapacity){
        if(mincapacity > a.length){
            //4需要扩容，创建一个B方法来实现
            a = this.changecapacity(mincapacity);
        }
    }
//=====================================================================================
    //用来给数组添加元素
    public boolean add(int x){
        //3查看数组空间是否够用，创建一个A方法来实现
        this.arraycapacity(size+1);
        //存储新元素
        a[size++] = x;
        //告知用户数据存储成功
        return true;
    }
    public int size(){
        return size;
    }
    public int get(int index){
        //要想取出数组元素，首先需要一个索引，一个数组
        //检查索引是否合法，创建一个D方法
        this.rangeChack(index);
        //能执行说明索引没问题
        int valueTwo = a[index];
        return valueTwo;
    }
    public int remove(int index){
        //先检查要删除的元素是否存在，使用D方法进行判断
        this.rangeChack(index);
        //先将要删除的元素存储，告诉用户要删除的元素
        int temp = a[index];
        //如果上面执行通过代表可以执行删除，使用E方法进行删除元素
        this.removeElement(index);

        return temp;
    }
}
