Feature: WebAPI basics Homework

  Scenario: upload file "hello_dropbox.txt" to dropbox
    Given file "hello_dropbox.txt" exists in project directory
    When i upload file by API
    Then file "hello_dropbox.txt" was added to my dropbox

  Scenario: get file "hello_dropbox.txt" metadata on dropbox
    Given file "hello_dropbox.txt" exists in my dropbox
    When i successfully send request by API to get file metadata in my dropbox
    Then i receive "hello_dropbox.txt" file metadata

  Scenario: delete file "hello_dropbox.txt" from my dropbox
    Given file "hello_dropbox.txt" exists in my dropbox
    When i successfully send request by API to delete file from my dropbox
    Then file "hello_dropbox.txt" was delete from my dropbox
