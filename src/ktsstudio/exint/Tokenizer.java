package ktsstudio.exint;

/**
 * Created by penyaev on 12.08.14.
 */
public class Tokenizer {
    private TokenType getTokenTypeByFirstLetter(char c, Token previousToken) {
        if (Character.isLetter(c)) {
            return TokenType.SYMBOL;
        } else if (((previousToken == null) || (previousToken.getType() == TokenType.BRACKET_LEFT)) && (c == '-')) { // special case for negative numbers
            return TokenType.OPERATOR_LEADING_MINUS;
        } else if (Character.isDigit(c) || c == '.') {
            return TokenType.NUMBER;
        } else if ((c == '+') || (c == '-') || (c == '*') || (c == '/')) {
            return TokenType.OPERATOR;
        } else if (c == '(') {
            return TokenType.BRACKET_LEFT;
        } else if (c == ')') {
            return TokenType.BRACKET_RIGHT;
        } else if (Character.isWhitespace(c)) {
            return TokenType.WHITESPACE;
        } else {
            return TokenType.UNKNOWN;
        }
    }

    private Boolean isValidLetterForTokenType(char c, TokenType tokenType) {
        switch (tokenType) {
            case SYMBOL:
                return Character.isLetter(c) || Character.isDigit(c);
            case NUMBER:
                return Character.isDigit(c) || (c == '.') || (c == 'e');
            case OPERATOR:
                return (c == '+') || (c == '-') || (c == '*') || (c == '/');
            case WHITESPACE:
                return Character.isWhitespace(c);
            case BRACKET_LEFT:
            case BRACKET_RIGHT:
            default:
                return false;
        }
    }

    public Tokens tokenize(String source) {
        Tokens tokens = new Tokens();

        String currentTokenString = "";
        TokenType currentTokenType = TokenType.UNKNOWN;
        Token previousToken = null;

        for (int i = 0; i < source.length(); ++i) {
            char c = source.charAt(i);

            if (currentTokenString.isEmpty()) {
                currentTokenType = this.getTokenTypeByFirstLetter(c, previousToken);
                currentTokenString = currentTokenString.concat(Character.toString(c));
            } else {
                if (this.isValidLetterForTokenType(c, currentTokenType)) {
                    currentTokenString = currentTokenString.concat(Character.toString(c));
                } else {
                    previousToken = new Token(currentTokenString, currentTokenType);
                    tokens.add(previousToken);
                    currentTokenString = Character.toString(c);
                    currentTokenType = this.getTokenTypeByFirstLetter(c, previousToken);
                }
            }
        }
        if (!currentTokenString.isEmpty()) {
            tokens.add(new Token(currentTokenString, currentTokenType));
        }

        return tokens;
    }
}
