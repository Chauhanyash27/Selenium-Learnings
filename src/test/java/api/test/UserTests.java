package api.test;

import api.endpoints.UserEndPoints;
import api.payload.User_POJO;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserTests {

    Faker faker;
    User_POJO userPayload;

    @BeforeClass
    public void dataSetup(){
        faker = new Faker();
        userPayload = new User_POJO();

        userPayload.setId(faker.idNumber().hashCode());
        userPayload.setUserName(faker.name().username());
        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setEmail(faker.internet().safeEmailAddress());
        userPayload.setPassword(faker.internet().password());
        userPayload.setPhone(faker.phoneNumber().cellPhone());
    }

    @Test(priority = 1)
    public void testPostUser(){
        Response postResponse = UserEndPoints.createUser(userPayload);
        postResponse.then().log().body();

        Assert.assertEquals(postResponse.getStatusCode(),200);
    }

    @Test(priority = 2)
    public void testGetUserByName(){
        Response getResponse = UserEndPoints.getUser(this.userPayload.getUserName());
        getResponse.then().log().body();

        Assert.assertEquals(getResponse.getStatusCode(),200);
    }

    @Test(priority = 3)
    public void testUpdateUserByName(){

        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());

        Response putResponse = UserEndPoints.updateUser(this.userPayload.getUserName(),userPayload);
        putResponse.then().log().body();

        Assert.assertEquals(putResponse.getStatusCode(),200);
    }

    @Test(priority = 4)
    public void testDeleteUserByName(){
        Response deleteResponse = UserEndPoints.deleteUser(this.userPayload.getUserName());
        deleteResponse.then().log().all();

        Assert.assertEquals(deleteResponse.getStatusCode(),404);

    }
}
