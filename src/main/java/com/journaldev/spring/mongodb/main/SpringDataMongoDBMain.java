package com.journaldev.spring.mongodb.main;

import com.journaldev.spring.mongodb.model.Person;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public class SpringDataMongoDBMain {

	public static final String DB_NAME = "journaldev";
	public static final String PERSON_COLLECTION = "Person";

	public static void main(String[] args) {
			MongoClientURI uri = new MongoClientURI("mongodb+srv://viksokil:270487@viktorclaster-uioz9.mongodb.net/test");
			MongoClient mongo = new MongoClient(uri);
			MongoOperations mongoOps = new MongoTemplate(mongo, DB_NAME);
			Person p = new Person("25", "PankajKr", "Bangalore, India");
			mongoOps.insert(p, PERSON_COLLECTION);

			Person p1 = mongoOps.findOne(
					new Query(Criteria.where("name").is("PankajKr")),
					Person.class, PERSON_COLLECTION);

			System.out.println(p1);
			
			mongoOps.dropCollection(PERSON_COLLECTION);
			mongo.close();
			
	}

}
