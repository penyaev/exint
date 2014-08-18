package ktsstudio.exint.symbols;

import ktsstudio.exint.ExintException;

/**
 * Created by penyaev on 13.08.14.
 */
public class RuntimeException extends ExintException {
    private String subject;

    public RuntimeException(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }
}
