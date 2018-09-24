package pl.braintelligence.projectmanager.domain.project;

import static java.util.Collections.unmodifiableList;
import static org.apache.commons.collections4.ListUtils.emptyIfNull;
import static org.apache.commons.lang3.StringUtils.isBlank;

import org.springframework.data.annotation.Id;

import java.util.List;

import pl.braintelligence.projectmanager.domain.exceptions.InvalidEntityException;
import pl.braintelligence.projectmanager.domain.values.Feature;
import pl.braintelligence.projectmanager.domain.values.Status;
import pl.braintelligence.projectmanager.domain.exceptions.ErrorCode;

public class Project {

    @Id
    private String id;
    private String name;
    private Status status;
    private String assignedTeam;
    private List<Feature> features;

    Project(String identifier, String name) {
        this(identifier, name, null);
    }

    Project(String id, String name, List<Feature> features) {
        validateIdentifier(id);
        validateName(name);
        features = normalize(features);
        validateFeatures(features);
        this.id = id;
        this.name = name;
        this.status = Status.TO_DO;
        this.features = features;
    }

    private void validateIdentifier(String id) {
        if (isBlank(id))
            throw new InvalidEntityException(ErrorCode.EMPTY_PROJECT_ID);
    }

    private void validateName(String name) {
        if (isBlank(name))
            throw new InvalidEntityException(ErrorCode.EMPTY_PROJECT_NAME);
    }

    private List<Feature> normalize(List<Feature> features) {
        return unmodifiableList(emptyIfNull(features));
    }

    private void validateFeatures(List<Feature> features) {
        features.forEach(this::validateFeature);
    }

    private void validateFeature(Feature feature) {
        if (feature.isUnnamed())
            throw new InvalidEntityException(ErrorCode.EMPTY_FEATURE);
        if (feature.hasNoStatus())
            throw new InvalidEntityException(ErrorCode.EMPTY_FEATURE_STATUS);
        if (feature.hasNoRequirement())
            throw new InvalidEntityException(ErrorCode.EMPTY_FEATURE_REQUIREMENT);
    }

    private Project() {}
}
