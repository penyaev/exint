package ktsstudio.exint.symbols;

import ktsstudio.exint.Symbol;
import ktsstudio.exint.SymbolStack;

/**
 * Created by penyaev on 13.08.14.
 */
public class SinFunction extends Function {
    protected static SinFunction instance = null;
    public static SinFunction getInstance() {
        if (SinFunction.instance == null) {
            SinFunction.instance = new SinFunction();
        }
        return SinFunction.instance;
    }
    private SinFunction() {}

    @Override
    public Integer getArgumentsCount() {
        return 1;
    }

    @Override
    public Symbol eval(SymbolStack arguments) throws InvalidArgumentException {
        Symbol operand = arguments.pop();
        if (!(operand instanceof DoubleValue)) {
            throw new InvalidArgumentException("Sin function requires double");
        }

        DoubleValue dvOperand = (DoubleValue) operand;

        return new DoubleValue(Math.sin(dvOperand.getValue()));
    }
}
