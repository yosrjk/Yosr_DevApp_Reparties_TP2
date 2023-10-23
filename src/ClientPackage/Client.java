package ClientPackage;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            int rep;
            System.out.println("I am a client not yet connected ... ");
            InetAddress serverInetAddress = InetAddress.getByName("10.26.14.8");
            InetSocketAddress serverSocketAddress = new InetSocketAddress(serverInetAddress, 1478);
            Socket socket = new Socket();
            socket.connect(serverSocketAddress);

            System.out.println("Established a connection to the server");

            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            Scanner scanner = new Scanner(System.in);
            PrintWriter out = new PrintWriter(outputStream, true);

            System.out.println("Give the first number:");
            int nb1 = scanner.nextInt();
            System.out.println("Give the operator (+, -, *, /):");
            String operator = scanner.next();
            System.out.println("Give the second number:");
            int nb2 = scanner.nextInt();

            String operation = nb1 + " " + operator + " " + nb2;
            out.println(operation);
            System.out.println("Sent the operation " + operation + " to the server");

            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
            String response = in.readLine();
            System.out.println("Received response from the server: " + response);

            System.out.println("Closing the client socket...");
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}