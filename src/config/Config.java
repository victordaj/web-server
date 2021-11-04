package config;
import java.io.*;
import java.util.Properties;
public class Config {
    public static int port;
    private final String configPath = "config.properties";
    public static String rootPath;
    public static String defaultPage;
    public static String errorPage;
    private Properties props;
    public Config() {
        props = new Properties();
        File file = new File(configPath);
        if (file.exists())
            loadProperties();
        else {

            props.setProperty("rootPath", "C:\\Users\\Victor-PC\\Desktop\\SVV\\web-server\\htdocs\\");
            props.setProperty("defaultPage", "index.html");
            props.setProperty("errorPage", "not_found.html");
            props.setProperty("port", "9000");
            saveProperties();
        }
        Config.rootPath = props.getProperty("rootPath");
        Config.defaultPage = props.getProperty("defaultPage");
        Config.errorPage = props.getProperty("errorPage");
        Config.port = Integer.parseInt(props.getProperty("port"));
    }

    private void saveProperties() {
        try (OutputStream output = new FileOutputStream(configPath)) {
            props.store(output, null);
        } catch (IOException io) {
            io.printStackTrace();
        }
    }
    private void loadProperties() {
        try (InputStream input = new FileInputStream(configPath)) {
            this.props.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getRootPath() {
        return rootPath;
    }

    public void setRootPath(String rootPath) {
        this.rootPath = rootPath;
    }

}
