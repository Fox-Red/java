public class Singleton {

    private Singleton (){};

    private volatile Singleton instance = new Singleton();

    public Singleton getInstance() {
        return instance;
    }

}
