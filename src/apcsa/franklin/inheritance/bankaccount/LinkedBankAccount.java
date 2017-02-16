package apcsa.franklin.inheritance.bankaccount;

/**
 * This class represents a LinkedBankAccount which has additional features. A LinkedBankAccount is a BankAccount
 * connected to another BankAccount object. Unlike BankAccount, if you attempt to withdraw more money that you have
 * in the BankAccount it will pull from the BankAccount it is linked to and charge a $35.00 overdraft fee.
 * It also allows you to transfer money between this LinkedBankAccount and the BankAccount it is linked with.
 */
public class LinkedBankAccount extends BankAccount {
    private BankAccount linkedAccount;

    /**
     * Constructor for a LinkedBankAccount.
     * @param balance the initial balance in the LinkedBankAccount.
     * @param rate the initial rate of the LinkedBankAccount.
     * @param id the id associated with the account.
     * @param otherAccount the bankaccount to link with this LinkedBankAccount.
     */
    public LinkedBankAccount(double balance, double rate, String id, BankAccount otherAccount) {
        super(balance, rate, id);
        this.linkedAccount = otherAccount;
    }

    /**
     * Overrides the withdraw method in bankaccount so that it will withdraw from the linkedAccount
     * if the amt is less than the grandTotal but more than the amount in this LinkedBankAccount.
     * @param amt an amount to withdraw
     * @return a String representing the withdrawal.
     */
    @Override
    public String withdraw(double amt) {
        if (amt > this.getBalance() && linkedAccount.getBalance() < 35 + amt - this.getBalance()) {
            throw new IllegalArgumentException("Error: Insufficient funds.");
        }
        else if (amt > this.getBalance()) {
            double amtLeft = amt - this.getBalance() + 35;
            super.withdraw(getBalance());
            linkedAccount.withdraw(amtLeft);
            return "*OVERDRAFT* Withdrawal: $" + amt + ", ID: " + getId() + " Balance: $"
                    + getBalance() + ", ID: " + linkedAccount.getId() + " Balance: $" + linkedAccount.getBalance();
        } else {
            return super.withdraw(amt);
        }
    }


    /**
     * Transfers an amount from this LinkedBankAccount to the linked account.
     * If amt is positive it withdraws from this and deposits in link.
     * If amt is negative it withdraws from link and deposits in this.
     * @param amt the amount to transfer.
     * @return a String representing the transfer.
     */
    public String transfer(double amt) {
        if (amt > getBalance() || amt < -linkedAccount.getBalance()) {
            throw new IllegalArgumentException("Error: Insufficient funds.");
        }
        if (amt > 0) {
            this.withdraw(amt);
            linkedAccount.deposit(amt);
            return "Transfer from " + getId() + " to " + linkedAccount.getId() + ": $" + amt;
        } else {
            amt *= -1;
            this.deposit(amt);
            linkedAccount.withdraw(amt);
            return "Transfer from " + linkedAccount.getId() + " to " + getId() + ": $" + amt;
        }
    }

    /**
     * Calculates and adds the interest in this account and linkedAccount.
     */
    @Override
    public void calculateInterest() {
        super.calculateInterest();
        linkedAccount.calculateInterest();
    }

    /**
     * Override the toString method so that it also displays the linkedAccount.
     * @return a String representation of this LinkedBankAccount.
     */
    @Override
    public String toString() {
        return super.toString() + "\n\tLinked Account: " + linkedAccount.toString();
    }
}
