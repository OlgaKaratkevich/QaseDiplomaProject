package steps;

import api.pojos.response.project.CreateProjectResponse;
import api.pojos.request.project.CreateProjectRequest;

import static api.specs.Specs.REQ_SPEC;
import static api.specs.Specs.RES_SPEC;
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