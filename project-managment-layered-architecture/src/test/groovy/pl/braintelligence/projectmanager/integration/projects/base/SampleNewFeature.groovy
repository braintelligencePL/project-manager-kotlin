package pl.braintelligence.projectmanager.integration.projects.base

import pl.braintelligence.projectmanager.application.dto.NewFeatureDto

class SampleNewFeature {

    static final Map NEW_PROJECT_DTO = [
            "name": "feature title/name",
            "requirement": "OPTIONAL"
    ]

    static final NewFeatureDto sampleNewFeature(Map<String, Object> properties = [:]) {
        properties = NEW_PROJECT_DTO + properties
        return new NewFeatureDto(
                properties.name,
                properties.requirement
        )
    }
}
