package fhir;

import fhir.models.Resource;
import fhir.models.User;
import fhir.repository.ResourceRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;


@WebMvcTest
@SpringBootTest
class FhirApplicationTest {


    @Autowired
    private ResourceRepository repo;


    /**
     * method to test if Create new user are correct
     * it will be true just when we new run the entire App
     * and we have to make some changes in the properties file
     */
    @Test
    void testNewUsers() {

      //  User user = new User();
      //  user.setUsername("test");
      //  user.setRoles("ADMIN_ROLE");
      //  user.setPassword("1234");
      //  user.setActive(true);
      //  user.setUser_id(1);

      //  assertNotNull(repo.findById(1).get());

    }
}