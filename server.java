import java.io.*;
import java.net.*;

public class server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        Socket socket = serverSocket.accept();
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
        String message = input.readLine();
        int[] count = new int[256];
        for (int i = 0; i < message.length(); i++) {
            count[message.charAt(i)]++;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 256; i++) {
            if (count[i] > 0) {
                result.append((char) i).append(":").append(count[i]).append(" , ");
            }
        }
        output.println(result.toString());
    }
}