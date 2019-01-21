package cu.cyrbes;

public class AppException extends RuntimeException{

    /**
     *  Constructor
     */
    public AppException() {
        super();
    }

    /**
     * Constructor
     *
     * @param message: mensaje de error a mostrar
     */
    public AppException(String message) {
        super(message);
    }

    /**
     * Constructor
     *
     * @param message
     * @param cause
     */
    public AppException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor
     *
     * @param cause
     */
    public AppException(Throwable cause) {
        super(cause);
    }
}
