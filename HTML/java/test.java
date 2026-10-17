import java.util.Scanner;
class Student
{
    String name;
    int total;
    int s1,s2,s3;
    Student(String name,int s1,int s2,int s3)
    {
        this.name=name;
        this.s1=s1;
        this.s2=s2;
        this.s3=s3;
        total = (s1+s2+s3)/3;//here total is in construcor can be a separate method
        //total variable is not outside because when a object is created eveery integer variable is set to 0 
        //so when it is object is created s1,s2,s3 are zero later they are given values by construcor
        //since at start s1,s2,s3 are zero if yoou put total = s1 plus s2 plus s3 it will still be zero
        //so best way is to write a separate method like sigma or total in this construcor like a sannasi
    }
    
    String grade()
    {
        if(total>90)
        {
            return "super ra";
        }
        else if(total>70)
        {
            return "nuvvu average ra";
        }
        else if(total>50)
        {
            return "nuvvu boku ra";
        }
        else
        {
            return "nuvvu enduku puttav ra";
        }
    }

}
public class test
{
    public static void main(String []args)
    {
        String name;
        int s1,s2,s3;
        Scanner scan = new Scanner(System.in);
        System.out.println("enter the name of student : ");
        name = scan.next();
        System.out.println("enter the marks in first subject ");
        s1 = scan.nextInt();
        System.out.println("enter the marks in second subject ");
        s2 = scan.nextInt();
        System.out.println("enter the marks in third subject ");
        s3 = scan.nextInt();
        Student s = new Student(name,s1,s2,s3);
        System.out.println(s.grade());
    }
}