package ktsstudio.exint.symbols;

import ktsstudio.exint.Symbol;
import ktsstudio.exint.SymbolStack;

/**
 * Created by penyaev on 13.08.14.
 */
public class CosFunction extends Function {
    protected static CosFunction instance = null;
    public static CosFunction getInstance() {
        if (CosFunction.instance == null) {
            CosFunction.instance = new CosFunction();
        }
        return CosFunction.instance;
    }
    private CosFunction() {}

    @Override
    public Integer getArgumentsCount() {
        return 1;
    }

    @Override
    public Symbol eval(SymbolStack arguments) throws InvalidArgumentException {
        Symbol operand = arguments.pop();
        if (!(operand instanceof DoubleValue)) {
            throw new InvalidArgumentException("Cos function requires double");
        }

        DoubleValue dvOperand = (DoubleValue) operand;

        return new DoubleValue(Math.cos(dvOperand.getValue()));
    }
}
