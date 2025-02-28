package tests.api.steps;

import io.qameta.allure.Step;
import tests.api.pojos.response.project.DeleteProjectResponse;

import static io.restassured.RestAssured.given;
import static tests.api.specs.Specs.REQ_SPEC;
import static tests.api.specs.Specs.RES_SPEC;

public class ProjectSteps {
    static String path = "/project";

    @Step("Delete project")
    public static DeleteProjectResponse deleteProject(String projectCode) {
        return given().spec(REQ_SPEC)
                .delete(path + "/" + projectCode)
                .then().spec(RES_SPEC)
                .extract().as(DeleteProjectResponse.class);
    }

}
