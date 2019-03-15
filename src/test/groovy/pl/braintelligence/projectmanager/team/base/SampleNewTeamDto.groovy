package pl.braintelligence.projectmanager.team.base

import pl.braintelligence.projectmanager.api.team.dto.NewTeamDto


class SampleNewTeamDto {

    static final Map NEW_TEAM_DTO = ["name": "team1"]

    static final NewTeamDto sampleNewTeamDto(Map<String, Object> properties = [:]) {
        properties = NEW_TEAM_DTO + properties
        return new NewTeamDto(properties.name)
    }

}
