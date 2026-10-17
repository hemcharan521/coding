import java.util.Scanner;
class Students
{
    String name;
    int rollnumber;
    Students(String name,int rollnumber)
    {
        this.name = name;
        this.rollnumber = rollnumber;
    }
}
class Marks extends Students 
{
    int java,maths,ads;
    Marks(String name,int rollnumber,int java,int maths,int ads)
    {
        super(name,rollnumber);
        this.java=java;
        this.maths=maths;
        this.ads=ads;
    }
    int average()
    {
        return (java+maths+ads);
    }
    
}
public class Student
{
    public static void main(String[]args)
    {
        Scanner scan = new Scanner(System.in);
        int rollnumber,java,maths,ads;
        String name;
        System.out.println("enter the name of student : ");
        name = scan.next();
        System.out.println("enter the roll number of student : ");
        rollnumber = scan.nextInt();
        System.out.println("enter the marks in java : ");
        java = scan.nextInt();
        System.out.println("enter the marks in maths : ");
        maths = scan.nextInt();
        System.out.println("enter the marks in ads : ");
        ads = scan.nextInt();
        Marks m = new Marks(name,rollnumber,java,maths,ads);
        int total = m.average();
        System.out.println(total);
    }    
}        