package ktsstudio.exint.symbols;

import ktsstudio.exint.Symbol;
import ktsstudio.exint.SymbolStack;

/**
 * Created by penyaev on 13.08.14.
 */
public class ExpFunction extends Function {
    protected static ExpFunction instance = null;
    public static ExpFunction getInstance() {
        if (ExpFunction.instance == null) {
            ExpFunction.instance = new ExpFunction();
        }
        return ExpFunction.instance;
    }
    private ExpFunction() {}

    @Override
    public Integer getArgumentsCount() {
        return 1;
    }

    @Override
    public Symbol eval(SymbolStack arguments) throws InvalidArgumentException {
        Symbol operand = arguments.pop();
        if (!(operand instanceof DoubleValue)) {
            throw new InvalidArgumentException("Exp function requires double");
        }

        DoubleValue dvOperand = (DoubleValue) operand;

        return new DoubleValue(Math.exp(dvOperand.getValue()));
    }
}
