public class test5 
{
    //we can create own exception like kinda daniki 0 allergy exception anu peru petacchu ela anedi vedio chudu(81) naku opika ledu
    public static void main(String []args)
    {
        int i=30;
        int j=0;
        int num[]= new int[5];
        String name=null;

        try
        {
        //j = 20/i;//when here is exception it will immediately jumps to catch block without even reading the next statements even if they are exception so
         //if (j==0)//read notes for clarity
        // {
        //     throw new ArithmeticException("naku 0 ante allergy");//the message will be sent when that exception is raised(ade j=0 not j divided by o)
        // }
        //so we make first statement legal for some time
        //if we want to solve both exception we can use multiple catch blockes
        //if any one of themis exception it can handle but if both are exceptioon then only the exception that appears is solved another will not be solved nor throw as exception
        //if you want to solve both write in separeate try blocks
        //System.out.println(name.length());
        System.out.println(num[5]);//array size is 5 so we cant print sixth element hence sends and exception
        }
        catch(ArithmeticException e )//instead of just exception we can specify the type of exception so that it solves correctly
        {
            //System.out.println("edo ganakaryam chesav"+ e);//e ante ante aa exception ee type oo chepthundi
            //e changes based on type of exception like for divided by o it is arthmetic exception for array it is arrayindex out of bounds
            j=18/1;
            System.out.println(e);//normally divided by 0 error ani vachintundi for j=0 but nenu object create chesetappudu messge pampincha aa message vasthundi
            //instead of saying error vachindin i will take matter into my own hand
            //this  is what real  handling means not just printling error vachindi like a cheth akaanodu
        }
        //since arthmetic is solved above we use another catch specifying to solve array out of bounds
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("array index ela start avuthundo theliyani sannnasi");
        }
       
        catch (Exception e )
        //Exception can handle anything
        {
            System.out.println("you got a  " + e);
        }
        //all catches should be in sequential
        //there should be no middle statements like below print
        //if i put random println in between two catch i will get error(i already got)
         System.out.println(j);
    }
}
