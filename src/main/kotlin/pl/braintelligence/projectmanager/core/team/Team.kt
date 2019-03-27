package pl.braintelligence.projectmanager.core.team

class Team @JvmOverloads constructor(
        val name: String,
        val currentlyImplementedProjects: Int = 0,
        val members: List<Employee> = listOf()
) {
    init {
        require(name.isNotBlank()) { throw IllegalArgumentException("Empty team name.") }
    }
}
