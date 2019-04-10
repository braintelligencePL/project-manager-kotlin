package pl.braintelligence.projectmanager.base

import pl.braintelligence.projectmanager.core.projects.domain.Feature
import pl.braintelligence.projectmanager.core.projects.domain.PriorityLevel
import pl.braintelligence.projectmanager.core.projects.domain.Status
import pl.braintelligence.projectmanager.infrastructure.adapter.incoming.rest.dto.NewTeam
import pl.braintelligence.projectmanager.infrastructure.adapter.incoming.rest.dto.ProjectDraft
import pl.braintelligence.projectmanager.infrastructure.adapter.incoming.rest.dto.ProjectWithFeatures
import pl.braintelligence.projectmanager.infrastructure.adapter.incoming.rest.dto.TeamMember

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
