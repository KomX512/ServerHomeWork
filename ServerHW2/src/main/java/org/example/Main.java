import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("server started");
        int port = 8050;

        Cesar cesar = new Cesar();
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                try (Socket clientSocket = serverSocket.accept(); // ждем подключения
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                ) {
                    int keyShift = inputParameter(in, out, "Input shift (-10...10)");
                    int revers = inputParameter(in, out, "Reverse (1 -no, 2 - yes)");
                    if (keyShift < -10 || keyShift > 10) {
                        out.println("Shift input error");
                        continue;
                    }
                    if (revers != 1 && revers != 2) {
                        out.println("Reverse error");
                        continue;
                    }
                    out.println("String: ");
                    String inString = in.readLine();
                    cesar.keyShift = keyShift;
                    cesar.revers = (revers == 2 ? true : false);
                    String result = cesar.encryptString(inString);
                    out.println("Result: " + result);
                    serverSocket.close();
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static int inputParameter(BufferedReader in, PrintWriter out, String question) throws IOException {
        int result = 0;
        while (result == 0) {
            out.println(question + ": ");
            String inString = in.readLine();
            try {
                result = Integer.parseInt(inString);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }
}

//
