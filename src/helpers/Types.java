package helpers;

public class Types {
    public static String HTML = "text/html";
    public static String CSS = "text/css";
    public static String JPEG = "image/jpeg";
    public static String GIF = "image/gif";
    public static String PLAIN = "text/plain";

    public static String getType(String path) {
        String contentType = Types.PLAIN;
        if (path.endsWith(".html") || path.endsWith(".htm") || path.equals("/") || path.isEmpty())
            contentType = Types.HTML;
        else if (path.endsWith(".css"))
            contentType = Types.CSS;
        else if (path.endsWith(".jpg") || path.endsWith(".jpeg"))
            contentType = Types.JPEG;
        else if (path.endsWith(".gif"))
            contentType = Types.GIF;
        return contentType;
    }
}

