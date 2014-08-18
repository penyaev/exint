package ktsstudio.exint.symbols;

import ktsstudio.exint.Symbol;
import ktsstudio.exint.SymbolStack;

/**
 * Created by penyaev on 13.08.14.
 */
public class LeadingMinusOperator extends Operator {
    protected static LeadingMinusOperator instance = null;
    public static LeadingMinusOperator getInstance() {
        if (LeadingMinusOperator.instance == null) {
            LeadingMinusOperator.instance = new LeadingMinusOperator();
        }
        return LeadingMinusOperator.instance;
    }
    private LeadingMinusOperator() {}

    @Override
    public Integer getPriority() {
        return 50;
    }

    @Override
    public Integer getArgumentsCount() {
        return 1;
    }

    @Override
    public Symbol eval(SymbolStack arguments) throws InvalidArgumentException {
        Symbol operand = arguments.pop();
        if (!(operand instanceof DoubleValue)) {
            throw new InvalidArgumentException("Minus operator requires double");
        }
        DoubleValue dvOperand = (DoubleValue) operand;
        return new DoubleValue(-dvOperand.getValue());
    }
}
