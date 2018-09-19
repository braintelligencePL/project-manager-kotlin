package pl.braintelligence.projectmanager.domain.project

import org.springframework.data.annotation.Id
import pl.braintelligence.projectmanager.domain.values.Status

data class Project(
    @Id val id: String,
    val name: String,
    val status: Status,
    val assignedTeam: String
) {
    init {
        validateIdentifier()
        validateName()
    }

    private fun validateName() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun validateIdentifier() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}