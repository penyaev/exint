package ktsstudio.exint;

import ktsstudio.exint.symbols.*;

/**
 * Created by penyaev on 12.08.14.
 */
public class Symbol {
    public static RuntimeValue createNumber(Token token) throws SymbolException {
        try {
            return new DoubleValue(Double.parseDouble(token.getString()));
        } catch (NumberFormatException ignored) {}

        throw new SymbolException(token.getString() + " is not a number");
    }

    public static RuntimeOperation createFunction(Token token) throws SymbolException {
        if (token.getString().equals("print")) {
            return PrintFunction.getInstance();
        } else if (token.getString().equals("exp")) {
            return ExpFunction.getInstance();
        } else if (token.getString().equals("sin")) {
            return SinFunction.getInstance();
        } else if (token.getString().equals("cos")) {
            return CosFunction.getInstance();
        }
        throw new SymbolException(token.getString() + " is not a function");
    }

    public static RuntimeValue createConstant(Token token) throws SymbolException {
        if (token.getString().equals("PI")) {
            return new DoubleValue(Math.PI);
        } else if (token.getString().equals("E")) {
            return new DoubleValue(Math.E);
        }
        throw new SymbolException(token.getString() + " is not a constant");
    }

    public static LeftBracketSymbol createLeftBracket() {
        return new LeftBracketSymbol();
    }

    public static Operator createOperator(Token token) throws SymbolException {
        if (token.getType() == TokenType.OPERATOR_LEADING_MINUS) {
            return LeadingMinusOperator.getInstance();
        } else if (token.getString().equals("+")) {
            return PlusOperator.getInstance();
        } else if (token.getString().equals("-")) {
            return MinusOperator.getInstance();
        } else if (token.getString().equals("*")) {
            return MultiplicationOperator.getInstance();
        } else if (token.getString().equals("/")) {
            return DivisionOperator.getInstance();
        }

        throw new SymbolException(token.getString() + " is not an operator");
    }
}
