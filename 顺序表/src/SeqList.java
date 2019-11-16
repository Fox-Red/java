public class SeqList {
    //定义属性来存放元素和记录元素个数
    private int size = 0;
    private int[] data = new int[10];
    //首先顺序打印列表
    public void disPlay(int[] a){
        for (int value: a) {
            System.out.println(value);
        }
    }
    //在pos位置新增元素
    public void add(int pos, int data){
        //如果pos小于0或大于size则表示出现异常
        if ( pos < 0 || pos > size ) {
            return;
        }
        //如果pos为尾元素，直接将其添加在最后一个位置
        if ( pos == size) {
            this.data[size] = data;
            size++;
        }else {//否则为插入到数组中间，即为将该位置元素及后续元素依次后移
            for (int i=pos; i<size; i++) {

            }
        }
    }
}
