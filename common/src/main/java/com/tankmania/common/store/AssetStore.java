package com.tankmania.common.store;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.AbstractInputStreamContent;
import com.google.api.client.http.ByteArrayContent;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.tankmania.common.model.Asset;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AssetStore {

    private static final String APPLICATION_NAME = "tankmania";
    private static final String USER_ID = "tankmania.seguiwars@gmail.com";
    private static final String FILE_ID = "10lWfnHt9Ie5ONyJjmiTljAuQwf86xOIpU7-wkJKWqtE";
    private static final String CREDENTIALS_FILE = "/client_id.json";

    private final Drive driveService;

    public AssetStore() {
        this.driveService = createDriveService();
    }

    public List<Asset> getAssets() {
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            driveService.files().export(FILE_ID, "text/plain").executeMediaAndDownloadTo(outputStream);
            JsonReader reader = new JsonReader(new InputStreamReader(new ByteArrayInputStream(outputStream.toByteArray()), "UTF-8"));
            return new Gson().fromJson(reader, new TypeToken<List<Asset>>(){}.getType());
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<Asset>();
        }
    }

    public void setAssets(String content) {
        try {
            File file = driveService.files().get(FILE_ID).execute();
            AbstractInputStreamContent stream = new ByteArrayContent(null, content.getBytes("UTF-8"));
            driveService.files().update(file.getId(), new File(), stream).execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Drive createDriveService() {
        try {
            final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            return new Drive.Builder(HTTP_TRANSPORT, JacksonFactory.getDefaultInstance(), getCredentials(HTTP_TRANSPORT))
                    .setApplicationName(APPLICATION_NAME)
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
        InputStream in = AssetStore.class.getResourceAsStream(CREDENTIALS_FILE);
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JacksonFactory.getDefaultInstance(), new InputStreamReader(in));

        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT, JacksonFactory.getDefaultInstance(), clientSecrets, Arrays.asList(DriveScopes.DRIVE, DriveScopes.DRIVE_FILE, DriveScopes.DRIVE_APPDATA, DriveScopes.DRIVE_SCRIPTS, DriveScopes.DRIVE_METADATA))
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File("tokens")))
                .setAccessType("offline")
                .build();
        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
        return new AuthorizationCodeInstalledApp(flow, receiver).authorize(USER_ID);
    }
}
