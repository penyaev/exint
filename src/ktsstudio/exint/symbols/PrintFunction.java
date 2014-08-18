package ktsstudio.exint.symbols;

import ktsstudio.exint.Symbol;
import ktsstudio.exint.SymbolStack;

/**
 * Created by penyaev on 13.08.14.
 */
public class PrintFunction extends Function {
    protected static PrintFunction instance = null;
    public static PrintFunction getInstance() {
        if (PrintFunction.instance == null) {
            PrintFunction.instance = new PrintFunction();
        }
        return PrintFunction.instance;
    }
    private PrintFunction() {}

    @Override
    public Integer getArgumentsCount() {
        return 1;
    }

    @Override
    public Symbol eval(SymbolStack arguments) throws InvalidArgumentException {
        Symbol operand = arguments.pop();
        if (!(operand instanceof IStringifiable)) {
            throw new InvalidArgumentException("Value is unprintable");
        }
        System.out.println(((IStringifiable) operand).convertToString());
        return null;
    }
}
