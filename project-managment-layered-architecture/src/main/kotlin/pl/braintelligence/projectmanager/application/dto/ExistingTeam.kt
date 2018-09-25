package pl.braintelligence.projectmanager.application.dto

import pl.braintelligence.projectmanager.domain.team.Team

data class ExistingTeam(
    val name: String,
    val currentlyImplementedProjects: Int,
    val busy: Boolean,
    val members: List<TeamMemberDto>
) {
    companion object {
        fun mapToExistingTeams(teams: List<Team>): List<ExistingTeam> =
            teams.map {
                ExistingTeam(
                    it.name,
                    it.currentProjects,
                    it.isBusy(),
                    TeamMemberDto.toTeamMembers(it.members)
                )
            }
    }

}
