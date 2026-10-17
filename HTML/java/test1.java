import java.util.Scanner;

class Bank
{
    String name;
    int id;
    int balance;
    int amount;//will be set zero when object is created dont need to write in constructor
    Bank(String name,int id,int balance)
    {
        this.name=name;
        this.id=id;
        this.balance=balance;
    }
    void deposit()
    {
        balance=balance+amount;
        System.out.println("dabbulu paddayi ra lambdi kodaka ipuudu nee daggara intha vunnayu : "+ balance);
    }
    void withdraw()
    {
        if(balance<amount)
        {
            System.out.println("dabbulu lenappudu ela theesthav ra lambdi kodaka");
        }
        else
        {
            balance=balance-amount;
            System.out.println("dabbulu theeskunnav ra lamdi nee daggara ippudi inni vunnayi : "+balance);
        }
    }
}
public class test1 
{
    public static void main(String [] args)
    {
        Scanner scan = new Scanner(System.in);
        String name;
        int id,amount,balance,choice;
        System.out.println("enter your name :");
        name = scan.next();
        System.out.println("enter the id :");
        id = scan.nextInt();
        System.out.println("enter the balance in the account");
        balance = scan.nextInt();
        Bank b = new Bank(name,id,balance);
        boolean running = true;
        do
        {
            System.out.println("what do you want to do \n 1.deposit \n 2.withdrawl \n3.check balance \n 4.quit: ");
            choice = scan.nextInt();
            switch(choice)
            {
                case 1 : System.out.println("enter the amount you want to deposit :");
                amount = scan.nextInt();
                b.amount = amount;
                b.deposit();
                break;
                case 2 :  System.out.println("enter the amount you want to withdraw :");
                amount = scan.nextInt();
                b.amount = amount;
                b.withdraw();
                break;
                case 3: System.out.println("the remaining balance in your account is "+b.balance);
                        break;
                case 4 : running = false;
                         break;
                default : System.out.println("invalid input");
                
            }
        }while(running);
    }
    
}
