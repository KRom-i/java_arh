package behavioral.chain_responsibility;

abstract class Account {

    private final float balance;
    private final Account next;

    public Account (float balance, Account next) {
        this.balance = balance;
        this.next = next;
    }

    public void pay (float amountToPay) {
        if (canPay (amountToPay)) {
            System.out.printf ("Paid %s using %s\n", amountToPay, getClass ().getName ());
        } else if (next != null) {
            System.out.printf ("Cannot pay using %s. Proceeding ..\n", getClass ().getName ());
            next.pay (amountToPay);
        } else {
            throw new RuntimeException ("None of the accounts have enough balance");
        }
    }

    private boolean canPay (float amountToPay) {
        return this.balance >= amountToPay;
    }

}
