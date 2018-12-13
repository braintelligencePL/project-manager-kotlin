package pl.braintelligence.projectmanager.integration.projects.base

import pl.braintelligence.projectmanager.api.project.dto.NewFeature

class SampleNewFeature {

    static final Map NEW_PROJECT_DTO = [
            "name": "feature title/name",
            "requirement": "OPTIONAL"
    ]

    static final NewFeature sampleNewFeature(Map<String, Object> properties = [:]) {
        properties = NEW_PROJECT_DTO + properties
        return new NewFeature(
                properties.name,
                properties.requirement
        )
    }
}
