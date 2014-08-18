package ktsstudio.exint;

import ktsstudio.exint.symbols.IStringifiable;

public class Main {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Please pass mathematical expression as the one and only parameter to this application");
            return;
        }
	    Tokenizer tk = new Tokenizer();
        Tokens tokens = tk.tokenize(args[0]);
        try {
            Compiler compiler = new Compiler();
            Bytecode bytecode = compiler.compile(tokens);
            Interpreter interpreter = new Interpreter();
            Symbol result = interpreter.run(bytecode);

            if (result instanceof IStringifiable) {
                System.out.println(((IStringifiable) result).convertToString());
            }
        } catch (CompilerException e) {
            System.err.printf("Compilation failed: " + e.getClass().getSimpleName() + ": " + e.getSubject() + "\n");
        } catch (ktsstudio.exint.symbols.RuntimeException e) {
            System.err.printf("Runtime error: " + e.getClass().getSimpleName() + ": " + e.getSubject() + "\n");
        }
    }
}
