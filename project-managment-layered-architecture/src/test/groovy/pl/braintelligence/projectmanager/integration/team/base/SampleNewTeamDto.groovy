package pl.braintelligence.projectmanager.integration.team.base

import pl.braintelligence.projectmanager.application.dto.NewTeamDto


class SampleNewTeamDto {

    static final Map NEW_TEAM_DTO = ["name": "team1"]

    static final NewTeamDto sampleNewTeamDto(Map<String, Object> properties = [:]) {
        properties = NEW_TEAM_DTO + properties
        return new NewTeamDto(properties.name)
    }

}
