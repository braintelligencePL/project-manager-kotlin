package pl.braintelligence.projectmanager.base


import pl.braintelligence.projectmanager.infrastructure.adapter.incoming.rest.project.NewFeature
import pl.braintelligence.projectmanager.infrastructure.adapter.incoming.rest.project.ProjectDraft
import pl.braintelligence.projectmanager.infrastructure.adapter.incoming.rest.project.ProjectWithFeatures
import pl.braintelligence.projectmanager.infrastructure.adapter.incoming.rest.team.NewTeam
import pl.braintelligence.projectmanager.infrastructure.adapter.incoming.rest.team.TeamMember

trait BaseDtoObjects {

    // projects
    ProjectDraft newProjectDraftDto = new ProjectDraft("qwerty")

    NewFeature newFeature = new NewFeature("feature name 1", "TO_DO", "NOT_DEFINED")
    NewFeature updatedFeature = new NewFeature("feature name 2", "IN_PROGRESS", "HIGH")


    ProjectWithFeatures newProjectWithFeaturesDto = new ProjectWithFeatures("feature 1", List.of(newFeature))

    ProjectDraft newProjectDraft = new ProjectDraft("project name")

    // teams
    NewTeam newTeamDto = new NewTeam("123")
    NewTeam newTeamDto1 = new NewTeam("123456")

    TeamMember teamMemberDto = new TeamMember(
            "firstName",
            "LastName",
            "DEVELOPER"
    )

}
