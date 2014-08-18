package ktsstudio.exint;

/**
 * Created by penyaev on 12.08.14.
 */
public class CompilerException extends ExintException {
    private String subject;

    public CompilerException(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }
}
