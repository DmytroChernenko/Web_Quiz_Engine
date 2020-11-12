package entity;

import java.util.Objects;

public class Response {
    private boolean success;
    private String feedback;

    public Response() {
    }

    public Response(boolean success, String feedback) {
        this.success = success;
        this.feedback = feedback;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Response response = (Response) o;
        return success == response.success &&
                feedback.equals(response.feedback);
    }

    @Override
    public int hashCode() {
        return Objects.hash(success, feedback);
    }
}
