package com.liupan.mongodb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.BsonDocument;
import org.bson.BsonValue;
import org.bson.Document;
import org.bson.conversions.Bson;

import com.liupan.mongodb.util.GetMongoClient;
import com.mongodb.MongoClient;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;

public class ZSGC {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		MongoClient client = GetMongoClient.getClient();
		MongoDatabase database = client.getDatabase("mapinfo");
		MongoCollection<Document> collection = database.getCollection("mapinfo");
//		collection.insertOne(Document.parse("{\"hello\":\"world\"}"));
		FindIterable<Document> findIterable = collection.find();
//		BsonDocument bsonDocument=new BsonDocument();
//		
//		
//		BsonDocument bsonValue=new BsonDocument();
//		
//		
//		BsonDocument bsonValue1=new BsonDocument();
//		BsonDocument bsonValue2=new BsonDocument();
//		bsonValue1.parse("{ \"type\": \"Point\",  \"coordinates\": \"[118.873641,31.73028]\"},\"distanceField\": \"distance\",\"spherical\": \"true\"}");
//		
//		bsonValue.append("near", bsonValue1);
//		
//		bsonDocument.append("$geoNear", bsonValue);
//		
////		 $geoNear: {
////		     near: { type: "Point",  coordinates: [118.873641,31.73028]},
////		        distanceField: "distance",
////		        spherical: true
////		     }
////		}
//		List<Bson> list=new ArrayList<>();
//		list.add(bsonDocument);
//		Arrays.asList(new Document()); 这个是可以把任何类型都变成list的吗，不仅仅限制在数组上
		List<Document> asList = Arrays.asList(new Document("$geoNear", 
				new Document("near", new Document("type", "Point").append("coordinates", Arrays.asList(new double[]{118.873641,31.73028}))
						.append("distanceField", "calculated").append("spherical", Boolean.TRUE))));
		String serialize = JSON.serialize(asList);
		System.out.println(serialize);
		AggregateIterable<Document> aggregate = collection.aggregate(asList);
		
		for(Document doc:findIterable){
			System.out.println(doc.toJson());
		}
//		  collection.deleteOne(eq("_id", 9999));
//		for(Document doc:aggregate){
//			System.out.println("***"+doc.toJson());
//		}
		

	}

}
