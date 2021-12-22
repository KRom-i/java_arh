package behavioral.chain_responsibility;

public class Bitcoin extends Account{

    public Bitcoin (float balance, Account next) {
        super (balance, next);
    }
}
