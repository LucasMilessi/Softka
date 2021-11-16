package prueba.exeptions;

public class PruebaModelException extends RuntimeException {

    public PruebaModelException(String message) {
        super(message);
    }

    public PruebaModelException(String message, Throwable cause) {
        super(message, cause);
    }

}
