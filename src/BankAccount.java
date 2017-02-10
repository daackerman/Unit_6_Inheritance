/**
 * This class represents a BankAccount object. It has set and get methods for its member variables
 * balance, rate and id. It also has a withdraw and deposit methods that mutate the state of the
 * BankAccount. Lastly, it has a calculateInterest method that adds the interest to the account.
 */
public class BankAccount {
    private double balance;
    private double rate;
    private String id;

    //BankAccount constructor
    public BankAccount(double balance, double rate, String id) {
        setBalance(balance);
        setRate(rate);
        setID(id);
    }

    //Setters and getters.
    public void setRate(double rate) {
        if (rate < 0) {
            throw new IllegalArgumentException("rate: " + rate);
        }
        this.rate = rate;
    }

    public void setBalance(double balance) {
        if (balance < 0) {
            throw new IllegalStateException("balance: " + balance);
        }
        this.balance = balance;
    }

    public void setID(String id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public double getRate() {
        return rate;
    }

    public String getId() {
        return id;
    }

    /**
     * This method withdraws an amount from this BankAccount if it can. If the amount is negative
     * or the BankAccount would go below zero, then it throws an IllegalArgumentException.
     * @param amt a nonnegative number to withdraw from this.
     * @return a String describing the withdrawal.
     */
    public String withdraw(double amt) {
        if (amt < 0) {
            throw new IllegalArgumentException("Error: Cannot withdraw a negative amount.");
        } else if (balance - amt < 0) {
            throw new IllegalArgumentException("Error: Insufficient funds.");
        } else {
            balance -= amt;
            return "Withdrawal: $" + amt + " from ID: " + id + ", New balance: $" + balance;
        }
    }

    /**
     * This method deposits an amount into this BankAccount. If he amount is negative then
     * it throws an IllegalArgumentException.
     * @param amt a nonnegative number to deposit into this.
     * @return a String describing the deposit.
     */
    public String deposit(double amt) {
        if (amt < 0) {
            throw new IllegalArgumentException("Error: Cannot deposit a negative amount.");
        } else {
            balance += amt;
            return "Deposit: $" + amt + " into ID: " + id + ", New balance: $" + balance;
        }
    }

    /**
     * This method calculates and adds the interest to the balance.
     */
    public void calculateInterest() {
        balance += balance * rate / 100.0;
    }

    /**
     * @return a String representation of this BankAccount.
     */
    public String toString() {
        return "Account id: " + id + ", Balance: $" + balance + ", Interest rate: " + rate + "%";
    }
}
