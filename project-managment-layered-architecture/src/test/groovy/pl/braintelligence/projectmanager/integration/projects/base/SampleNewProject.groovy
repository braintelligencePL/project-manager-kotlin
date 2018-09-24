package pl.braintelligence.projectmanager.integration.projects.base

import pl.braintelligence.projectmanager.application.dto.NewProjectDto

import static pl.braintelligence.projectmanager.integration.projects.base.SampleNewFeature.sampleNewFeature

class SampleNewProject {

    static final Map NEW_PROJECT_DTO = [
            "name"    : "project 1",
            "features": [sampleNewFeature()]
    ]

    static final NewProjectDto sampleNewProject(Map<String, Object> properties = [:]) {
        properties = NEW_PROJECT_DTO + properties
        return new NewProjectDto(
                properties.name,
                properties.features
        )
    }
}
