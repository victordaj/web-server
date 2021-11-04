package test;

import config.Config;
import responses.Response;
import requests.InvalidRequest;
import helpers.Types;
import helpers.StatusCodes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ResponseTest {
    Config conf = new Config();
    Response correctResourceResponse = new Response("/index.html", "HTTP/1.1");
    Response invalidResourceResponse = new Response("/this_is_a_wrong_file", "HTTP/1.1");
    Response invalidRequestResponse = new InvalidRequest().solve();
    @Test
    public void testHtmlMimeTypeResponseWithCorrectResource() {
        assertEquals(correctResourceResponse.getContentType(), Types.HTML);
    }

    @Test
    public void testCorrectStatusCodeResponse() {
        assertEquals(correctResourceResponse.getStatusCode(), StatusCodes.SUCCESS);
    }

    @Test
    public void testNotFoundStatusCodeResponseWithCorrectResource() {
        assertEquals(invalidResourceResponse.getStatusCode(), StatusCodes.NOT_FOUND);
    }

    @Test
    public void testInvalidRequestStatusCode() {
        assertEquals(invalidRequestResponse.getStatusCode(), StatusCodes.BAD_REQUEST);
    }

    @Test
    public void testResourceNotFound() throws IOException {
        byte[] page= Files.readAllBytes(Paths.get(conf.rootPath + "not_found.html"));
        assertArrayEquals(page, invalidResourceResponse.getContentBytes());
    }
}