package pl.braintelligence.projectmanager.integration.projects.base

import pl.braintelligence.projectmanager.application.dto.NewTeamDto


class SampleNewProjectDraftDto {

    static final Map NEW_PROJECT_DRAFT_DTO = ["name": "team1"]

    static final NewTeamDto sampleNewProjectDraftDto(Map<String, Object> properties = [:]) {
        properties = NEW_PROJECT_DRAFT_DTO + properties
        return new NewTeamDto(properties.name)
    }

}
