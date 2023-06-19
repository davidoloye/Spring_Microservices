package Test;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
@Testcontainers
@RequiredArgsConstructor
public class Test {

    @Container
    static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongodb:3.8");

    @DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry registry){
        registry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);

    }

    @org.junit.jupiter.api.Test
    public void contextLoads(){

    }


}
