package fhir.service;

import fhir.models.User;
import fhir.repository.UserRepository;
import org.junit.jupiter.api.*;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.verify;

@SpringBootTest
public class MyUserDetailsServiceTest {

    @Mock
    private UserRepository userRepository;
    private AutoCloseable autoCloseable;
    private MyUserDetailsService myUserDetailsService;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        myUserDetailsService = new MyUserDetailsService(userRepository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void userExists() {

        MyUserDetailsService myUserDetailsService = new MyUserDetailsService(userRepository);
        myUserDetailsService.userExists("Example");
        verify(userRepository).findByUsername("Example");
    }

    @Test
    void findByUserName() {
        userRepository.findByUsername("name");

        verify(userRepository).findByUsername("name");

    }

/*
    @Test
    void loadUserByUsernameTest() {
        String name = "max";
        User user = new User();
        user.setUser_id(1);
        user.setUsername(name);
        user.setRoles("ADMIN_ROLE");
        user.setPassword("password");
        user.setActive(true);

        userRepository.save(user);

        ArgumentCaptor<User> userArgumentCaptor = ArgumentCaptor.forClass(User.class);

    }

 */
}