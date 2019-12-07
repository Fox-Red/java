package machine;

public class Subject {
    private String title;
    private String answer;

    public Subject (String title, String answer) {
        this.answer = answer;
        this.title = title;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public String toString() {
        return title;
    }
}
