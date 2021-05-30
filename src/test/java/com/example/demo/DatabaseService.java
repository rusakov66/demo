package com.example.demo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lombok.*;
import org.bson.BsonDocument;
import org.bson.BsonString;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.security.Security;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Component
public class DatabaseService {

    @Autowired
    private Environment env;

    private String uri;
    private MongoClient mongoClient;

    public void connectToDb() {
        this.uri = env.getProperty("mongoUri");
        MongoClientURI mongoClientURI = new MongoClientURI(uri);
        this.mongoClient = new MongoClient(mongoClientURI);
    }

    @SneakyThrows
    public boolean findEntity(String database, String nameOfCollection, String key, String value) {

//        System.setProperty("jdk.tls.trustNameService", "true");
//        Security.setProperty("jdk.tls.trustNameService", "true");
        Security.setProperty("jdk.tls.disabledAlgorithms", "" /*disabledAlgorithms */ );
        this.connectToDb();
        MongoDatabase db = mongoClient.getDatabase(database);
        MongoCollection<Document> collection = db.getCollection(nameOfCollection);
        Document searched = collection.find().first();
        long count = collection.countDocuments(new BsonDocument(key, new BsonString(value)));
        if (count > 0) return true;
        return false;
    }

}
