package api;


import generators.ProjectGenerator;
import org.junit.jupiter.api.Test;
import api.pojos.request.project.CreateProjectRequest;
import api.pojos.response.project.CreateProjectResponse;
import api.pojos.response.project.Result;
import api.steps.ProjectSteps;

import static org.hamcrest.MatcherAssert.assertThat;

public class ProjectApiTest {

    @Test
    void projectShouldBeCreated(){
        CreateProjectRequest createProjectRq = ProjectGenerator.createProjectApi();
        CreateProjectResponse createProjectRs = ProjectSteps.createProject(createProjectRq);

        assertThat(createProjectRs)
                .isNotNull()
                .extracting(CreateProjectResponse::getResult)
                .extracting(Result::getCode)
                .isEqualTo(createProjectRq.getCode());
    }
}
