package pl.braintelligence.projectmanager.integration.team.base

import pl.braintelligence.projectmanager.api.team.dto.TeamMemberDto

class SampleTeamMemberDto {

    static final Map TEAM_MEMBER_DTO = [
            "firstName"  : "Lukasz",
            "lastName"   : "Sroczynski",
            "jobPosition": "DEVELOPER"
    ]

    static final TeamMemberDto sampleTeamMemberDto(Map<String, Object> properties = [:]) {
        properties = TEAM_MEMBER_DTO + properties
        return new TeamMemberDto(
                properties.firstName,
                properties.lastName,
                properties.jobPosition
        )
    }
}
