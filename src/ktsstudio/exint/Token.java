package ktsstudio.exint;

/**
 * Created by penyaev on 12.08.14.
 */
public class Token {
    private String string;
    private TokenType type;

    public Token(String string, TokenType type) {
        this.string = string;
        this.type = type;
    }

    public String getString() {
        return string;
    }

    public TokenType getType() {
        return type;
    }
}
