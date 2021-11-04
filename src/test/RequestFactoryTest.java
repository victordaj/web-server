package test;

import requests.*;

import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RequestFactoryTest {
    @Test
    public void parseRequestMethodCorrect() {
        String mockedGetRequest = "GET /hello.htm HTTP/1.1\n" +
                "User-Agent: Mozilla/4.0 (compatible; MSIE5.01; Windows NT)\n" +
                "Host: www.tutorialspoint.com\n" +
                "Accept-Language: en-us\n" +
                "Accept-Encoding: gzip, deflate\n" +
                "Connection: Keep-Alive";
        RequestFactory requestFactory = new RequestFactory();
        Request r = requestFactory.parseRequest(mockedGetRequest);
        assertTrue(r instanceof GetRequest);
    }

    @Test
    public void parseRequestMethodIncorrect() {
        String mockedPostRequest = "POST /cgi-bin/process.cgi HTTP/1.1\n" +
                "User-Agent: Mozilla/4.0 (compatible; MSIE5.01; Windows NT)\n" +
                "Host: www.tutorialspoint.com\n" +
                "Content-Type: application/x-www-form-urlencoded\n" +
                "Content-Length: length\n" +
                "Accept-Language: en-us\n" +
                "Accept-Encoding: gzip, deflate\n" +
                "Connection: Keep-Alive\n" +
                "\n" +
                "licenseID=string&content=string&/paramsXML=string";
        RequestFactory requestFactory = new RequestFactory();
        Request r = requestFactory.parseRequest(mockedPostRequest);
        assertTrue(r instanceof  InvalidRequest);

    }

    @Test
    public void parseRequetsInvalidFormat1() {
        String mockedIncompleteRequest = "POST /cgi-bin/process.cgi";
        RequestFactory requestFactory = new RequestFactory();
        Request r = requestFactory.parseRequest(mockedIncompleteRequest);
        assertTrue(r instanceof  InvalidRequest);
    }

    @Test
    public void parseRequetsInvalidFormat2() {
        String mockedInvalidRequest = "/cgi-bin/process.cgi POST";
        RequestFactory requestFactory = new RequestFactory();
        Request r = requestFactory.parseRequest(mockedInvalidRequest);
        assertTrue(r instanceof  InvalidRequest);
    }
}