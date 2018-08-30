package pl.braintelligence.projectmanager.application.team.dto

import pl.braintelligence.projectmanager.domain.team.Team
import pl.braintelligence.projectmanager.domain.values.Employee

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
                            it.currentlyImplementedProjects,
                            true, //TODO:
                            TeamMemberDto.toTeamMembers(it.members)
                    )
                }
    }
}