package pl.braintelligence.projectmanager.domain.values

data class Employee(
        val firstName: String,
        val lastName: String,
        val jobPosition: JobPosition
)

enum class JobPosition{
    DEVELOPER,
    SCRUM_MASTER,
    PRODUCT_OWNER,
    INVALID;
}