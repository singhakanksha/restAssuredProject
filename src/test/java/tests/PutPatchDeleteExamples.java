package tests;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class PutPatchDeleteExamples {

    @Test
    public void testPut(){
        baseURI = "https://reqres.in/api";
        JSONObject request = new JSONObject();
        request.put( "name","morpheus");
        request.put( "job","zion resident");
                 given()
                .header("Content-Type","application/json")
                .body(request.toJSONString())
                .when()
                .put("/users/2")
                .then()
                .statusCode(200).log().all()
        ;
    }

    @Test
    public void testPatch(){
        baseURI = "https://reqres.in/api";
        JSONObject request = new JSONObject();
        request.put( "name","morpheus");
        request.put( "job","zion resident");
        given()
                .header("Content-Type","application/json")
                .body(request.toJSONString())
                .when()
                .patch("/users/2")
                .then()
                .statusCode(200).log().all()
        ;
    }

    @Test
    public void testDelete(){
        baseURI = "https://reqres.in/api";

        given()
                .header("Content-Type","application/json")
                .when()
                .delete("/users/2")
                .then()
                .statusCode(204).log().all()
        ;
    }
}
