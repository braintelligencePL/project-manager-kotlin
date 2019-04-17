package pl.braintelligence.projectmanager.core.projects.domain.services

import org.springframework.stereotype.Service
import pl.braintelligence.projectmanager.core.projects.domain.values.Feature
import pl.braintelligence.projectmanager.core.projects.ports.incoming.ProjectModifierPort
import pl.braintelligence.projectmanager.core.projects.ports.outgoing.ProjectCreatorRepository
import pl.braintelligence.projectmanager.core.team.ports.incoming.TeamManager
import pl.braintelligence.projectmanager.infrastructure.adapter.incoming.rest.project.ProjectEndCondition
import pl.braintelligence.projectmanager.infrastructure.adapter.incoming.rest.project.UpdateProject

@Service
class ProjectModifierService(
        private val projectQueryService: ProjectQueryService,
        private val projectCreatorRepository: ProjectCreatorRepository,
        private val teamManager: TeamManager
) : ProjectModifierPort {

    override fun updateProject(projectId: String, updateProject: UpdateProject) {
        val project = projectQueryService.getProject(projectId)
        val featuresToUpdate = Feature.toFeatures(updateProject.features)

        project.changeProjectName(updateProject.name)
        project.changeProjectFeatures(featuresToUpdate)
        project.assignTeam(updateProject.teamName)

        val team = teamManager.getTeam(updateProject.teamName)
        team.incrementOngoingTeamProjects()
        teamManager.updateTeam(team)

        projectCreatorRepository.save(project)
    }

    override fun startProject(projectId: String) {
        TODO("not implemented")
    }

    override fun endProject(projectId: String, projectEndCondition: ProjectEndCondition) {
        TODO("not implemented")
    }

}
