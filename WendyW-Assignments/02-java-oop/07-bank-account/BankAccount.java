import java.util.Random;
public class BankAccount {
    //The class should have the following attributes: (string) account number, (double) checking balance, (double) savings balance.
    protected String acctNum;
    private Double checkingBal;
    private Double savingsBal;

    //Create a class member(static) that has the number of accounts created thus far.
    public static int numOfAccnts = 0;
    //create a class member(static) that tracks the total amount of money stored in every account created.
    public static double moneyInAllAccts = 0.00;
    //Create a private method that returns a random ten digit account number.
    private static String genAcctNum(){
        String substr = "";
        Random r = new Random(); 
        for(int i = 0; i <= 10; i++) {
            substr += r.nextInt(10);
        }
        return substr;
    }
    //In the constructor, call the private method from abouve so that each user has a random ten digit account number.
    public BankAccount() {
        this.checkingBal = 0.00; 
        this.savingsBal = 0.00;
        this.acctNum = BankAccount.genAcctNum();
        BankAccount.numOfAccnts++; //In the constructor increment the account count.

        System.out.println("Checking account num: " + genAcctNum());
        System.out.println("Savings account num: " + genAcctNum());
    }
    
    //Create a getter method for the user's checking account balance.
    public double getCheckingAccntBal() {
        System.out.printf("Checking Account balance: $%.2f",this.checkingBal);
        return this.checkingBal;
    }
    // Create a getter method for the user's savings account balance.
    public double getSavingsAccntBal() {
        System.out.printf("Savings Account balance: $%.2f", this.savingsBal);
        return this.savingsBal;
    }
    //Create a mehod that will allow a user to deposit money into either the checking or saving. Add total amount stored.
    public void deposit(double amount, String account) {
        if(account.equals("checking")){
            this.checkingBal += amount;
            System.out.printf("$%.2f deposited into Checking.", amount);
        }else if(account.equals("savings")){
            this.savingsBal += amount;
            System.out.printf("$%.2f deposited into Savings.", amount);
            BankAccount.moneyInAllAccts += amount;
        }
    } 

    //Create method for withdrawing money from one balance. Don't allow if insufficient funds.
    public void withdraw(double amount, String account) {
        boolean sufficientFunds = false; 
        if(account.equals("checking")){ 
            if(this.checkingBal >= 0){
                sufficientFunds = true;
                this.checkingBal -= amount;
            }else{
                System.out.println("Insufficient funds in checking. Withdrawal not permitted.");
            }
        }

        if(account.equals("savings")){
            if(this.savingsBal >= 0){
                sufficientFunds = true;
                this.savingsBal -= amount;
            }else{
                System.out.println("Insufficient funds in savings. Withdrawal not permitted.");
            }
        }
        if(sufficientFunds);
            BankAccount.moneyInAllAccts -= amount; //Helps to direct the withdrawl amount to be deducted from total in all accounts.
    }
    //Create a method to see the total money from the checking and savings.
    public void totalInAccnts() {
        System.out.printf("Total in checking: $%.2f, Total in savings: $%.2f", this.checkingBal, this.savingsBal);
    }
    //Method for number of Bank accounts created.
    public static int numOfAccnts() {
        System.out.printf("Total number of Bank accounts: %d ", BankAccount.numOfAccnts);
        return BankAccount.numOfAccnts;
    }
    //Users should not be able to set any of the attributes from the class.
}