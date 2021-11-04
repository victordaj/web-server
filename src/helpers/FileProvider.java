package helpers;

import config.Config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class FileProvider {
    public FileProvider() {
    }

    public byte[] getByteContent(String path) throws IOException {
        byte[] content;
        File file = new File(Config.rootPath, path);
        FileInputStream fin = null;
        fin = new FileInputStream(file);
        content  = new byte[(int)file.length()];
        fin.read(content);
        return content;
    }

    public String getPlainContent(String path) throws IOException {
        String content;
        content = new String(this.getByteContent(path));
        return content;
    }

    public byte[] getDefaultPage() throws IOException {
        return this.getByteContent(Config.defaultPage);
    }

    public byte[] getErrorPage() throws IOException {
        return this.getByteContent(Config.errorPage);
    }
}

