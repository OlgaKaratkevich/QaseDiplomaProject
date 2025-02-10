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
            .baseUri("https://app.qase.io")
            .basePath("/v1")
            .log().uri()
            .contentType(JSON)
            .header("Token","a5af53344aef7a2ed241190e582de98ab5028825db09b4f0a9d29c4f2ced66d7");

    public static final ResponseSpecification RES_SPEC = new ResponseSpecBuilder()
            .log(LogDetail.ALL)
            .expectStatusCode(SC_OK)
            .build();

}