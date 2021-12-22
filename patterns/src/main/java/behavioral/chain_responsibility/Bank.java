package behavioral.chain_responsibility;

public class Bank extends Account{

    public Bank (float balance, Account next) {
        super (balance, next);
    }
}
