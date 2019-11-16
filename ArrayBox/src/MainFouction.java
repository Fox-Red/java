public class MainFouction {
    public static void main(String[] args){
        ArrayBox box = new ArrayBox();
        for(int i=0;i<10;i++){
            boolean f = box.add(i*5);
        }
        System.out.println("有效元素的个数是"+box.size());
        for(int i=0;i<box.size();i++){
            int val = box.get(i);
            System.out.println(val+"\t");
        }
        int mid = box.remove(2);
        System.out.println("您要删除的元素是"+mid);
       for(int i=0;i<box.size();i++){
            int val = box.get(i);
            System.out.println(val);
        }
    }
}
