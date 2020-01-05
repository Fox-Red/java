public class Singleton2 {
    private Singleton2 (){};

    private volatile Singleton2 instance = null;

    public Singleton2 getInstance() {
        if (instance == null) {
            synchronized(Singleton2.class) {
                if (instance == null) {
                    instance = new Singleton2();
                }
            }
        }

        return instance;
    }

}
