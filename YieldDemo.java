public class YieldDemo {
    public static void main(String[] args) {
        Thread thread1 = new Thread("自私的人"){
            public void run() {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + "在唱歌");
                }
            }
        };
        Thread thread2 = new Thread("无私的人"){
            public void run() {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + "在唱歌");
                    yield();
                }
            }
        };
        thread1.start();
        thread2.start();
    }
}
