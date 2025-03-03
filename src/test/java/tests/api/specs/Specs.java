package tests.api.specs;

import config.ConfigReader;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;
import static io.restassured.http.ContentType.JSON;
import static org.apache.http.HttpStatus.SC_OK;

public class Specs {
    public static final RequestSpecification REQ_SPEC = with()
            .baseUri(ConfigReader.apiConfig.baseUri())
            .basePath(ConfigReader.apiConfig.basePath())
            .log().uri()
            .contentType(JSON)
            .header("Token", ConfigReader.apiConfig.token());

    public static final ResponseSpecification RES_SPEC = new ResponseSpecBuilder()
            .log(LogDetail.ALL)
            .expectStatusCode(SC_OK)
            .build();

}