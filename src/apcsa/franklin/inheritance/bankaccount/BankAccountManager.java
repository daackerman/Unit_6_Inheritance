package apcsa.franklin.inheritance.bankaccount;

/**
 * This class demonstrates some differences between BankAccounts and LinkedBankAccounts.
 */
public class BankAccountManager {
    public static void main(String[] args) {
        String separator = "/////////////////////////////////////////////////////////////////////////////////////////";
        BankAccount acct1 = new BankAccount(1000, 2, "12345");
        LinkedBankAccount acct2 = new LinkedBankAccount(500, 4, "56789", acct1);
        BankAccount acct3 = new LinkedBankAccount(600, 6, "22222", acct1);
        System.out.println(separator);
        System.out.println("Initial Account Information");
        System.out.println("Printing Account 1\n" + acct1);
        System.out.println("Printing Account 2\n" + acct2);
        System.out.println("Printing Account 3\n" + acct3);
        System.out.println(separator);
        System.out.println();

        //Perform some operations on acct2
        System.out.println(separator);
        System.out.println("Account 2 Operations: Withdraw 600 -> Deposit 300 -> Transfer -500 -> Calculate Interest");
        System.out.println();
        System.out.println(acct2.withdraw(600));
        System.out.println(acct2.deposit(300));
        System.out.println(acct2.transfer(-500));
        System.out.println("Calculating Interest...");
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
        System.out.println("Account 3 Operations: Withdraw 800 -> Deposit 500 -> Calculate Interest");
        System.out.println();
        System.out.println(acct3.withdraw(800));
        System.out.println(acct3.deposit(500));
        System.out.println("Calculating Intereest...");
        acct3.calculateInterest();
        System.out.println();
        System.out.println("Printing Account 3");
        System.out.println(acct3);
        System.out.println("Printing Account 1");
        System.out.println(acct1);
        System.out.println(separator);
        System.out.println();

        //Final accounts
        System.out.println(separator);
        System.out.println("Final Account Information");
        System.out.println("Printing Account 1\n" + acct1);
        System.out.println("Printing Account 2\n" + acct2);
        System.out.println("Printing Account 3\n" + acct3);
        System.out.println(separator);
    }
}
