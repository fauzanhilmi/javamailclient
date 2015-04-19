/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamailclient;

import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
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
import com.google.api.services.gmail.model.Thread;
import com.google.api.services.gmail.model.ListThreadsResponse;
import com.google.api.client.repackaged.org.apache.commons.codec.binary.Base64;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.Message;
import com.google.api.services.gmail.model.Profile;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fauzan Hilmi
 */
public class GmailAPI {
  private static final String SCOPE = "https://mail.google.com/";
  private static final String APP_NAME = "Gmail API Quickstart";
  // Email address of the user, or "me" can be used to represent the currently authorized user.
  private static final String USER = "me";
  // Path to the client_secret.json file downloaded from the Developer Console
  
  private static final String CLIENT_SECRET_PATH = "client_secret_699951936283-lnrs2pff1ho2j6t9eqdd2q84vbtm1ptq.apps.googleusercontent.com.json";
  private static final String AUTH_CODE = "";
  private static GoogleClientSecrets clientSecrets;
  
  public static String AUTH_URL = "https://accounts.google.com/o/oauth2/auth?access_type=online&approval_prompt=auto&client_id=699951936283-lnrs2pff1ho2j6t9eqdd2q84vbtm1ptq.apps.googleusercontent.com&redirect_uri=urn:ietf:wg:oauth:2.0:oob&response_type=code&scope=https://mail.google.com/";
  public static Gmail service;
  public static String USER_EMAIL;
  
  public static void main(String[] args) {
      String to = "13512003@std.stei.itb.ac.id";
      String from = "fhilmir@gmail.com";
      String subject = "tes juga ";
      String bodyText = "hai juga kk";
      
      //String userId = "me";
      
      /*try {
          GmailAPI.initialize();
          try {
              MimeMessage mm = GmailAPI.createEmail(to, from, subject, bodyText);
              GmailAPI.sendMessage(GmailAPI.service, USER, mm);
          } catch (MessagingException ex) {
              Logger.getLogger(GmailAPI.class.getName()).log(Level.SEVERE, null, ex);
          }
      } catch (IOException ex) {
          Logger.getLogger(GmailAPI.class.getName()).log(Level.SEVERE, null, ex);
      }
      */      
  }
  
  //ngeset service & USER_EMAIl
  public static void initialize(String code) throws IOException {
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
    //System.out.println("Please open the following URL in your browser then type"+" the authorization code:\n" + url);

    // Read code entered by user.
    //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //String code = br.readLine();

    // Generate Credential using retrieved code.
    GoogleTokenResponse response = flow.newTokenRequest(code)
        .setRedirectUri(GoogleOAuthConstants.OOB_REDIRECT_URI).execute();
    GoogleCredential credential = new GoogleCredential()
        .setFromTokenResponse(response);

    // Create a new authorized Gmail API client
    service = new Gmail.Builder(httpTransport, jsonFactory, credential)
        .setApplicationName(APP_NAME).build();

    Profile profile = service.users().getProfile(USER).execute();
    USER_EMAIL = profile.getEmailAddress();
      
    /*ListThreadsResponse threadsResponse = service.users().threads().list(USER).execute();
    List<Thread> threads = threadsResponse.getThreads();

    // Print ID of each Thread.
    for (Thread thread : threads) {
      System.out.println("Thread ID: " + thread.getId());
    }*/
  }
  
   /**
   * Send an email from the user's mailbox to its recipient.
   *
   * @param service Authorized Gmail API instance.
   * @param userId User's email address. The special value "me"
   * can be used to indicate the authenticated user.
   * @param email Email to be sent.
   * @throws MessagingException
   * @throws IOException
   */
  public static void sendMessage(Gmail service, String userId, MimeMessage email)
      throws MessagingException, IOException {
    Message message = createMessageWithEmail(email);
    message = service.users().messages().send(userId, message).execute();

    System.out.println("Message id: " + message.getId());
    System.out.println(message.toPrettyString());
  }

  /**
   * Create a Message from an email
   *
   * @param email Email to be set to raw of message
   * @return Message containing base64url encoded email.
   * @throws IOException
   * @throws MessagingException
   */
  public static Message createMessageWithEmail(MimeMessage email)
      throws MessagingException, IOException {
    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    email.writeTo(bytes);
    String encodedEmail = Base64.encodeBase64URLSafeString(bytes.toByteArray());
    Message message = new Message();
    message.setRaw(encodedEmail);
    return message;
  }

  /**
   * Create a MimeMessage using the parameters provided.
   *
   * @param to Email address of the receiver.
   * @param from Email address of the sender, the mailbox account.
   * @param subject Subject of the email.
   * @param bodyText Body text of the email.
   * @return MimeMessage to be used to send email.
   * @throws MessagingException
   */
  public static MimeMessage createEmail(String to, String from, String subject,
      String bodyText) throws MessagingException {
    Properties props = new Properties();
    Session session = Session.getDefaultInstance(props, null);

    MimeMessage email = new MimeMessage(session);
    InternetAddress tAddress = new InternetAddress(to);
    InternetAddress fAddress = new InternetAddress(from);

    email.setFrom(new InternetAddress(from));
    email.addRecipient(javax.mail.Message.RecipientType.TO,
                       new InternetAddress(to));
    email.setSubject(subject);
    email.setText(bodyText);
    return email;
  }

  /**
   * Create a MimeMessage using the parameters provided.
   *
   * @param to Email address of the receiver.
   * @param from Email address of the sender, the mailbox account.
   * @param subject Subject of the email.
   * @param bodyText Body text of the email.
   * @param fileDir Path to the directory containing attachment.
   * @param filename Name of file to be attached.
   * @return MimeMessage to be used to send email.
   * @throws MessagingException
   */
  public static MimeMessage createEmailWithAttachment(String to, String from, String subject,
      String bodyText, String fileDir, String filename) throws MessagingException, IOException {
    Properties props = new Properties();
    Session session = Session.getDefaultInstance(props, null);

    MimeMessage email = new MimeMessage(session);
    InternetAddress tAddress = new InternetAddress(to);
    InternetAddress fAddress = new InternetAddress(from);

    email.setFrom(fAddress);
    email.addRecipient(javax.mail.Message.RecipientType.TO, tAddress);
    email.setSubject(subject);

    MimeBodyPart mimeBodyPart = new MimeBodyPart();
    mimeBodyPart.setContent(bodyText, "text/plain");
    mimeBodyPart.setHeader("Content-Type", "text/plain; charset=\"UTF-8\"");

    Multipart multipart = new MimeMultipart();
    multipart.addBodyPart(mimeBodyPart);

    mimeBodyPart = new MimeBodyPart();
    DataSource source = new FileDataSource(fileDir + filename);

    mimeBodyPart.setDataHandler(new DataHandler(source));
    mimeBodyPart.setFileName(filename);
    String contentType = Files.probeContentType(FileSystems.getDefault()
        .getPath(fileDir, filename));
    mimeBodyPart.setHeader("Content-Type", contentType + "; name=\"" + filename + "\"");
    mimeBodyPart.setHeader("Content-Transfer-Encoding", "base64");

    multipart.addBodyPart(mimeBodyPart);

    email.setContent(multipart);

    return email;
  }
}
