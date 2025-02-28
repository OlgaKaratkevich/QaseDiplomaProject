package steps;

import io.qameta.allure.Step;
import tests.api.pojos.response.project.CreateProjectResponse;
import tests.api.pojos.request.project.CreateProjectRequest;
import tests.api.pojos.response.project.DeleteProjectResponse;

import static tests.api.specs.Specs.REQ_SPEC;
import static tests.api.specs.Specs.RES_SPEC;
import static io.restassured.RestAssured.given;

public class ProjectSteps {
    static String path = "/project";

    public static CreateProjectResponse createProject (CreateProjectRequest projectRq){
        return given()
                .spec(REQ_SPEC)
                .body(projectRq)
                .post("/project")
                .then().spec(RES_SPEC)
                .extract().as(CreateProjectResponse.class);
    }

    @Step("Delete project")
    public static DeleteProjectResponse deleteProject(String projectCode) {
        return given().spec(REQ_SPEC)
                .delete(path + "/" + projectCode)
                .then().spec(RES_SPEC)
                .extract().as(DeleteProjectResponse.class);
    }
}