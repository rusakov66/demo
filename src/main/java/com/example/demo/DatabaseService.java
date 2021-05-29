package com.example.demo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.ObjectInputFilter;

@Component
public class DatabaseService {

    @Autowired
    private Environment env;

    private String uri;
    private MongoClient mongoClient;

    private void connectToDb() {
        this.uri = env.getProperty("mongoUri");
        MongoClientURI mongoClientURI = new MongoClientURI(uri);
        this.mongoClient = new MongoClient(mongoClientURI);
    }

}
