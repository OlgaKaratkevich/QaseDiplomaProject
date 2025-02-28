package tests.api.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;
import static io.restassured.http.ContentType.JSON;
import static org.apache.http.HttpStatus.SC_OK;

public class Specs {
    public static final RequestSpecification REQ_SPEC = with()
            .baseUri("https://api.qase.io")
            .basePath("/v1")
            .log().uri()
            .contentType(JSON)
            .header("Token","f7b98ac70175c7696994278ef2d6557dd096398035499f5c01d84418cce6b8a2");

    public static final ResponseSpecification RES_SPEC = new ResponseSpecBuilder()
            .log(LogDetail.ALL)
            .expectStatusCode(SC_OK)
            .build();

}