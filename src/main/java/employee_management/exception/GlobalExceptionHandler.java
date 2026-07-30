package employee_management.exception;

public class GlobalExceptionHandler extends RuntimeException {
    public GlobalExceptionHandler(String message) {
        super(message);
    }
}
