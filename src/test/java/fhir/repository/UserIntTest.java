package fhir.repository;

import fhir.models.User;
import fhir.repository.UserRepository;
import fhir.service.MyUserDetailsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
public class UserIntTest {

    @Autowired
    private MockMvc mockMvc;

    /**
     * this is an Integration Test
     * and Uses a H2 Database
     * its write a Query to test the Class
     *
     *
     * @throws Exception
     */
    @Test
    public void findUser() throws Exception{
        MvcResult mvcResult = mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/admin/").accept(MediaType.APPLICATION_JSON))
                .andReturn();

        System.out.println(mvcResult.getResponse());
    }
}
