
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws Exception {
        String host = "netology.homework"; // host переводит на 127.0.0.1
        int port = 8050;
        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            out.println("Pavel");
            String resp = in.readLine();
            System.out.println(resp);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}