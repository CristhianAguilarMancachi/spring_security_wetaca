package bo.edu.ucb.sis213.wetaca.util;

public class WetacaException extends RuntimeException{
    public WetacaException(String message) {
        super(message);
    }

    public WetacaException(String message, Throwable cause) {
        super(message, cause);
    }
}
