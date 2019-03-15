package pl.braintelligence.projectmanager.api.project

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import pl.braintelligence.projectmanager.api.project.dto.ExistingProjectDraft
import pl.braintelligence.projectmanager.api.project.dto.NewProject
import pl.braintelligence.projectmanager.api.project.dto.NewProjectDraft
import pl.braintelligence.projectmanager.application.ProjectService

@RestController
@RequestMapping("/projects")
class ProjectEndpoint(
        private val projectService: ProjectService
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/drafts")
    fun createProject(@RequestBody newProjectDraft: NewProjectDraft) =
            projectService.createProject(newProjectDraft)

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun createProject(@RequestBody newProject: NewProject) =
            projectService.createProject(newProject)

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    fun getProjects(): List<ExistingProjectDraft> =
            projectService.getProjects()

}
