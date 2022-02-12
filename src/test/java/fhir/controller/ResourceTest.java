package fhir.controller;


import fhir.service.ResourceProvider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(ResourceController.class)
public class ResourceTest {

    @MockBean
    private ResourceProvider provider;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testFile () throws Exception{


    }


}
