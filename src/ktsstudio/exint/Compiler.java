package ktsstudio.exint;

import ktsstudio.exint.symbols.Function;
import ktsstudio.exint.symbols.LeftBracketSymbol;
import ktsstudio.exint.symbols.Operator;
import ktsstudio.exint.symbols.RuntimeOperation;

/**
 * Created by penyaev on 12.08.14.
 */
public class Compiler {
    public Bytecode compile(Tokens source) throws CompilerException {
        Bytecode bytecode = new Bytecode();
        RuntimeOperationStack stack = new RuntimeOperationStack();
        for (int tokenIndex = 0; tokenIndex < source.size(); ++tokenIndex) {
            Token token = source.elementAt(tokenIndex);
            Token nextToken;
            try {
                nextToken = source.elementAt(tokenIndex + 1);
            } catch (ArrayIndexOutOfBoundsException e) {
                nextToken = null;
            }

            switch (token.getType()) {
                case NUMBER:
                    bytecode.add(Symbol.createNumber(token));
                    break;
                case SYMBOL:
                    if (nextToken != null && nextToken.getType() == TokenType.BRACKET_LEFT) {
                        stack.push(Symbol.createFunction(token));
                    } else {
                        bytecode.add(Symbol.createConstant(token));
                    }
                    break;
                case BRACKET_LEFT:
                    stack.push(Symbol.createLeftBracket());
                    break;
                case BRACKET_RIGHT:
                    Boolean bracketFound = false;
                    while (stack.size() > 0) {
                        RuntimeOperation symbol = stack.pop();
                        if (!(symbol instanceof LeftBracketSymbol)) {
                            bytecode.add(symbol);
                        } else {
                            bracketFound = true;
                            break;
                        }
                    }
                    if (!bracketFound) {
                        throw new CompilerException("Unbalanced brackets: ')' does not have matching '('");
                    } else {
                        if ((stack.size() > 0) && (stack.peek() instanceof Function)) {
                            bytecode.add(stack.pop());
                        }
                    }
                    break;
                case OPERATOR_LEADING_MINUS:
                case OPERATOR:
                    Operator operator = Symbol.createOperator(token);
                    while (stack.size() > 0) {
                        RuntimeOperation topOperation = stack.peek();
                        if (topOperation instanceof Operator) {
                            Operator topOperator = (Operator) topOperation;
                            if (topOperator.getPriority() >= operator.getPriority()) {
                                bytecode.add(stack.pop());
                            } else {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    stack.push(operator);
                    break;
                case WHITESPACE:
                    continue;
                default:
                    throw new CompilerException("Unexpected token " + token.getString());
            }
        }
        while (stack.size() > 0) {
            RuntimeOperation operation = stack.pop();
            if (operation instanceof LeftBracketSymbol) {
                throw new CompilerException("Unbalanced brackets: '(' does not have matching ')'");
            }
            bytecode.add(operation);
        }

        return bytecode;
    }
}
