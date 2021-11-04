package requests;

import responses.Response;

public class GetRequest implements Request{

    private String resource;
    private String httpVersion;
    public GetRequest(String data) {
        String[] splitData = data.split(" ");
        this.resource = splitData[1];
        this.resource = this.resource.replace("%20", " ");
        System.out.println(this.resource);
        this.httpVersion = splitData[2];
    }

    @Override
    public String toString() {
        return "GetRequest{" +
                "resource='" + resource + '\'' +
                ", httpVersion='" + httpVersion + '\'' +
                '}';
    }

    @Override
    public Response solve() {
        Response response = new Response(this.resource, this.httpVersion);
        return response;
    }


}
