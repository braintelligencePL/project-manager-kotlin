package pl.braintelligence.projectmanager.projects.base


import pl.braintelligence.projectmanager.api.project.dto.NewProject

import static SampleNewFeature.sampleNewFeature

class SampleNewProject {

    static final Map NEW_PROJECT_DTO = [
            "name"    : "project 1",
            "features": [sampleNewFeature()]
    ]

    static final NewProject sampleNewProject(Map<String, Object> properties = [:]) {
        properties = NEW_PROJECT_DTO + properties
        return new NewProject(
                properties.name as String,
                properties.features
        )
    }
}
