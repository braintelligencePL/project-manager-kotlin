package pl.braintelligence.projectmanager.integration.team.base

import pl.braintelligence.projectmanager.application.dto.NewTeam


class SampleNewTeamDto {

    static final Map NEW_TEAM_DTO = ["name": "team1"]

    static final NewTeam sampleNewTeamDto(Map<String, Object> properties = [:]) {
        properties = NEW_TEAM_DTO + properties
        return new NewTeam(properties.name)
    }

}
