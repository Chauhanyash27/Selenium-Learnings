import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import io.restassured.matcher.RestAssuredMatchers;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Practice {

    int id;

//    @Test
    public void getAllUsers(){

        given()
                .when()
                   .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .body("page",equalTo(2))
                .log().all();
    }

//    @Test(priority = 1)
    public void createUser(){
        HashMap data = new HashMap();
        data.put("name","Yash");
        data.put("job","QA");

       id=given()
                .contentType("application/json")
                .body(data)

                .when()
                .post("https://reqres.in/api/users")
                .jsonPath().getInt("id");

//                .then()
//                .statusCode(201)
//                .log().all();
    }

//    @Test(priority =2, dependsOnMethods = "createUser")
    public void updateUser(){
        HashMap data = new HashMap();
        data.put("name","Yash Chauhan");
        data.put("job","Tester");

        given()
                .contentType("application/json")
                .body(data)

                .when()
                .put("https://reqres.in/api/users/"+id)

                .then()
                .statusCode(200)
                .log().all();
    }

//    @Test
    public void createUserJsonExternalFile() throws FileNotFoundException {

        File file = new File(".//sitemap (2).xml");
        FileReader fileReader = new FileReader(file);
        JSONTokener jt = new JSONTokener(fileReader);

        JSONObject data = new JSONObject(jt);

        given()
                .contentType("application/json")
                .body(data.toString())

                .when()
                .post("https://reqres.in/api/users")

                .then()
                .statusCode(201)
                .log().all();
    }

//    @Test
    void  basicAuthentication(){
        given()
                .auth().digest("postman","password")

                .when()
                .get("https://postman-echo.com/basic-auth")

                .then()
                .statusCode(200)
                .log().body();
    }

    void oauthAuthentication(){
        given()
                .auth().oauth2("")

                .when()
                .get("https://postman-echo.com/basic-auth")

                .then()
                .statusCode(200)
                .log().body();
    }

    void fakeDataGeneration(){
        Faker faker  = new Faker();
        String firstName = faker.name().firstName();
        faker.phoneNumber().cellPhone();

    }
}
