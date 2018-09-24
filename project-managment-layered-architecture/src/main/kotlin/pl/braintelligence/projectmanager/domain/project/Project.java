package pl.braintelligence.projectmanager.domain.project;

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
        this.id = id;
        this.name = name;
        this.status = Status.TO_DO;
        this.features = features;
    }

    private void validateIdentifier(String id) {
        if (isBlank(id)) {
            throw new InvalidEntityException(ErrorCode.EMPTY_PROJECT_ID);
        }
    }

    private void validateName(String name) {
        if()
    }

    private Project() {

    }
}
