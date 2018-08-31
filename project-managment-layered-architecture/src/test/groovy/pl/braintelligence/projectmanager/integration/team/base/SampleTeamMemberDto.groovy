package pl.braintelligence.projectmanager.integration.team.base

import pl.braintelligence.projectmanager.application.dto.NewTeamDto
import pl.braintelligence.projectmanager.application.dto.TeamMemberDto


class SampleTeamMemberDto {

    static final Map TEAM_MEMBER_DTO = [
            "firstName": "Lukasz",
            "lastName": "Sroczynski",
            "jobPosition": "DEVELOPER"
    ]

    static final NewTeamDto sampleTeamMemberDto(Map<String, Object> properties = [:]) {
        properties = TEAM_MEMBER_DTO  + properties
        return new TeamMemberDto(
                properties.firstName,
                properties.lastName,
                properties.jobPosition.toString()
        )
    }
}
