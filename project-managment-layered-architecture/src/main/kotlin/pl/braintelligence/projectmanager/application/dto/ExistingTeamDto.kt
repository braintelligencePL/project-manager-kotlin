package pl.braintelligence.projectmanager.application.dto

import pl.braintelligence.projectmanager.domain.team.Team

data class ExistingTeamDto(
    val name: String,
    val currentlyImplementedProjects: Int,
    val busy: Boolean,
    val members: List<TeamMemberDto>
) {
    companion object {
        fun mapToExistingTeams(teams: List<Team>): List<ExistingTeamDto> =
            teams.map {
                ExistingTeamDto(
                    it.name,
                    it.currentProjects,
                    it.isBusy(),
                    TeamMemberDto.toTeamMembers(it.members)
                )
            }
    }

}
