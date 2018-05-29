package com.journaldev.spring.mongodb.main;


import com.journaldev.spring.mongodb.configurtion.MongoConfig;
import com.journaldev.spring.mongodb.dao.PersonDAO;
import com.journaldev.spring.mongodb.model.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

public class SpringMongoAnnotations {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfig.class);

        PersonDAO personDAO = ctx.getBean("personDAO", PersonDAO.class);
        MongoOperations mongoOperations = ctx.getBean("MT", MongoOperations.class);
        System.out.println(mongoOperations);

        MongoOperations mongoOperations2 = ctx.getBean("MT", MongoOperations.class);
        System.out.println(mongoOperations2);

        Person p = new Person(null, "PankajKr", "Bangalore, India");

        //create
        personDAO.create(p);
        System.out.println("Generated ID="+p.getId());

        //read
        Person p1 = personDAO.readById(p.getId());
        System.out.println("Retrieved Person="+p1);

        //update
        p1.setName("David");p1.setAddress("SFO, USA");
        personDAO.update(p1);
        Person temp = personDAO.readById(p1.getId());
        System.out.println("Retrieved Person after update="+temp);

        //delete
        /*int count = personDAO.deleteById(p1.getId());
        System.out.println("Number of records deleted="+count);*/

        ctx.close();
    }
}
