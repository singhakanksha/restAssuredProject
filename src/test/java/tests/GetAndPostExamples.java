package tests;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class GetAndPostExamples {
    @Test
    public void testGet(){
        baseURI = "https://reqres.in/api";
        given()
                .get("/users?page=2")
                .then()
                .statusCode(200)
                .body("data[4].first_name", equalTo("George"))
                .body("data.first_name",hasItems("Michael","Lindsay"))
                 ;
    }

    @Test
    public void testPost(){
        JSONObject request = new JSONObject();
        request.put("name","morpheus");
        request.put("job", "leader");
        baseURI = "https://reqres.in/api";
        given()
                .header("Content-Type","application/json")
                .body(request.toJSONString())
                .when()
                .post("/users")
                .then()
                .statusCode(201).log().all();
    }

}
