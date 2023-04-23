package tests;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class GetExamples {
    @Test
    public void test_1(){
        Response response = get("https://reqres.in/api/users?page=2");
        System.out.println(response.statusCode());
        System.out.println(response.getTime());
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusLine());
        int actual = response.statusCode();
        Assert.assertEquals(actual, 200);
    }

    @Test
    public void test_2(){
        baseURI = "https://reqres.in/api";
        given()
                .get("/users?page=2")
                .then()
                .statusCode(200)
                .body("data[0].id",equalTo(7))
                .log().all();

    }
}
