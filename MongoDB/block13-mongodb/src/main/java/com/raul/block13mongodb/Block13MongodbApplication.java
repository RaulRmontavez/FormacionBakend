package com.raul.block13mongodb;

import com.raul.block13mongodb.aplication.PersonDAL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Block13MongodbApplication implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger("AppsDeveloperBlog");
    private final PersonDAL personDAL;

    @Autowired
    public Block13MongodbApplication(PersonDAL personDAL) {
        this.personDAL = personDAL;
    }

    public static void main(String[] args) {
        SpringApplication.run(Block13MongodbApplication.class, args);
    }

    @Override
    public void run(String... args) {
      /*  personDAL.savePerson(new Persona("Shubham", Arrays.asList("Harry potter", "Waking Up"),12, new Date(769372200000L)));
        personDAL.savePerson(new Persona("Sergey", Arrays.asList("Startup Guides", "Java"),26, new Date(664309800000L)));
        personDAL.savePerson(new Persona("David", Arrays.asList("Harry potter", "Success"),40, new Date(695845800000L)));
        personDAL.savePerson(new Persona("Ivan", Arrays.asList("Secrets of Butene", "Meeting Success"),19, new Date(569615400000L)));
        personDAL.savePerson(new Persona("Sergey", Arrays.asList("Harry potter", "Startup Guides"),60, new Date(348777000000L)));
        LOG.info("Getting all data from MongoDB: \n{}", personDAL.getAllPerson());
        LOG.info("Getting paginated data from MongoDB: \n{}", personDAL.getAllPersonPaginated(0, 2));
        LOG.info("Getting person By name 'Sergey': {}", personDAL.findByName("Sergey"));
        LOG.info("Getting all person By name 'Sergey': {}", personDAL.findOneByName("Sergey"));
        LOG.info("Getting people between age 22 & 26: {}", personDAL.findByAgeRange(22, 26));*/
    }

}
