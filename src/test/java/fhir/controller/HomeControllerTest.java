package fhir.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import fhir.models.User;
import fhir.service.MyUserDetailsService;
import org.aspectj.lang.annotation.Before;
import org.fhir.ucum.UcumService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.http.MediaType;


import java.io.File;
import java.nio.file.Files;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class HomeControllerTest {

    @Autowired
    MyUserDetailsService myUserDetailsService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private ObjectMapper mapper;

    /**
     * index home/login
     * to test if if the login is in Home or by default is main home page
     * is the loge-in page.
     * @throws Exception
     */
    @Test
    public void testIndex() throws Exception {
        File login = new ClassPathResource("templates/home.html").getFile();
        String html = new String(Files.readAllBytes(login.toPath()));

        this.mockMvc.perform(get("/home"))
                .andExpect(redirectedUrl("http://localhost/login"))
                //.andExpect(content().string(html)) // just to test what is written in the Html file.
                .andDo(print());
    }

    /*
    @Before("testSaveUser")
    public void prepare(){
        mockMvc = MockMvcBuilders.standaloneSetup(context).apply(springSecurity()).build();
    }

    @Test
    void testSaveUser() throws Exception{
        User user = new User();
        user.setUsername("name");
        user.setActive(true);
        user.setPassword("pwd");
        user.setRoles("ADMIN_ROLES");

      //  String jsonRequest = mapper.writeValueAsString(user);

        MvcResult result = mockMvc.perform((RequestBuilder) post("/saveUser/{id}")
                .contentType(MediaType.ALL)).andExpect(status().isOk()).andReturn();


        assertEquals(200, result.getResponse().getStatus());
    }*/
    @Test
    public void editUserTest(){
    }

    @Test
    public void testAdmin(){

    }

    @Test
    void TestLogin() {
        HomeController homeController = new HomeController(myUserDetailsService);
        assertEquals("login",homeController.login());
    }

    @Test
    void TestLogout() {
        HomeController homeController = new HomeController(myUserDetailsService);
        assertEquals("redirect:/login?logout",homeController.logout());
    }

    @Test
    void testNewdaten() {
        HomeController homeController = new HomeController(myUserDetailsService);
        assertEquals("newdatenhochladen",homeController.newdaten());
    }
}