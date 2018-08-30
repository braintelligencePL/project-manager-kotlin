package pl.braintelligence.projectmanager.integration.team.base

import pl.braintelligence.projectmanager.application.team.dto.NewTeamDto


class SampleTeamMemberDto {

    static final Map TEAM_MEMBER_DTO = [
            "firstName": "Lukasz",
            "lastName": "Sroczynski",
            "jobPosition": "DEVELOPER"
    ]

    static final NewTeamDto sampleTeamMemberDto(Map<String, Object> properties = [:]) {
        properties = TEAM_MEMBER_DTO  + properties
        return new NewTeamDto(
                properties.firstName,
                properties.lastName,
                properties.jobPosition
        )
    }

}
