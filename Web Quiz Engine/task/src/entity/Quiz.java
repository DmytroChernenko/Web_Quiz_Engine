package entity;

import java.util.Arrays;
import java.util.Objects;

public class Quiz {
    
    private String title;
    private String text;
    private String[] options;

    public Quiz() {
    }

    public Quiz(String title, String text, String[] options) {
        this.title = title;
        this.text = text;
        this.options = options;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quiz quiz = (Quiz) o;
        return title.equals(quiz.title) &&
                text.equals(quiz.text) &&
                Arrays.equals(options, quiz.options);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(title, text);
        result = 31 * result + Arrays.hashCode(options);
        return result;
    }
}
