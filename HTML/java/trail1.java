// import java.util.Scanner;
// class mage
// {
//     int age;
//     mage(int age)
//     {
//         this.age = age;
//     }
//     void validate() throws Exception
//     {
//         if(age<18)
//         {
//             throw new Exception("minor naayala ");
//         }
//         System.out.println("congrats needi chaala peddadi ");
//     }
// }
// public class trail1
// {
//     public static void main(String []args)
//     {
//         Scanner scan =  new Scanner(System.in);
//         int age;
//         System.out.println("enter you age : ");
//         age = scan.nextInt();
//         mage a = new mage(age);
//         try
//         {
//             a.validate();
//         }
//         catch(Exception e )
//         {
//             System.out.println("fuck off " + e);
//         }


//     }
// }



// public class trail1
// {
//     public static void main(String [] args)
//     {
//         int arr[] = new int[5];
//         try
//         {
//              System.out.println(arr[5]);
//         }
//         catch(ArrayIndexOutOfBoundsException e)
//         {
//             System.out.println("kallu dengaya " + e);
//         }
//     }
// }

//finally block runs even if exception is caught or there is no exception 
//ippudu aa statement edo last line lo raayachu kada ante ask chatgpt
//main reason is you write a try block and dont write catch block if program finds there is no catch it crashes without reaching the final line
//but finally does'nt care about this shit it alwaus runs
// public class trail1 {
//     public static void main(String[] args) {

//         try {
//             int a = 10 / 1;        // risky operation
//             int[] arr = {1, 2, 3};
//             System.out.println(arr[5]);  // risky operation
//         }
//         catch (ArithmeticException e) {
//             System.out.println("Caught: Division by zero!");
//         }
//         catch (ArrayIndexOutOfBoundsException e) {
//             System.out.println("Caught: Invalid array index!");
//         }
//         finally {
//             System.out.println("End of operation — closing resources...");
//         }

//         System.out.println("Program continues...");
//     }
// }


public class trail1 {
    public static void main(String[] args) {

        try {
            int a = 10 / 0;   // This will cause ArithmeticException
        }

        catch (Exception e) {

            System.out.println("Using getMessage():");
            System.out.println(e.getMessage());      // Only the message

            System.out.println("\nUsing toString():");
            System.out.println(e.toString());        // Exception type + message

            System.out.println("\nUsing printStackTrace():");
            e.printStackTrace();                     // Full error path
        }

        System.out.println("\nProgram End.");
    }
}

