package pl.braintelligence.projectmanager.core.team.domain

enum class JobPosition {
    SCRUM_MASTER,
    DEVELOPER,
    PRODUCT_OWNER,
    INVALID;

    fun isValid(): Boolean {
        return this != INVALID
    }
}
