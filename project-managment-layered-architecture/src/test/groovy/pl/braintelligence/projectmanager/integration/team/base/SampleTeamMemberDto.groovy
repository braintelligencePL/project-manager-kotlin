package pl.braintelligence.projectmanager.integration.team.base

import pl.braintelligence.projectmanager.application.dto.TeamMember

class SampleTeamMemberDto {

    static final Map TEAM_MEMBER_DTO = [
            "firstName"  : "Lukasz",
            "lastName"   : "Sroczynski",
            "jobPosition": "DEVELOPER"
    ]

    static final TeamMember sampleTeamMemberDto(Map<String, Object> properties = [:]) {
        properties = TEAM_MEMBER_DTO + properties
        return new TeamMember(
                properties.firstName,
                properties.lastName,
                properties.jobPosition.toString()
        )
    }
}
