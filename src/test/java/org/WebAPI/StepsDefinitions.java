package org.WebAPI;

import API.Client;
import URI.URIHelper;
import com.dropbox.core.DbxException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.apache.http.HttpResponse;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class StepsDefinitions {

    private HttpResponse response;

    @Given("file {string} exists in project directory")
    public void fileExistsInProjectDirectory(String fileName) {
        try {
            Assertions.assertEquals(fileName, "hello_dropbox.txt");
            FileInputStream file = new FileInputStream(URIHelper.FILE_PATH);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @When("i upload file by API")
    public void iUploadFileByAPI() {
        try {
            response = Client.uploadFile(URIHelper.FILE_PATH, URIHelper.DROPBOX_FILEPATH);
            Assertions.assertTrue(Client.isSuccessful(response));
        } catch (DbxException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("file {string} was added to my dropbox")
    public void fileWasAddedToMyDropbox(String fileName) {
        try {
            HttpResponse checkFileResponse = Client.checkFileExists(URIHelper.DROPBOX_PATH);
            String jsonString = EntityUtils.toString(checkFileResponse.getEntity());
            JSONObject json = new JSONObject(jsonString);
            JSONArray entries = json.getJSONArray("entries");
            Assertions.assertEquals(fileName, entries.getJSONObject(0).getString("name"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Given("file {string} exists in my dropbox")
    public void ifFileExists(String fileName){
        try {
            HttpResponse checkFileResponse = Client.checkFileExists(URIHelper.DROPBOX_PATH);
            String jsonString = EntityUtils.toString(checkFileResponse.getEntity());
            JSONObject json = new JSONObject(jsonString);
            JSONArray entries = json.getJSONArray("entries");
            Assertions.assertEquals(fileName, entries.getJSONObject(0).getString("name"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @When("i successfully send request by API to get file metadata in my dropbox")
    public void iSendRequestByAPIToGetFileMetadataInMyDropbox() {
        try {
            response = Client.getMetaData(URIHelper.DROPBOX_FILEPATH);
            Assertions.assertTrue(Client.isSuccessful(response));
        } catch (DbxException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("i receive {string} file metadata")
    public void iReceiveFileMetadataFileWasSuccessfullDeleteFromMyDropbox(String fileName) {
        try {
            String retSrc = EntityUtils.toString(response.getEntity());
            JSONObject json = new JSONObject(retSrc);
            String fileNameReturned = json.getString("name");
            Assertions.assertEquals(URIHelper.FILE_NAME, fileNameReturned);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @When("i successfully send request by API to delete file from my dropbox")
    public void iSendRequestByAPIToDeleteFileFromMyDropbox() {
        try {
            response = Client.deleteFile(URIHelper.DROPBOX_FILEPATH);
            Assertions.assertTrue(Client.isSuccessful(response));
        } catch (DbxException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("file {string} was delete from my dropbox")
    public void fileWasSuccessfullyDeleteFromMyDropbox(String fileName) {
        try {
            HttpResponse checkFileResponse = Client.checkFileExists(URIHelper.DROPBOX_PATH);
            String jsonString = EntityUtils.toString(checkFileResponse.getEntity());
            JSONObject json = new JSONObject(jsonString);
            JSONArray entries = json.getJSONArray("entries");
            Assertions.assertEquals(0, entries.length());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
