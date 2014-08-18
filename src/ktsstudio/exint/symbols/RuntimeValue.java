package ktsstudio.exint.symbols;

import ktsstudio.exint.Symbol;

/**
 * Created by penyaev on 13.08.14.
 */
public abstract class RuntimeValue<E> extends Symbol {
    private E value;

    public E getValue() {
        return value;
    }

    protected RuntimeValue(E value) {
        this.value = value;
    }
}
