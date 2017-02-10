/**
 * This class represents a LinkedBankAccount which has additional features. A LinkedBankAccount is a BankAccount
 * connected to another BankAccount object. Unlike BankAccount, if you attempt to withdraw more money that you have
 * in the BankAccount it will pull from the BankAccount it is linked to and charge a $25.00 overdraft fee.
 * It also allows you to transfer money between this LinkedBankAccount and the BankAccount it is linked with.
 */
public class LinkedBankAccount extends BankAccount {
    private BankAccount linkedAccount;
    private double grandTotal;


    /**
     * Constructor for a LinkedBankAccount.
     * @param balance the initial balance in the LinkedBankAccount.
     * @param rate the initial rate of the LinkedBankAccount.
     * @param id the id associated with the account.
     * @param otherAccount the BankAccount to link with this LinkedBankAccount.
     */
    public LinkedBankAccount(double balance, double rate, String id, BankAccount otherAccount) {
        super(balance, rate, id);
        this.linkedAccount = otherAccount;
        grandTotal = this.getBalance() + otherAccount.getBalance();
    }

    /**
     * Overrides the withdraw method in BankAccount so that it will withdraw from the linkedAccount
     * if the amt is less than the grandTotal but more than the amount in this LinkedBankAccount.
     * @param amt an amount to withdraw
     * @return a String representing the withdrawal.
     */
    @Override
    public String withdraw(double amt) {
        if (amt > grandTotal) {
            throw new IllegalArgumentException("Error: Insufficient funds.");
        }
        if (amt > this.getBalance()) {
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
     * If amt > 0 it withdraws from this and deposits in link.
     * If amt < 0 it withdraws from link and deposits in this.
     * @param amt the amount to transfer.
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
     * @return the total amount in all linked accounts.
     */
    public double getGrandTotal() {
        return grandTotal;
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
