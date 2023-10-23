package Act2_2;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Entrez le premier opérande : ");
            double operand1 = scanner.nextDouble();
            System.out.println("Entrez l'opérateur (+, -, *, /) : ");
            char operator = scanner.next().charAt(0);
            System.out.println("Entrez le deuxième opérande : ");
            double operand2 = scanner.nextDouble();

            Socket socket = new Socket("localhost", 9876);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            Operation operation = new Operation(operand1, operand2, operator);
            objectOutputStream.writeObject(operation);
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            double result = objectInputStream.readDouble();
            System.out.println("Résultat reçu du serveur : " + result);
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
