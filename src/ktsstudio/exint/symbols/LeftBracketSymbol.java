package ktsstudio.exint.symbols;

import ktsstudio.exint.Symbol;
import ktsstudio.exint.SymbolStack;

/**
 * Created by penyaev on 13.08.14.
 */
public class LeftBracketSymbol extends RuntimeOperation {
    @Override
    public Integer getArgumentsCount() {
        return 0;
    }

    @Override
    public Symbol eval(SymbolStack arguments) {
        assert false;
        return null;
    }
}
