package pl.braintelligence.projectmanager.api

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import pl.braintelligence.projectmanager.application.ProjectService
import pl.braintelligence.projectmanager.application.dto.NewProject
import pl.braintelligence.projectmanager.application.dto.NewProjectDraft

@RestController
@RequestMapping("/projects")
class ProjectEndpoint(
    private val projectService: ProjectService
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/drafts")
    fun createProject(@RequestBody newProjectDraft: NewProjectDraft) {
        projectService.createProject(newProjectDraft)
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun createProject(@RequestBody newProject: NewProject) {
        projectService.createProject(newProject)
    }
}