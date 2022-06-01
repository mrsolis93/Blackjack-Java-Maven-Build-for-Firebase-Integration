package blackjack.service;

import java.io.FileInputStream;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@Service
public class FirebaseInitialize {

    @PostConstruct
    public void initialize() {

        try{

            FileInputStream serviceAccount =
            new FileInputStream("./ServiceAccount.json");
        
            FirebaseOptions options = FirebaseOptions.builder()
            .setProjectId("blackjack-java")
            .setCredentials(GoogleCredentials.fromStream(serviceAccount))
            .build();
        
            FirebaseApp.initializeApp(options);
            Firestore db = FirestoreClient.getFirestore();
        }
        catch(Exception e) {
            System.out.println("Error: " + e);
        }
    }

}
