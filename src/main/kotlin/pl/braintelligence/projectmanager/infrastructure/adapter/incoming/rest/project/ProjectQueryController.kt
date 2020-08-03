package pl.braintelligence.projectmanager.infrastructure.adapter.incoming.rest.project

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import pl.braintelligence.projectmanager.core.projects.domain.Project
import pl.braintelligence.projectmanager.core.projects.ports.incoming.ProjectQueryPort

/**
 * Primary Adapter
 */

@RestController
@RequestMapping("/projects")
internal class ProjectQueryController(
        @Qualifier("projectQueryService") private val projectQueryPort: ProjectQueryPort
) {

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun getProject(
            @PathVariable id: String
    ): Project = projectQueryPort.getProject(id)

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getProjects(): List<Project> = projectQueryPort.getProjects()

}
