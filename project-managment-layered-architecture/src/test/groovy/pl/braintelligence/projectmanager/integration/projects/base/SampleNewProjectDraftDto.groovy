package pl.braintelligence.projectmanager.integration.projects.base

import pl.braintelligence.projectmanager.application.dto.NewTeam

class SampleNewProjectDraftDto {

    static final Map NEW_PROJECT_DRAFT_DTO = ["name": "project 1"]

    static final NewTeam sampleNewProjectDraftDto(Map<String, Object> properties = [:]) {
        properties = NEW_PROJECT_DRAFT_DTO + properties
        return new NewTeam(properties.name)
    }
}
