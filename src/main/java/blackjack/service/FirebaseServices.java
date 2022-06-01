package blackjack.service;

import java.util.concurrent.ExecutionException;

import blackjack.Game;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.FieldValue;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

import org.springframework.stereotype.Service;

@Service
public class FirebaseServices  {

    
    public void GameSaving(int wins, int losses, int ties, int totalGames) throws InterruptedException, ExecutionException {
        
        
        Firestore db = FirestoreClient.getFirestore();

        //Create new document in the collection
        DocumentReference docRef = db.collection("Blackjack Session Scoring").document(); 
        System.out.println("Added document with ID: " + docRef.getId());
        
        //Make timestamp field
        ApiFuture<WriteResult> timestamping = docRef.update("timestamp", FieldValue.serverTimestamp());

        //Make wins field
        ApiFuture<WriteResult> winning = docRef.update("wins", wins);

        //Make losses field
        ApiFuture<WriteResult> losing = docRef.update("losses", losses);

        //Make ties field
        ApiFuture<WriteResult> tying = docRef.update("ties", ties);

        //Make total games field
        ApiFuture<WriteResult> totalGamesing = docRef.update("totalGames", totalGames);

        System.out.println("Update time : " + timestamping.get());

    
    }
}
