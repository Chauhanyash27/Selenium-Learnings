package api.test;

import api.endpoints.UserEndPoints;
import api.payload.User_POJO;
import api.utilities.DataProviders;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DataDrivenTests {

    @Test(priority=1,dataProvider = "AllDataProvider",dataProviderClass = DataProviders.class)
    public void testPostUser(String[] data){
        User_POJO userPayload = new User_POJO();
        userPayload.setId(Integer.parseInt(data[0]));
        userPayload.setUserName(data[1]);
        userPayload.setFirstName(data[2]);
        userPayload.setLastName(data[3]);
        userPayload.setEmail(data[4]);
        userPayload.setPassword(data[5]);
        userPayload.setPhone(data[6]);

        Response postResponse = UserEndPoints.createUser(userPayload);
        Assert.assertEquals(postResponse.getStatusCode(),200);
    }

    @Test(priority = 2,dataProvider = "UsernameDataProvider",dataProviderClass = DataProviders.class)
    public void testGetUserByName(String userName){
        Response getResponse = UserEndPoints.getUser(userName);
        getResponse.then().log().all();

        Assert.assertEquals(getResponse.getStatusCode(),200);
    }

//    @Test(priority = 3,dataProvider = "UsernameDataProvider",dataProviderClass = DataProviders.class)
    public void testDeleteUserByName(String userName){
        Response deleteResponse = UserEndPoints.deleteUser(userName);

        Assert.assertEquals(deleteResponse.getStatusCode(),404);

    }
}
