/**
 * This class demonstrates some differences between BankAccounts and LinkedBankAccounts.
 */
public class BankAccountManager {
    public static void main(String[] args) {
        String separator = "/////////////////////////////////////////////////////////////////////////////////////";
        BankAccount acct1 = new BankAccount(1000, 2, "12345");
        LinkedBankAccount acct2 = new LinkedBankAccount(500, 4, "56789", acct1);
        BankAccount acct3 = new LinkedBankAccount(600, 6, "22222", acct1);
        System.out.println(separator);
        System.out.println("Account Information");
        System.out.println(acct1);
        System.out.println(acct2);
        System.out.println(acct3);
        System.out.println(separator);
        System.out.println();

        //Perform some operations on acct2
        System.out.println(separator);
        System.out.println("Account 2 Operations, Withdraw 600, Deposit 300, Transfer -500");
        System.out.println(acct2.withdraw(600));
        System.out.println();
        System.out.println(acct2.deposit(300));
        System.out.println();
        System.out.println(acct2.transfer(-500));
        System.out.println();
        System.out.println("Calculate Interest");
        acct2.calculateInterest();
        System.out.println();
        System.out.println("Printing Account 2");
        System.out.println(acct2);
        System.out.println("Printing Account 1");
        System.out.println(acct1);
        System.out.println(separator);
        System.out.println();


        //Perform some operations on acct3
        System.out.println(separator);
        System.out.println("Account 3 Operations, Withdraw 900, Deposit 500");
        System.out.println();
        System.out.println(acct3.withdraw(800));
        System.out.println(acct3.deposit(500));
        System.out.println();
        System.out.println("Printing Account 3");
        System.out.println(acct3);
        System.out.println("Printing Account 2");
        System.out.println(acct2);
        System.out.println(separator);
    }
}
