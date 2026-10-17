import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class calculator {
    public interface Calc extends Remote {
        long addition(long a, long b) throws RemoteException;
        long subtraction(long a, long b) throws RemoteException;
        long multiplication(long a, long b) throws RemoteException;
        long division(long a, long b) throws RemoteException;
    }

    public static class CalcImpl extends UnicastRemoteObject implements Calc {
        public CalcImpl() throws RemoteException {
            super();
        }

        @Override
        public long addition(long a, long b) throws RemoteException {
            return a + b;
        }

        @Override
        public long subtraction(long a, long b) throws RemoteException {
            return a - b;
        }

        @Override
        public long multiplication(long a, long b) throws RemoteException {
            return a * b;
        }

        @Override
        public long division(long a, long b) throws RemoteException {
            if (b == 0) {
                throw new ArithmeticException("Division by zero");
            }
            return a / b;
        }
    }

    public static void startServer() throws Exception {
        LocateRegistry.createRegistry(1099);
        Calc calc = new CalcImpl();
        Naming.rebind("rmi://localhost:1099/CalculatorService", calc);
        System.out.println("Calculator service started on rmi://localhost:1099/CalculatorService");
    }

    public static void runClient() throws MalformedURLException, RemoteException, NotBoundException {
        Calc calc = (Calc) Naming.lookup("rmi://localhost:1099/CalculatorService");
        System.out.println("subtraction: " + calc.subtraction(4, 3));
        System.out.println("addition: " + calc.addition(4, 5));
        System.out.println("multiplication: " + calc.multiplication(3, 6));
        System.out.println("division: " + calc.division(9, 3));
    }

    public static void main(String[] args) {
        try {
            if (args.length > 0 && "server".equalsIgnoreCase(args[0])) {
                startServer();
                return;
            }

            if (args.length > 0 && "client".equalsIgnoreCase(args[0])) {
                runClient();
                return;
            }

            System.out.println("addition: " + (4 + 5));
            System.out.println("subtraction: " + (4 - 3));
            System.out.println("multiplication: " + (3 * 6));
            System.out.println("division: " + (9 / 3));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
