import java.util.Scanner;
public class Bank 
{
public static void main(String [] args) 
{
    Scanner scan = new Scanner(System.in) ;
    int cash = 0,amount = 0;
    int five=0,two=0,hun=0,fifty=0,twenty=0,ten=0;
    System.out.println ( " enter the amount you want to withdraw :");
    cash = scan.nextInt();
    while(cash>0)
    {
        five = cash / 500;
        cash = cash % 500;
        two = cash / 200;
        cash = cash %200;
        hun = cash / 100;
        cash = cash % 100;
        fifty = cash / 50;
        cash = cash %50;
        twenty = cash / 20 ;
        cash = cash % 20 ;
        ten = ten / 10 ;
        cash = cash % 10; 
    }
    System.out.println(" number of fice hundred notes are : " + five);
    System.out.println(" number of two hundred notes are : " + two);
    System.out.println(" number of onw hundred notes are : " + hun);
    System.out.println(" number of fifty notes are : " + fifty);
    System.out.println(" number of twenty notes are : " + twenty);
    System.out.println(" number of ten notes are : " + ten);

}
}