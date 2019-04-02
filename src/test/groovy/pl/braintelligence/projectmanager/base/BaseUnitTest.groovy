package pl.braintelligence.projectmanager.base

import pl.braintelligence.projectmanager.core.projects.domain.Feature
import pl.braintelligence.projectmanager.core.projects.domain.PriorityLevel
import pl.braintelligence.projectmanager.core.projects.domain.Status
import pl.braintelligence.projectmanager.infrastructure.adapter.incoming.rest.dto.NewTeam
import pl.braintelligence.projectmanager.infrastructure.adapter.incoming.rest.dto.ProjectDraft
import pl.braintelligence.projectmanager.infrastructure.adapter.incoming.rest.dto.ProjectWithFeatures
import pl.braintelligence.projectmanager.infrastructure.adapter.incoming.rest.dto.TeamMember
import spock.lang.Specification

class BaseUnitTest extends Specification {

    def newTeamDto = new NewTeam("123")

    def newProjectDraftDto = new ProjectDraft("qwerty")

    def feature1 = new Feature("feature name 1", Status.TO_DO, PriorityLevel.NOT_DEFINED)

    def projectWithFeaturesDto = new ProjectWithFeatures("feature 1", List.of(feature1))

    def teamMemberDto = new TeamMember(
            "firstName",
            "LastName",
            "DEVELOPER"
    )
}
