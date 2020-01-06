public class SingletonTest {
    private volatile SingletonTest instence = new SingletonTest();
    private SingletonTest() {};
    public SingletonTest getInstence() {
        if (instence == null) {
            instence = new SingletonTest();
        }
        return instence;
    }
}
