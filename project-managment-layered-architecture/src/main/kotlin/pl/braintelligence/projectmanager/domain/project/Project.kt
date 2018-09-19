package pl.braintelligence.projectmanager.domain.project

import org.apache.commons.lang3.StringUtils.isBlank
import pl.braintelligence.projectmanager.domain.exceptions.InvalidEntityException
import pl.braintelligence.projectmanager.domain.exceptions.ErrorCode.*
import pl.braintelligence.projectmanager.domain.values.Employee

data class Project(
    val name: String
) {

}