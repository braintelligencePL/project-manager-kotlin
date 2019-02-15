package pl.braintelligence.projectmanager.domain.values

enum class JobPosition {
    DEVELOPER,
    SCRUM_MASTER,
    PRODUCT_OWNER,
    INVALID;

    fun isInvalid(): Boolean {
        return this == INVALID
    }
}
