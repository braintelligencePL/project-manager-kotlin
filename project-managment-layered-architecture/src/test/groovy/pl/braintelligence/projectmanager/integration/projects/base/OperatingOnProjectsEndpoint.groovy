package pl.braintelligence.projectmanager.integration.projects.base

import org.springframework.http.ResponseEntity
import pl.braintelligence.projectmanager.integration.base.BaseHttpMethodsSpec

trait OperatingOnProjectsEndpoint implements BaseHttpMethodsSpec {

    ResponseEntity createProjectDraft(Object requestBody) {
        return post('/projects/drafts', requestBody)
    }
}