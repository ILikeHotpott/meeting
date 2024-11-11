package self.live.entity.bo;


public class ExceptionBo {
    private int status;
    private String message;

    public ExceptionBo(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ExceptionBo{" +
                "statue=" + status +
                ", message='" + message + '\'' +
                '}';
    }
}
