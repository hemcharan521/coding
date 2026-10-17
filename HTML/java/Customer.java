import java.util.Scanner;

class Customers 
{
    String name;
    String customerId;
    Customers (String name,String customerId)
    {
        this.name=name;
        this.customerId=customerId;
    }
}
class Accounts extends Customers
{
    int balance,amount;
    Accounts(String name,String customerId,int balance,int amount)
    {
        super(name,customerId);
        this.balance=balance;
        this.amount=amount;
    }
    void deposit()
    {
        balance = balance + amount;
    }
    void withdraw()
    {
        balance = balance - amount;
    }
}
class Report extends Accounts
{
    float rate;
    Report(String name,String customerId,int balance,int amount,float rate)
    {
        super(name,customerId,balance,amount);
        this.rate=rate;
    }
    double interestCalculation()
    {
        balance =(int)( balance + balance*rate/100);
        return balance;
    }
}
public class Customer
{
    public static void main(String [] args)
    {
        String name,customerId;
        int balance,amount;
        float rate;
        Scanner scan = new Scanner(System.in);
        System.out.println("enter your name : ");
        name = scan.next();
        System.out.println("enter your customer id : ");
        customerId=scan.next();
        System.out.println("enter the total balance in your account : ");
        balance = scan.nextInt();
        System.out.println("enter the amount you want to withdraw : ");
        amount= scan.nextInt();
        System.out.println("what is the rate of interest of your loan : ");
        rate = scan.nextFloat();
        Report r = new Report(name,customerId,balance,amount,rate);
        balance=(int)r.interestCalculation();
        System.out.println(balance);
    }
}