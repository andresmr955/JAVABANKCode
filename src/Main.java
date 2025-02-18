import java.util.Scanner;

public class Main {
    private String pin = "1234"; // PIN predefinido

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

    public static void main(String[] args) {
        Main main = new Main();

        // Intentar autenticar con un PIN
        boolean isAuthenticated = main.authenticateUser();
        if (isAuthenticated) {
            System.out.println("Usuario autenticado.");
        } else {
            System.out.println("Acceso denegado.");
        }
    }
}