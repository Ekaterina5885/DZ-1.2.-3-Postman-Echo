package ru.netology;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoTest {
    @Test
    public void shouldPostToPostmanEcho() {
        given()
                .baseUri("https://postman-echo.com")
                .body("some data")
        .when()
                .post("/post")
        .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("data", equalTo("some data"))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("headers.user-agent", equalTo("Apache-HttpClient/4.5.3 (Java/11.0.11)"))
                .body("headers.host", equalTo("postman-echo.com"))
        ;
    }
}