package pl.braintelligence.projectmanager.projects.base

import org.springframework.http.ResponseEntity
import pl.braintelligence.projectmanager.base.BaseHttpMethods

trait OperatingOnProjectsEndpoint implements BaseHttpMethods {

    ResponseEntity createProjectDraft(Object requestBody) {
        return post('/projects/drafts', requestBody)
    }

    ResponseEntity createFullProject(Object requestBody) {
        return post('/projects', requestBody)
    }
}