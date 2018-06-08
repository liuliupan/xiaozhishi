package com.liupan.mongodb.util;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class GetMongoClient {

    public static MongoClient getClient() {


            // To connect to mongodb server
            MongoClient mongoClient = new MongoClient("localhost", 27017);

            // Now connect to your databases
            MongoDatabase mgdb = mongoClient.getDatabase("mapinfo");

            System.out.println("Connect to database successfully!");
            System.out.println("MongoDatabase inof is : "+mgdb.getName());
            // If MongoDB in secure mode, authentication is required.
            // boolean auth = db.authenticate(myUserName, myPassword);
            // System.out.println("Authentication: "+auth);
            return mongoClient;
    }
}