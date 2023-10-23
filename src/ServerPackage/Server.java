package ServerPackage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1478);
            System.out.println("I am a server waiting for a client connection...");
            Socket socket = serverSocket.accept();

            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            System.out.println("Waiting for an operation from the client...");
            String operation = reader.readLine();
            System.out.println("Operation received: " + operation);

            String[] components = operation.split(" ");
            int nb1 = Integer.parseInt(components[0]);
            String operator = components[1];
            int nb2 = Integer.parseInt(components[2]);

            int rep;
            switch (operator) {
                case "+":
                    System.out.println("The client selected Addition operation");
                    rep = nb1 + nb2;
                    PrintWriter out = new PrintWriter(outputStream, true);
                    out.println(rep);
                    break;
                case "-":
                    System.out.println("The client selected Subtraction operation");
                    rep = nb1 - nb2;
                    out = new PrintWriter(outputStream, true);
                    out.println(rep);
                    break;
                case "*":
                    System.out.println("The client selected Multiplication operation");
                    rep = nb1 * nb2;
                    out = new PrintWriter(outputStream, true);
                    out.println(rep);
                    break;
                case "/":
                    System.out.println("The client selected Division operation");
                    rep = nb1 / nb2;
                    out = new PrintWriter(outputStream, true);
                    out.println(rep);
                    break;
                default:
                    System.out.println("Invalid operation. Please try again.");
            }

            System.out.println("Closing the socket...");
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}