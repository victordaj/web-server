package test;

import config.Config;
import helpers.FileProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class FileProviderTest {
    private FileProvider cp = new FileProvider();

    @Test
    public void getByteContentFileExists() throws IOException {
        byte[] mockedBytes = "Hello TXT works".getBytes();
    }

    @Test
    public void getByteContentFileNotExists() throws IOException {
        byte[] content  = cp.getByteContent("this_is_not_a_file_that_exists.txt");
        assertThrows(FileNotFoundException.class, () -> {
            System.out.println("Exception");
        });
    }

    @Test
    public void getPlainContentFound() throws IOException {
        String mockedString = "Hello TXT works";
        assertEquals(mockedString, cp.getPlainContent("a.txt"));
    }

    @Test
    public void getPlainContentNotFound() throws IOException {
        String content = cp.getPlainContent("this_is_not_a_file_that_exists.txt");
        assertThrows(FileNotFoundException.class, () -> {
            System.out.println("Exception");
        });
    }

    @Test
    public void getDefaultPage() throws IOException {
        byte[] homePage = Files.readAllBytes(Paths.get(Config.rootPath + "index.html"));
        assertArrayEquals(homePage, cp.getDefaultPage());
    }

    @Test
    public void getErrorPage() throws IOException {
        byte[] homePage = Files.readAllBytes(Paths.get(Config.rootPath + "not_found.html"));
        assertArrayEquals(homePage, cp.getErrorPage());
    }
}