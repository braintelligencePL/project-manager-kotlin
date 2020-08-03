package pl.braintelligence.projectmanager.core.projects.domain.values

enum class Status {
    TO_DO,
    IN_PROGRESS,
    COMPLETED,
    INVALID;

    fun hasToDoStatus(): Boolean = this == TO_DO

}