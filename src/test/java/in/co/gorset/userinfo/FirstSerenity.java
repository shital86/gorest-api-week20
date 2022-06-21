package in.co.gorset.userinfo;

import in.co.gorset.constants.EndPoints;
import in.co.gorset.utils.TestUtils;
import net.serenitybdd.rest.SerenityRest;
import org.junit.Test;

public class FirstSerenity extends TestUtils {
    //
    @Test
    public void getAllStudents(){
        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization","c4f34459347dc40079323c89fd1db2e9987ad300d49946749a28c89b1bf318ba")
                .when()
                .get(EndPoints.GET_USERS)
                .then()
                .log().all()
                .statusCode(200);
    }
}
