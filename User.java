package person;

public abstract class User {

    private String name;
    private String id;

    public User(String name, String id) {
        this.name = name;
        this.id = id;
    }


    public abstract void operation();
}

