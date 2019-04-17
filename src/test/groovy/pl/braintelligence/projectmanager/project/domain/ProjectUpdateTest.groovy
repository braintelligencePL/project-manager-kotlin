package pl.braintelligence.projectmanager.project.domain

import pl.braintelligence.projectmanager.core.team.domain.configuration.TeamConfiguration
import pl.braintelligence.projectmanager.core.team.ports.incoming.TeamManager
import pl.braintelligence.projectmanager.infrastructure.adapter.incoming.rest.project.NewFeature
import pl.braintelligence.projectmanager.infrastructure.adapter.incoming.rest.project.UpdateProject
import pl.braintelligence.projectmanager.project.base.BaseProjectUnitTest

class ProjectUpdateTest extends BaseProjectUnitTest {

    protected TeamManager teamService = new TeamConfiguration().teamManager()

    def "Should update project"() {
        given: "Team and project is created (project has no team assign as default)"
        def project = projectCreator.createProjectWithFeatures(newProjectWithFeaturesDto)
        def team = teamService.createTeam(newTeamDto)

        and: "extracted project id"
        def projectId = project.id

        and: "update project with..."
        def updatedProjectName = "new project name"
        def assignTeam = team.name
        def updatedProjectFeatures = List.of(new NewFeature("new feature name", "IN_PROGRESS", "MEDIUM"))

        def updateProject = new UpdateProject(updatedProjectName, assignTeam, updatedProjectFeatures)

        when: "project is updated"
        projectModifier.updateProject(projectId, updateProject)

        and: "retrieve updated project"
        def updatedProject = projectQuery.getProject(projectId)

        then: "verify that updates for project were applied"
        with(updatedProject) {
            name == updatedProjectName
            teamAssigned == assignTeam
            with(features[0]) {
                name == updatedProjectFeatures.first().name
                status.toString() == updatedProjectFeatures.first().status
                priorityLevel.toString() == updatedProjectFeatures.first().priorityLevel
            }
        }
    }
}
