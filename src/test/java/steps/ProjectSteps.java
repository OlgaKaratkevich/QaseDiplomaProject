package steps;

import tests.api.pojos.response.project.CreateProjectResponse;
import tests.api.pojos.request.project.CreateProjectRequest;

import static tests.api.specs.Specs.REQ_SPEC;
import static tests.api.specs.Specs.RES_SPEC;
import static io.restassured.RestAssured.given;

public class ProjectSteps {
    public static CreateProjectResponse createProject (CreateProjectRequest projectRq){
        return given()
                .spec(REQ_SPEC)
                .body(projectRq)
                .post("/project")
                .then().spec(RES_SPEC)
                .extract().as(CreateProjectResponse.class);
    }
}