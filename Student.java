package person;

import machine.ExaminationMachine;
import machine.Subject;

import java.util.List;

public class Student extends User {

    public Student(String name, String id) {
        super(name, id);
    }

    public String[] operation(List<Subject> subjects) {
        ExaminationMachine examinationMachine = new ExaminationMachine();
        String[] answers = examinationMachine.answerSubject();
        return answers;
    }
}
