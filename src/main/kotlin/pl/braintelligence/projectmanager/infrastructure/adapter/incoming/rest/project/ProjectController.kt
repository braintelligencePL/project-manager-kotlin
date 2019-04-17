package pl.braintelligence.projectmanager.infrastructure.adapter.incoming.rest.project

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import pl.braintelligence.projectmanager.core.projects.domain.Project
import pl.braintelligence.projectmanager.core.projects.ports.incoming.ProjectCreatorPort
import pl.braintelligence.projectmanager.core.projects.ports.incoming.ProjectModifierPort
import pl.braintelligence.projectmanager.core.projects.ports.incoming.ProjectQueryPort

/**
 * Primary Adapter
 */

@RestController
@RequestMapping("/projects")
internal class ProjectController(
        @Qualifier("projectCreatorService") private val projectCreatorPort: ProjectCreatorPort,
        @Qualifier("projectQueryService") private val projectQueryPort: ProjectQueryPort,
        @Qualifier("projectModifierService") private val projectModifierPort: ProjectModifierPort
) {

    @PostMapping("drafts")
    @ResponseStatus(HttpStatus.CREATED)
    fun createProjectDraft(
            @RequestBody projectDraft: ProjectDraft
    ): Project = projectCreatorPort.createProjectDraft(projectDraft)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createProjectWithFeatures(
            @RequestBody projectWithFeatures: ProjectWithFeatures
    ): Project = projectCreatorPort.createProjectWithFeatures(projectWithFeatures)

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun getProject(
            @PathVariable id: String
    ): Project = projectQueryPort.getProject(id)

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getProjects(): List<Project> = projectQueryPort.getProjects()

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun updateProject(
            @PathVariable id: String,
            @RequestBody updateProject: UpdateProject
    ) = projectModifierPort.updateProject(id, updateProject)

}
