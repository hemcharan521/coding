import java.util.*;

class Bank {
    String name;
    int id;
    int balance;

    Bank(String name, int id, int balance) {
        this.name = name;
        this.id = id;
        this.balance = balance;
    }

    void deposit(int amount) {
        balance += amount;
        System.out.println(name + " deposited " + amount + ". New balance: " + balance);
    }

    void withdraw(int amount) {
        if (balance < amount) {
            System.out.println("Not enough balance!");
        } else {
            balance -= amount;
            System.out.println(name + " withdrew " + amount + ". New balance: " + balance);
        }
    }

    void checkBalance() {
        System.out.println(name + "'s balance: " + balance);
    }
}

public class trail{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //for diffrences between arraylist and array ask chatgpt
        //some of them are array has fixed size but array list has dynamic size
        //array store same datatype elements
        //arraylist stores only objects of wrapper/normal classes
        ArrayList<Bank> customers = new ArrayList<>();
        //arraylist is a class due to that reason syntax similar to object creation
        //bank is datatype which is class so we can store objects of that class in this arraylist
        boolean running = true;

        while (running) {
            System.out.println("\n=== Bank Menu ===");
            System.out.println("1. Create New Account");
            System.out.println("2. Access Account by Name");
            System.out.println("3. Show All Customers");
            System.out.println("4. Quit");
            System.out.print("Enter your choice: ");
            int choice = scan.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scan.next();
                    System.out.print("Enter new ID number: ");
                    int id = scan.nextInt();
                    System.out.print("Enter opening balance: ");
                    int bal = scan.nextInt();
                    //customers.add(new Bank(name, id, bal));
                    Bank b1 = new Bank(name, id, bal);  // object created
                    customers.add(b1);// added to list

                    System.out.println("Account created for " + name + "!");
                    break;

                case 2:
                    System.out.print("Enter customer name to access: ");
                    String searchName = scan.next();

                    Bank found = null;//created a empty bank object with name found
                    for (Bank b : customers) {
                        if (b.name.equals(searchName)) { // exact match only
                            found = b;//name matched so found objects matches current object(b)
                            break;
                        }
                    }

                    if (found == null) {
                        System.out.println("No account found with the name " + searchName);
                    } else {
                        boolean inAccount = true;
                        while (inAccount) {
                            System.out.println("\nWelcome, " + found.name + "!");
                            System.out.println("1. Deposit");
                            System.out.println("2. Withdraw");
                            System.out.println("3. Check Balance");
                            System.out.println("4. Exit to Main Menu");
                            System.out.print("Enter your choice: ");
                            int accChoice = scan.nextInt();

                            switch (accChoice) {
                                case 1:
                                    System.out.print("Enter amount to deposit: ");
                                    int dep = scan.nextInt();
                                    found.deposit(dep);
                                    break;
                                case 2:
                                    System.out.print("Enter amount to withdraw: ");
                                    int w = scan.nextInt();
                                    found.withdraw(w);
                                    break;
                                case 3:
                                    found.checkBalance();
                                    break;
                                case 4:
                                    inAccount = false;
                                    System.out.println("Logging out...");
                                    break;
                                default:
                                    System.out.println("Invalid choice!");
                            }
                        }
                    }
                    break;

                case 3:
                    System.out.println("\n--- All Customers ---");
                    for (Bank b : customers) {
                        System.out.println("Name: " + b.name + " | ID: " + b.id + " | Balance: " + b.balance);
                    }
                    break;

                case 4:
                    running = false;
                    System.out.println("Thank you for using our bank system!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }
        scan.close();
    }
}
