package ktsstudio.exint.symbols;

import ktsstudio.exint.Symbol;
import ktsstudio.exint.SymbolStack;

/**
 * Created by penyaev on 13.08.14.
 */
public abstract class RuntimeOperation extends Symbol {
    public abstract Integer getArgumentsCount();
    public abstract Symbol  eval(SymbolStack arguments) throws InvalidArgumentException;
}
