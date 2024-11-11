package self.live.exception;


public class LiveException extends RuntimeException {

    public LiveException() {
        super();
    }

    public LiveException(String errorMessage) {
        super(errorMessage);
    }
}
