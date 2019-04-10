package pl.braintelligence.projectmanager.infrastructure.adapter.incoming.rest

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import pl.braintelligence.projectmanager.core.projects.domain.Project
import pl.braintelligence.projectmanager.core.projects.ports.incoming.ProjectCreatorPort
import pl.braintelligence.projectmanager.core.projects.ports.incoming.ProjectQueryPort
import pl.braintelligence.projectmanager.infrastructure.adapter.incoming.rest.dto.ProjectDraft
import pl.braintelligence.projectmanager.infrastructure.adapter.incoming.rest.dto.ProjectWithFeatures

/**
 * Primary Adapter
 */

@RestController
@RequestMapping("/projects")
internal class ProjectController(
        @Qualifier("projectCreatorService") private val projectCreatorPort: ProjectCreatorPort,
        @Qualifier("projectQueryService") private val projectQueryPort: ProjectQueryPort
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
    fun getProjects(): List<Project> = TODO()


}
