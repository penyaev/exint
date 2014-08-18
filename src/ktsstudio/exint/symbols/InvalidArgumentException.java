package ktsstudio.exint.symbols;

/**
 * Created by penyaev on 13.08.14.
 */
public class InvalidArgumentException extends RuntimeException {
    public InvalidArgumentException(String subject) {
        super(subject);
    }
}
