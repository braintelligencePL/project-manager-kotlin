package pl.braintelligence.projectmanager.project


import org.springframework.http.HttpStatus
import pl.braintelligence.projectmanager.base.BaseIntegrationTest
import pl.braintelligence.projectmanager.core.projects.domain.Project

class ProjectAcceptanceTest extends BaseIntegrationTest {

    def "Should create project draft"() {
        given: "create new project draft"
        def response = post("/projects/drafts", newProjectDraft)
        response.statusCode == HttpStatus.CREATED

        when: "browse for this project draft"
        response = get("/projects/${response.body.id}", Project.class)

        then:
        response.statusCode == HttpStatus.OK

        when: "create new project with features"
        response = post("/projects", newProjectWithFeaturesDto)

        then:
        response.statusCode == HttpStatus.CREATED

//        when: "browse for all projects"
//        response = get("/projects", new ParameterizedTypeReference<List<Project>>() {})

//        then:
//        response.statusCode == HttpStatus.OK

    }
}

