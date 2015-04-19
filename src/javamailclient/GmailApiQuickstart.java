package javamailclient;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.auth.oauth2.GoogleOAuthConstants;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.ListLabelsResponse;
import com.google.api.services.gmail.model.Thread;
import com.google.api.services.gmail.model.ListThreadsResponse;
import com.google.api.services.gmail.model.Profile;
import java.awt.Label;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import static jdk.nashorn.internal.objects.Global.print;

public class GmailApiQuickstart {
  
  // Check https://developers.google.com/gmail/api/auth/scopes for all available scopes
  private static final String SCOPE = "https://mail.google.com/";
  private static final String APP_NAME = "Gmail API Quickstart";
  // Email address of the user, or "me" can be used to represent the currently authorized user.
  private static final String USER = "me";
  // Path to the client_secret.json file downloaded from the Developer Console
  private static final String CLIENT_SECRET_PATH = "client_secret_699951936283-lnrs2pff1ho2j6t9eqdd2q84vbtm1ptq.apps.googleusercontent.com.json";
  //private static final String AUTH_CODE = "4/X0cDZ-JAxZK2OIXlnHuyh7UzCYKQd5pCkeqsaG8gMWw.otGZh2dcKGIbcp7tdiljKKYvayKYmQI";
  private static GoogleClientSecrets clientSecrets;

  public static void main (String [] args) throws IOException {
    HttpTransport httpTransport = new NetHttpTransport();
    JsonFactory jsonFactory = new JacksonFactory();

    clientSecrets = GoogleClientSecrets.load(jsonFactory,  new FileReader(CLIENT_SECRET_PATH));

    // Allow user to authorize via url.
    GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
        httpTransport, jsonFactory, clientSecrets, Arrays.asList(SCOPE))
        .setAccessType("online")
        .setApprovalPrompt("auto").build();

    String url = flow.newAuthorizationUrl().setRedirectUri(GoogleOAuthConstants.OOB_REDIRECT_URI)
        .build();
    System.out.println("Please open the following URL in your browser then type"
                       + " the authorization code:\n" + url);

    // Read code entered by user.
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String code = br.readLine();

    // Generate Credential using retrieved code.
    GoogleTokenResponse response = flow.newTokenRequest(code)
        .setRedirectUri(GoogleOAuthConstants.OOB_REDIRECT_URI).execute();
    GoogleCredential credential = new GoogleCredential()
        .setFromTokenResponse(response);

    // Create a new authorized Gmail API client
    Gmail service = new Gmail.Builder(httpTransport, jsonFactory, credential)
        .setApplicationName(APP_NAME).build();

    //System.out.println(service.users().getProfile(USER).toString());
    //System.out.println(service.users().getProfile(url).);
    Profile profile = service.users().getProfile(USER).execute();
      System.out.println(profile.getEmailAddress());
    //ListMessservice.users().messages().list(USER).execute();
    // Retrieve a page of Threads; max of 100 by default.
    ListThreadsResponse threadsResponse = service.users().threads().list(USER).execute();
    List<Thread> threads = threadsResponse.getThreads();

   
    // Print ID of each Thread.
    for (Thread thread : threads) {
      System.out.println("Thread ID: " + thread.getId());
    }
  }

}
