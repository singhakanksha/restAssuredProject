package tests;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class TestOnLocalAPI {
//    @Test
    public void get(){
        baseURI = "http://localhost:3000";
        given()
                .get("/users")
                .then()
                .statusCode(200).log().all();
    }
//    @Test
    public void post(){
        JSONObject request = new JSONObject();
        request.put("firstame","anadi");
        request.put("lastName","lawande");
        request.put("subjectId",1);
        baseURI = "http://localhost:3000";
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .post("/users")
                .then()
                .statusCode(201);
    }
//    @Test
    public void put(){
        JSONObject request = new JSONObject();
        request.put("firstame","albert");
        request.put("lastName","dhole");
        request.put("subjectId",2);
        baseURI = "http://localhost:3000";
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .put("/users/4")
                .then()
                .statusCode(200);
    }
//    @Test
    public void patch(){
        JSONObject request = new JSONObject();
        request.put("firstame","albert");
        request.put("lastName","einstien");
        request.put("subjectId",2);
        baseURI = "http://localhost:3000";
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .patch("/users/4")
                .then()
                .statusCode(200);
    }
    @Test
    public void delete(){
        baseURI = "http://localhost:3000";
                when()
                .delete("/users/4")
                .then()
                .statusCode(200);
    }
}
