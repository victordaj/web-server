package requests;

import responses.Response;

import java.io.*;
import java.net.Socket;

public class RequestHandler implements Runnable{
    private Socket clientSocket;
    private BufferedReader in;
    private BufferedOutputStream dataOut;

    public RequestHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;

    }

    public Response handleRequest(String data) {
        RequestFactory requestFactory = new RequestFactory();
        Request r = requestFactory.parseRequest(data);
        Response response = r.solve();
        return response;
    }

    private String getClientRequest() {
        String data = "GET /not_found HTTP/1.1";
        try {
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            data = in.readLine();
        } catch (IOException e) {
            System.out.println("Error reading data: " + e.getMessage());;
        }
        return data;
    }

    private void sendResponse(Response r) throws IOException {
        dataOut = new BufferedOutputStream(clientSocket.getOutputStream());
        dataOut.write(r.toString().getBytes());
        if (r.getContentLength() > 0) {
            dataOut.write(r.getContentBytes());
        }
        dataOut.write("\r\n\r\n".getBytes());
        dataOut.flush();

    }

    @Override
    public void run() {
        try {
            String data = this.getClientRequest();
            Response r = handleRequest(data);
            sendResponse(r);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        } finally {
            try {
                in.close();
                dataOut.close();
                clientSocket.close();
            }
            catch (IOException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
    }
}
