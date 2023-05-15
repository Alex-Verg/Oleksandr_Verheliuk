package Builder;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.util.Map;

public class HttpRequestBuilder {
    private HttpClient httpClient;
    private String URI;
    private String method;
    private HttpPost postRequest;
    private HttpGet getRequest;

    public HttpRequestBuilder(String URI, String method){
        this.httpClient = HttpClientBuilder.create().build();
        this.URI = URI;
        this.method = method;
        if (this.method.equals("post"))
            postRequest = new HttpPost(this.URI);
        else if(this.method.equals("get"))
            getRequest = new HttpGet(this.URI);
    }

    public HttpRequestBuilder addHeaders(Map<String, String> headers){
        for (Map.Entry<String, String> header: headers.entrySet()){
            if (this.method.equals("post"))
                postRequest.addHeader(header.getKey(), header.getValue());
            else if(this.method.equals("get"))
                getRequest.addHeader(header.getKey(), header.getValue());
        }
        return this;
    }

    public HttpRequestBuilder addJsonBody(StringEntity body){
        postRequest.setEntity(body);
        return this;
    }

    public HttpRequestBuilder addFileBody(FileEntity body){
        postRequest.setEntity(body);
        return this;
    }

    public HttpResponse execute() throws IOException {
        if (this.method.equals("post")){
            HttpResponse response = httpClient.execute(postRequest);
            System.out.println(response);
            return response;
        }
        else if (this.method.equals("get")){
            HttpResponse response = httpClient.execute(getRequest);
            System.out.println(response);
            return response;
        }

        return null;
    }
}