package pl.braintelligence.projectmanager.domain.values

enum class Requirement {
    OPTIONAL,
    NECESSARY,
    INVALID;

    fun isInvalid(): Boolean {
        return this == Requirement.INVALID
    }
}
