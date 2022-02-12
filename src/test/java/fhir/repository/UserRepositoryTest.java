package fhir.repository;

import fhir.models.User;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

@DataJpaTest
class UserRepositoryTest {


    @Autowired
    private UserRepository userRepository;

/*
    @Test
    public void ifNameOfUserExistTest() {
        String name = "max";
        User user = new User();
        user.setUsername(name);
        user.setRoles("ADMIN_ROLE");
        user.setPassword("password");
        user.setActive(true);

        userRepository.save(user);

        assertThat(user.getUsername()).isEqualTo("max");


    }

    @Test
    public void getUserTest(){
        User user = userRepository.findById(0).get();

        assertThat(user.getUser_id()).isEqualTo(0);


    }

 */







    /**
     * this test is a Unit-Test because of the (mockitos)
     * and for this one it is already written an Integration Test
     *in Class UserIntTest
     * and this one is no more needed
     *
     * @throws Exception
     */
   // @Test
   // void findByUsername() throws Exception {

   //     when(userRepository.findAll()).thenReturn(Collections.emptyList());


     //   MvcResult mvcResult = mockMvc
     //           .perform(MockMvcRequestBuilders
     //                   .get("/admin/").accept(MediaType.ALL))
     //           .andReturn();

     //   System.out.println(mvcResult.getResponse());

     //   verify(userRepository).findAll();

   // }
}