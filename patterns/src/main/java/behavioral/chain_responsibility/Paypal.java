package behavioral.chain_responsibility;

public class Paypal extends Account{

    public Paypal (float balance, Account next) {
        super (balance, next);
    }
}
