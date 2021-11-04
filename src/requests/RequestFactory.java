package requests;

public class RequestFactory {
    public RequestFactory() {
    }

    public Request parseRequest(String data) {
        String[] split_data = data.split(" ");
        if (split_data.length >= 3) {
            String method = split_data[0];
            if (method.equals("GET"))
                return new GetRequest(data);
        }
        return new InvalidRequest();

    }

}
