package ktsstudio.exint;


import ktsstudio.exint.symbols.*;
import ktsstudio.exint.symbols.RuntimeException;

/**
 * Created by penyaev on 12.08.14.
 */
public class Interpreter {
    public Symbol run(Bytecode bytecode) throws RuntimeException {
        Symbol symbol;
        SymbolStack runtimeStack = new SymbolStack();
        while (bytecode.size() > 0) {
            symbol = bytecode.remove(0);
            if (symbol instanceof RuntimeOperation) {
                RuntimeOperation operation = (RuntimeOperation) symbol;
                if (runtimeStack.size() < operation.getArgumentsCount()) {
                    throw new ktsstudio.exint.symbols.RuntimeException(operation.getClass().getSimpleName() + " requires " + operation.getArgumentsCount().toString() + " arguments");
                }
                SymbolStack arguments = new SymbolStack();
                for (int i = 0; i < operation.getArgumentsCount(); ++i) {
                    arguments.push(runtimeStack.pop());
                }
                Symbol result = operation.eval(arguments);
                if (result != null) {
                    runtimeStack.push(result);
                }
            } else if (symbol instanceof RuntimeValue) {
                runtimeStack.push(symbol);
            }
        }
        if (runtimeStack.size() > 0) {
            return runtimeStack.pop();
        } else {
            return null;
        }
    }
}
