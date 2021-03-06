package ktsstudio.exint.symbols;

import ktsstudio.exint.Symbol;
import ktsstudio.exint.SymbolStack;

/**
 * Created by penyaev on 13.08.14.
 */
public class MinusOperator extends Operator {
    protected static MinusOperator instance = null;
    public static MinusOperator getInstance() {
        if (MinusOperator.instance == null) {
            MinusOperator.instance = new MinusOperator();
        }
        return MinusOperator.instance;
    }
    private MinusOperator() {}


    @Override
    public Integer getPriority() {
        return 10;
    }

    @Override
    public Integer getArgumentsCount() {
        return 2;
    }

    @Override
    public Symbol eval(SymbolStack arguments) throws InvalidArgumentException {
        Symbol operand1 = arguments.pop();
        Symbol operand2 = arguments.pop();
        if (!(operand1 instanceof DoubleValue) || !(operand2 instanceof DoubleValue)) {
            throw new InvalidArgumentException("Minus operator requires double");
        }

        DoubleValue dvOperand1 = (DoubleValue) operand1;
        DoubleValue dvOperand2 = (DoubleValue) operand2;

        return new DoubleValue(dvOperand1.getValue() - dvOperand2.getValue());
    }
}

