package ktsstudio.exint;

import java.util.Vector;

/**
 * Created by penyaev on 12.08.14.
 */
public class Tokens extends Vector<Token> {
    @Override
    public synchronized boolean add(Token token) {
        if (token.getType() == TokenType.WHITESPACE)
            return true;
        return super.add(token);
    }
}
