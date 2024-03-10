package com.funda.registeraccount.web;

import com.funda.registeraccount.dto.RolesDTO;
import com.funda.registeraccount.dto.UserDTO;
import io.restassured.http.ContentType;
import lombok.Builder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.jupiter.api.Assertions.*;


@Testcontainers
public class UserControllerTest {

    UserDTO userDTO;
    RolesDTO dto;
    List<RolesDTO>rolesDTOS;
    @Container
    @ServiceConnection
    static MySQLContainer<?>container = new MySQLContainer<>("mysql:latest");

    String baseurl="http/localhost:8080/api/v1";
    @BeforeEach
    void setUp() {

         dto = RolesDTO.builder().description("admin role").name("admin").id(1L).build();
         rolesDTOS = Collections.singletonList(dto);
         userDTO = UserDTO.builder().firstName("Mkhululi").lastName("Tyhobeka").status("Active").password("testing123").username("mkhulityhobeka@gmail.com").rolesDTO(rolesDTOS).build();
    }

    @Test
    public  void isContainterCreated(){
        assertThat(container.isCreated()).isTrue();
        assertThat(container.isRunning()).isTrue();
    }
    @Test
    void createUserAccount() {
    }

    @Test
    void getUserBbyUsername() {
       given()
               .baseUri(baseurl)
               .accept(ContentType.JSON)
               .get("/user/mkhuselityhobeka@gmail.com")
               .then()
               .assertThat()
               .body("firstname", equalTo("mkhuseli"))
               .assertThat()
               .body("rolesDTO", hasItems("testing"))
               .assertThat().body("status",equalTo("active"));


    }

    @Test
    void updateUserDetails() {

        
    }

    @Test
    void deleteUser() {
    }

    @Test
    void userStatusUpdate() {
    }

    @Test
    void findAllUsers() {
    }
}