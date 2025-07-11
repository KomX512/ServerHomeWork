import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        String host = "netology.homework";
        int port = 8050;
        Scanner input = new Scanner(System.in);
        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            while (!clientSocket.isOutputShutdown()) {
                String resp = in.readLine();
                System.out.println(resp);
                out.println(input.nextLine());

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
