package API;

import Builder.HttpRequestBuilder;
import URI.URIHelper;
import com.dropbox.core.DbxException;
import org.apache.http.HttpResponse;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.StringEntity;
import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class Client {
    public static HttpResponse uploadFile(String filePath, String fileName) throws DbxException, IOException {
        HttpRequestBuilder request = new HttpRequestBuilder(URIHelper.UPLOAD, "post");
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + URIHelper.ACCESS_TOKEN);
        headers.put("Dropbox-API-Arg",
                                        "{\"autorename\": false,"+
                                        "\"mode\" : \"add\","+
                                        "\"mute\" : false," +
                                        "\"path\":\"/" + fileName + "\","+
                                        "\"strict_conflict\" : false}");
        headers.put("Content-type", "application/octet-stream");
        File fileToUpload = new File(filePath);
        request.addHeaders(headers).addFileBody(new FileEntity(fileToUpload));
        return request.execute();
    }

    public static HttpResponse checkFileExists(String dropBoxFilePath) throws IOException {
        HttpRequestBuilder request = new HttpRequestBuilder(URIHelper.CHECK, "post");
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + URIHelper.ACCESS_TOKEN);
        headers.put("Content-Type", "application/json");
        StringEntity body = new StringEntity("{\"path\": \"" + dropBoxFilePath + "\", " +
                                                "\"include_media_info\":false," +
                                                "\"include_deleted\":false," +
                                                "\"include_has_explicit_shared_members\":false," +
                                                "\"include_mounted_folders\":true," +
                                                "\"include_non_downloadable_files\":true}");
        request.addHeaders(headers).addJsonBody(body);
        return request.execute();
    }

    public static HttpResponse getMetaData(String fileName) throws DbxException, IOException {
        HttpRequestBuilder request = new HttpRequestBuilder(URIHelper.METADATA, "post");
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + URIHelper.ACCESS_TOKEN);
        headers.put("Content-Type", "application/json");
        StringEntity body = new StringEntity("{\"path\":\"/" + fileName + "\", " +
                                            "\"include_deleted\":false," +
                                            "\"include_has_explicit_shared_members\":false, " +
                                            "\"include_media_info\":false}");
        request.addHeaders(headers).addJsonBody(body);
        return request.execute();
    }

    public static HttpResponse deleteFile(String fileName)  throws DbxException, IOException {
        HttpRequestBuilder request = new HttpRequestBuilder(URIHelper.DELETE, "post");
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + URIHelper.ACCESS_TOKEN);
        headers.put("Content-Type", "application/json");
        headers.put("Accept", "application/json");
        StringEntity requestBody = new StringEntity("{\"path\": \"/" + fileName + "\"}");
        request.addHeaders(headers).addJsonBody(requestBody);
        return request.execute();
    }

    public static boolean isSuccessful(HttpResponse response){
        return  response.getStatusLine().getStatusCode() >= 200 && response.getStatusLine().getStatusCode() < 300;
    }
}
