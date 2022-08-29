public class BankAccountTest {
    public static void main(String[] args){
        System.out.println("\n------------Account1-Summary:--------------\n");
        
        BankAccount accnt1 = new BankAccount();
        
        accnt1.deposit(100.00, "savings");
        accnt1.deposit(100.00, "checking");
        accnt1.withdraw(10.00, "checking");
        accnt1.totalInAccnts();
        accnt1.deposit(100.00, "checking");
        accnt1.getCheckingAccntBal();
        accnt1.getSavingsAccntBal();

        System.out.println("\n-------------Account2-Summary:--------------\n");
        
        BankAccount accnt2 = new BankAccount();

        accnt2.deposit(200.00, "checking");
        accnt2.deposit(200.00, "savings");
        accnt2.totalInAccnts();
        accnt2.withdraw(20.00, "checking");
        accnt2.withdraw(20.00, "checking");
        accnt2.getCheckingAccntBal();
        accnt2.getSavingsAccntBal();

        System.out.println("\n-----------------Accounts:------------------\n");
        BankAccount.numOfAccnts();

    
    }
}    
