package pl.braintelligence.projectmanager.core.team

import org.springframework.stereotype.Service
import pl.braintelligence.projectmanager.adapter.TeamMember

@Service
class TeamService(
        private val teamRepository: TeamRepository
) {

    fun createTeam(teamName: String) = when (teamRepository.existsByName(teamName)) {
        true -> throw EntityAlreadyExistsException("Team already exist.")
        false -> teamRepository.save(Team(teamName))
    }

    fun addMemberToTeam(teamName: String, teamMember: TeamMember) {
        TODO("not implemented")
    }

    fun getTeams(): List<Team> = teamRepository.findAll()

}
