package pl.braintelligence.projectmanager.adapter

data class NewTeam (val name: String)

data class TeamMember @JvmOverloads constructor(val firstName: String, val lastName: String, val jobPosition: String)
