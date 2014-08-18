package ktsstudio.exint.symbols;

import ktsstudio.exint.Symbol;
import ktsstudio.exint.SymbolStack;

/**
 * Created by penyaev on 13.08.14.
 */
public class MultiplicationOperator extends Operator {
    protected static MultiplicationOperator instance = null;
    public static MultiplicationOperator getInstance() {
        if (MultiplicationOperator.instance == null) {
            MultiplicationOperator.instance = new MultiplicationOperator();
        }
        return MultiplicationOperator.instance;
    }
    private MultiplicationOperator() {}


    @Override
    public Integer getPriority() {
        return 20;
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
            throw new InvalidArgumentException("Multiplication operator requires double");
        }

        DoubleValue dvOperand1 = (DoubleValue) operand1;
        DoubleValue dvOperand2 = (DoubleValue) operand2;

        return new DoubleValue(dvOperand1.getValue() * dvOperand2.getValue());
    }
}
