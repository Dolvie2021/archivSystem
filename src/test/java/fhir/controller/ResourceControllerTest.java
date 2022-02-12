package fhir.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ResourceControllerTest {

    @Autowired
    ResourceController resourceController;


    @Test
    void testController(){
        assertThat(resourceController).isNotNull();
    }


}