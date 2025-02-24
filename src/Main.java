import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    private String pin = "1234";
    private double balance = 1000;
    private ArrayList<String> transactionHistory = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);

    public boolean authenticateUser() {
        int attempts = 0;
        while (attempts < 3) {
            System.out.print("Ingrese su PIN: ");
            String inputPin = sc.nextLine();
            if (this.pin.equals(inputPin)) {
                return true;
            } else {
                attempts++;
                System.out.println("PIN incorrecto. Intento " + attempts + " de 3.");
            }
        }
        return false;
    }

    public void displayMenu() {
        if (!authenticateUser()) {
            System.out.println("Acceso denegado.");
            return;
        }

        while (true) {
            System.out.println("\nOpciones del ATM:");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Depositar dinero");
            System.out.println("3. Retirar dinero");
            System.out.println("4. Transferencia Internacional");
            System.out.println("5. Ver historial de transacciones");
            System.out.println("6. Salir");
            System.out.print("Selecciona una opción: ");

            try {
                int option = sc.nextInt();
                switch (option) {
                    case 1:
                        checkBalance();
                        break;
                    case 2:
                        depositMoney();
                        break;
                    case 3:
                        withdrawMoney();
                        break;
                    case 4:
                        internationalTransfer();
                        break;
                    case 5:
                        viewTransactionHistory();
                        break;
                    case 6:
                        System.out.println("Saliendo del cajero...");
                        return;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor ingrese un número válido.");
                sc.next();
            }
        }
    }

    public void checkBalance() {
        System.out.println("Saldo actual: $" + balance);
    }

    public void depositMoney() {
        System.out.print("Ingrese cantidad a depositar: ");
        double amount = sc.nextDouble();
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Depósito: $" + amount);
            System.out.println("Depósito exitoso. Nuevo saldo: $" + balance);
        } else {
            System.out.println("Cantidad inválida.");
        }
    }

    public void withdrawMoney() {
        System.out.print("Ingrese cantidad a retirar: ");
        double amount = sc.nextDouble();
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Retiro: $" + amount);
            System.out.println("Retiro exitoso. Nuevo saldo: $" + balance);
        } else {
            System.out.println("Fondos insuficientes o cantidad inválida.");
        }
    }

    public void internationalTransfer() {
        System.out.print("Ingrese cantidad a transferir: ");
        double transferAmount = sc.nextDouble();
        sc.nextLine();
        System.out.print("Ingrese el país de destino: ");
        String country = sc.nextLine();
        System.out.println("Transferencia de $" + transferAmount + " a " + country + " realizada con éxito.");
    }
    public void viewTransactionHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("No hay transacciones registradas.");
        } else {
            System.out.println("\nHistorial de transacciones:");
            for (String transaction : transactionHistory) {
                System.out.println(transaction);
            }
        }
    }
    public static void main(String[] args) {
        Main atm = new Main();
        atm.displayMenu();
    }
}
