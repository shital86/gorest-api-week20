package in.co.gorset.userinfo;

import in.co.gorset.Steps.UsersSteps;
import in.co.gorset.testbase.TestBase;
import in.co.gorset.utils.TestUtils;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

@RunWith(SerenityRunner.class)

public class GorestCURDTestWithSteps extends TestBase {
    static  String name ="Gorest_User_"+ TestUtils.getRandomValue();
    //tenali.ramakrishn@101.com
    static String email="tenali.ramakrishna@"+ TestUtils.getRandomValue()+".com";
    static String gender="Female";
    static String status="inactive";
    static int id;

    @Steps
    UsersSteps usersSteps;

    @Title("This will create a new user")
    @Test
    public void test001(){
    ValidatableResponse    response =usersSteps.createUser(name,gender,email,status);
        response.log().all().statusCode(201);
        id = response.log().all().extract().path("id");
    }

    @Title("Verify if the user was added to the application")
    @Test
    public void test002() {
        HashMap<String,Object> userMap =usersSteps.getSingleUserInfoMap(id);
        Assert.assertThat(userMap,hasValue(name));
    }
    @Title("Update the user information and verify the updated information")
    @Test
    public void test003(){
        name = name+"_Updated";
        ValidatableResponse response = usersSteps.updateUser(id,name,gender,email,status);
        response.log().all().statusCode(200);
        HashMap<String,Object> userMap =usersSteps.getSingleUserInfoMap(id);
        Assert.assertThat(userMap,hasValue(name));
        System.out.println(name);

    }
    @Title("Delete the user and verify if the user is deleted!")
    @Test
    public void test004() {

        usersSteps.deleteUser(id).statusCode(204);
        usersSteps.getUserInfoById(id).statusCode(404);

    }


}
