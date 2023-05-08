import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RequestTest extends BaseTest {


    @Test
    public void getGettingResourceTest(){
        given()
                .contentType(ContentType.JSON)
                .get("1")
                .then()
                //Aserciones
                .statusCode(HttpStatus.SC_OK)
                .body("id", equalTo(1));
    }

    @Test
    public void deletingResourceTest(){
        given()
                .delete("1")
                .then()
                ////Aserciones
                .statusCode(HttpStatus.SC_OK);
    }

}
