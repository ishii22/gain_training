class InsufficientBalanceException extends RuntimeException{
    private double amount;
    private String message = null;
    public InsufficientBalanceException(double amount){
        this.amount = amount;
        message = "Your existing balance is not sufficient to withdraw amount-";
    }
    public InsufficientBalanceException(double amount, String message){
        this.amount = amount;
        this.message = message;
    }
    public String toString(){
        return "InsufficientBalance exception:"+message+" "+amount;
    }
}

class Account{
    int accno;
    String accHolderName;
    String openedDate;
    String status;
    double balance;
    Account(int accno, String accHolderName, String openedDate, String status, double balance){
        this.accno = accno;
        this.accHolderName = accHolderName;
        this.openedDate = openedDate;
        this.status = status;
        this.balance = balance;
    }
}

class Transaction{
    public void deposit(Account a, double amount){
        a.balance += amount;
        System.out.println("After deposit, new balance is "+a.balance);
    }
    public void withdraw(Account a, double amount){
        if(a.balance>amount){
            a.balance -= amount;
            System.out.println(a.balance);
        }
        else
            throw new InsufficientBalanceException(amount);
    }
}

public class Assign25Aug {
    public static void main(String[] args) {
        Account accObj = new Account(101, "Harvey Specter","25-0802023","active", 25000);
        Transaction transacObj = new Transaction();
        transacObj.deposit(accObj, 500);
        transacObj.withdraw(accObj, 50000);
    }
}
