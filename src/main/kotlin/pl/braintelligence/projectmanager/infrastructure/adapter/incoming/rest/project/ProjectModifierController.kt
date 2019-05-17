package pl.braintelligence.projectmanager.infrastructure.adapter.incoming.rest.project

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import pl.braintelligence.projectmanager.core.projects.ports.incoming.ProjectModifierPort
import pl.braintelligence.projectmanager.infrastructure.adapter.incoming.rest.project.dto.UpdateProject

/**
 * Primary Adapter
 */

@RestController
@RequestMapping("/projects")
internal class ProjectModifierController(
        @Qualifier("projectModifierService") private val projectModifierPort: ProjectModifierPort
) {

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun updateProject(
            @PathVariable id: String,
            @RequestBody updateProject: UpdateProject
    ) = projectModifierPort.updateProject(id, updateProject)

}
