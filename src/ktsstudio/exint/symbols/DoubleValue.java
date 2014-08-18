package ktsstudio.exint.symbols;

import java.util.Locale;

/**
 * Created by penyaev on 13.08.14.
 */
public class DoubleValue extends RuntimeValue<Double> implements IStringifiable {
    public DoubleValue(Double value) {
        super(value);
    }

    @Override
    public String convertToString() {
        return String.format(Locale.ENGLISH, "%.5f", this.getValue());
    }
}
