import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.Filter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

public class BaseTest {

    private static final Logger logger = LogManager.getLogger(RequestTest.class);
    @Before
    public void setup(){
        logger.info("Iniciando la configuracion");
        RestAssured.requestSpecification =  defaultRequestSpecification();


        logger.info("Configuracion Exitosa");

    }
     RequestSpecification defaultRequestSpecification(){

        List<Filter> filters = new ArrayList<>();
        filters.add(new RequestLoggingFilter());
        filters.add(new ResponseLoggingFilter());


        return new RequestSpecBuilder().setBaseUri("https://jsonplaceholder.typicode.com")
                .setBasePath("/posts")
                .addFilters(filters)
                .setContentType(ContentType.JSON).build();
    }


}
