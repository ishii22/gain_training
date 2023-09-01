// To create two threads - findBalance and modifyBalance, findBalance thread should be executed first.
public class Account {
    private int accountNo;
    private double balance;
    public Account(){}
    public Account(int accountNo,double balance){
        this.accountNo=accountNo;
        this.balance=balance;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}


import java.util.Set;
import java.util.concurrent.Semaphore;

public class Transaction {
    Semaphore findBalance = new Semaphore(0);
    Semaphore modifyBalance = new Semaphore(1);
    public void transact(Account acc,double amount, char ttype){
        try{
            modifyBalance.acquire();
        }
        catch(InterruptedException ex){
            ex.printStackTrace();
        }
        if(ttype=='D' || ttype=='d')
            acc.setBalance(acc.getBalance()+amount);
        else if(ttype=='W' || ttype=='w')
            acc.setBalance(acc.getBalance()-amount);
        findBalance.release();
    }
    public void checkBalance(Account acc){
        try{
            findBalance.acquire();
        }
        catch (InterruptedException ex){
            ex.printStackTrace();
        }
        System.out.println(acc.getBalance());
        modifyBalance.release();

    }
}

class ModifyBalanceThread implements Runnable{
    Account acc;
    Transaction trans;
    double amount;
    Thread t;
    public ModifyBalanceThread(Account acc, Transaction trans, double amount){
        this.acc=acc;
        this.trans=trans;
        this.amount = amount;
        t = new Thread(this);
        t.start();
    }
    public void run(){
        trans.transact(acc,amount,'D');
    }

}
class FindBalanceThread implements Runnable{
    Account acc;
    Transaction trans;
    Thread t;
    public FindBalanceThread(Account acc, Transaction trans){
        this.acc=acc;
        this.trans=trans;
        t = new Thread(this);
        t.start();
    }
    public void run(){
        trans.checkBalance(acc);
    }

}

public class Test2 {
    public static void main(String[] args) {
        Account acc1 = new Account(7001,15000);
        Transaction trans1 = new Transaction();
        FindBalanceThread fbt = new FindBalanceThread(acc1,trans1);
        ModifyBalanceThread mbt = new ModifyBalanceThread(acc1,trans1,3000);

        try{
            fbt.t.join();
            mbt.t.join();
        }
        catch (InterruptedException ex){
            ex.printStackTrace();
        }
    }
}


