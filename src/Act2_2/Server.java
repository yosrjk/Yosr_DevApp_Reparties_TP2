package Act2_2;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9876);
            System.out.println("En attente du client...");
            Socket socket = serverSocket.accept();
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            Operation operation = (Operation) objectInputStream.readObject();
            double result = operation.performOperation();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeDouble(result);
            objectOutputStream.flush();
            System.out.println("Résultat envoyé au client : " + result);
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


