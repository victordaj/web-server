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
    private FileProvider provider = new FileProvider();
    private Config conf = new Config();

    @Test
    public void getByteContentFileExists() throws IOException {
        byte[] mockedBytes = "Hello TXT works".getBytes();
    }

    @Test
    public void getByteContentFileNotExists() throws IOException {
        assertThrows(FileNotFoundException.class, () -> {
            byte[] content  = provider.getByteContent("notExists.txt");
        });
    }

    @Test
    public void getPlainContentFound() throws IOException {
        String mockedString = "Hello TXT works";
        assertEquals(mockedString, provider.getPlainContent("a.txt"));
    }

    @Test
    public void getPlainContentNotFound() throws IOException {
        assertThrows(FileNotFoundException.class, () -> {
            String content = provider.getPlainContent("notExists.txt");
        });
    }

    @Test
    public void getDefaultPage() throws IOException {
        byte[] homePage = Files.readAllBytes(Paths.get(conf.rootPath + "index.html"));
        assertArrayEquals(homePage, provider.getDefaultPage());
    }

    @Test
    public void getErrorPage() throws IOException {
        byte[] homePage = Files.readAllBytes(Paths.get(conf.rootPath + "not_found.html"));
        assertArrayEquals(homePage, provider.getErrorPage());
    }
}