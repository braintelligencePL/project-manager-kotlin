package pl.braintelligence.projectmanager.base

import pl.braintelligence.projectmanager.core.projects.domain.values.Feature
import pl.braintelligence.projectmanager.core.projects.domain.values.PriorityLevel
import pl.braintelligence.projectmanager.core.projects.domain.values.Status
import pl.braintelligence.projectmanager.infrastructure.adapter.incoming.rest.team.NewTeam
import pl.braintelligence.projectmanager.infrastructure.adapter.incoming.rest.project.ProjectDraft
import pl.braintelligence.projectmanager.infrastructure.adapter.incoming.rest.project.ProjectWithFeatures
import pl.braintelligence.projectmanager.infrastructure.adapter.incoming.rest.team.TeamMember

trait BaseDtoObjects {

    // projects
    ProjectDraft newProjectDraftDto = new ProjectDraft("qwerty")

    Feature feature = new Feature("feature name 1", Status.TO_DO, PriorityLevel.NOT_DEFINED)

    ProjectWithFeatures newProjectWithFeaturesDto = new ProjectWithFeatures("feature 1", List.of(feature))

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
