package tests;

import generators.ProjectGenerator;
import org.junit.jupiter.api.Test;
import api.pojos.request.project.CreateProjectRequest;
import api.pojos.response.project.CreateProjectResponse;
import api.pojos.response.project.Result;
import steps.ProjectSteps;

import static org.assertj.core.api.Assertions.assertThat;

public class ProjectApiTest {

    @Test
    void projectShouldBeCreated() {
        CreateProjectRequest createProjectRq = ProjectGenerator.createProjectApi();
        CreateProjectResponse createProjectRs = ProjectSteps.createProject(createProjectRq);
        assertThat(createProjectRs)
                .isNotNull()
                .extracting(CreateProjectResponse::getResult)
                .extracting(Result::getCode)
                .isEqualTo(createProjectRq.getCode());
    }
}

