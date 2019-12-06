package person;

import machine.ExaminationMachine;
import machine.Subject;

public class Student extends User {

    public Student(String name, String id) {
        super(name, id);
    }

    @Override
    public void operation() {
        ExaminationMachine.answerSubject();
    }
}
