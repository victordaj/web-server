package responses;


import helpers.FileProvider;
import helpers.Types;
import helpers.StatusCodes;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Response {
    private String httpVersion;
    private String statusCode;
    private String contentType;
    private int contentLength;
    private byte[] contentBytes;
    private FileProvider provider;

    public String getStatusCode() {
        return statusCode;
    }

    public String getContentType() {
        return contentType;
    }

    private String resource;


    public Response(String httpVersion, String statusCode, int contentLength) {
        this.httpVersion = httpVersion;
        this.statusCode = statusCode;
        this.contentType = null;
        this.contentLength = contentLength;
    }

    public Response(String resource, String httpVersion) {
        provider = new FileProvider();
        this.resource = resource;
        this.httpVersion = httpVersion;
        this.contentType = Types.getType(this.resource);
        this.contentBytes = this.getResource();
        this.contentLength = 0;
        if (this.contentBytes != null)
            this.contentLength = this.contentBytes.length;
    }

    public String toString() {
        String response = "";
        response = this.httpVersion + " " + this.statusCode + "\r\n";
        if (this.contentType != null)
            response += "ContentType: " + this.contentType;
        response += "\r\n" + "ContentLength: " + this.contentLength + "\r\n\r\n";
        return response;
    }

    public int getContentLength() {
        return contentLength;
    }

    private byte[] getResource(){
        this.statusCode = StatusCodes.SUCCESS;
        try {
            if (this.resource.equals("/") || this.resource.isEmpty()) {
                return provider.getDefaultPage();
            }
            try {
                return provider.getByteContent(this.resource);
            } catch (FileNotFoundException e) {
                this.statusCode = StatusCodes.NOT_FOUND;
                return provider.getErrorPage();
            }
        } catch (IOException e) {
            e.printStackTrace();
            this.statusCode = StatusCodes.INTERNAL_ERROR;
            return null;
        }
    }

    public byte[] getContentBytes() {
        return this.contentBytes;
    }

}
