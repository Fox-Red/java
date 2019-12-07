package person;

import machine.ExaminationMachine;
import machine.Subject;

import java.util.List;

public  class User {

    private String name;
    private String id;

    public User(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public String[] operation(List<Subject> subjects){return null;}
}

