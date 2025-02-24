import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private String pin = "1234"; // PIN predefinido
    private double balance = 1000; // Saldo inicial

    public boolean authenticateUser() {
        Scanner sc = new Scanner(System.in);
        int attempts = 0;

        while (attempts < 3) {
            System.out.print("Ingrese su PIN: ");
            String inputPin = sc.nextLine(); // Leer el PIN como String

            if (this.pin.equals(inputPin)) { // Comparar con el PIN predefinido
                return true; // PIN correcto
            } else {
                attempts++;
                System.out.println("PIN incorrecto. Intento " + attempts + " de 3.");
            }
        }
        return false; // Después de 3 intentos fallidos
    }


    public void displayMenu() {
        Scanner sc = new Scanner(System.in);
        try {

            boolean isAuthenticated = authenticateUser();
            if (isAuthenticated) {
                System.out.println("Usuario autenticado.");



            while (true) { // Bucle para repetir el menú
                System.out.println("\nOpciones del ATM:");
                System.out.println("1. Consultar saldo");
                System.out.println("2. Depositar dinero");
                System.out.println("3. Retirar dinero");
                System.out.println("4. Salir");
                System.out.print("Selecciona una opción: ");

                try {
                    int option = sc.nextInt();
                    switch (option) {
                        case 1:
                            checkBalance();
                            break;
                        case 2:
                            depositMoney(sc);
                            break;
                        case 3:
                            withdrawMoney(sc);
                            break;
                        case 4:
                            System.out.println("Saliendo del cajero...");
                            return; // Salir del menú
                        default:
                            System.out.println("Opción no válida.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Por favor ingrese un número válido.");
                    sc.next(); // Limpiar el buffer
                }

            }
        }  else {
            System.out.println("Acceso denegado.");
        }
    }
        finally {
            sc.close(); // Cierra el scanner cuando ya no se necesita
        }
    }

    public void checkBalance() {
        System.out.println("Saldo actual: $" + balance);
    }

    public void depositMoney(Scanner sc) {
        System.out.print("Ingrese cantidad a depositar: ");
        double amount = sc.nextDouble();
        if (amount > 0) {
            balance += amount;
            System.out.println("Depósito exitoso. Nuevo saldo: $" + balance);
        } else {
            System.out.println("Cantidad inválida.");
        }
    }

    public void withdrawMoney(Scanner sc) {
        System.out.print("Ingrese cantidad a retirar: ");
        double amount = sc.nextDouble();
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Retiro exitoso. Nuevo saldo: $" + balance);
        } else {
            System.out.println("Fondos insuficientes o cantidad inválida.");
        }
    }




    public static void main(String[] args) {
        // Create an instance of the Main class
        Main mainUno = new Main();
        mainUno.balance = 5400;
        mainUno.pin = "6789";
        Main mainDos = new Main();
        mainDos.balance = 890500;
        Main mainTres = new Main();
        mainTres.balance = 456400;
        mainTres.pin = "1289";


        // Call the displayMenu method
       // mainUno.displayMenu();
        //mainDos.displayMenu();
       // mainTres.displayMenu();
    }
}