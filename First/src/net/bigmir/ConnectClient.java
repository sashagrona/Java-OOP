package net.bigmir;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ConnectClient implements Runnable {
    private Socket soc;
    private String ansv;

    public ConnectClient(Socket soc, String ansv) {
        super();
        this.soc = soc;
        this.ansv = ansv;
        Thread t = new Thread(this);
        t.start();
    }

    public void run() {
        try (InputStream is = soc.getInputStream();
             OutputStream os = soc.getOutputStream();
             PrintWriter pw = new PrintWriter(os)) {

            byte[] rec1 = new byte[is.available()];
            is.read(rec1);
            String response = "HTTP/1.1 200 OK\r\nServer: Diesel_Server\r\n" +
                    "Content-Type: text / html\r\nContent-Length:\r\nConnection: close\r\n\r\n";
            pw.print(response + ansv);
            pw.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

