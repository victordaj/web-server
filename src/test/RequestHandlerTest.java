package test;

import requests.*;

import java.io.IOException;
import java.net.Socket;

import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RequestHandlerTest {

    @Test
    public void handleRequest() throws IOException {
        String mockedRequest = "POST /cgi-bin/process.cgi HTTP/1.1\n" +
                "User-Agent: Mozilla/4.0 (compatible; MSIE5.01; Windows NT)\n" +
                "Host: www.tutorialspoint.com\n" +
                "Content-Type: application/x-www-form-urlencoded\n" +
                "Content-Length: length\n" +
                "Accept-Language: en-us\n" +
                "Accept-Encoding: gzip, deflate\n" +
                "Connection: Keep-Alive\n" +
                "\n" +
                "licenseID=string&content=string&/paramsXML=string";
        Socket mockedSocket = new Socket();
        RequestHandler rh = new RequestHandler(mockedSocket);
        mockedSocket.close();

    }
}
