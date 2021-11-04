package requests;

import responses.Response;
import helpers.StatusCodes;

public class InvalidRequest implements Request {
    private String httpVersion;
    public InvalidRequest() {
        this.httpVersion = "HTTP/1.1";
    }
    @Override
    public Response solve() {
        return new Response(httpVersion, StatusCodes.BAD_REQUEST, 0);
    }
}
