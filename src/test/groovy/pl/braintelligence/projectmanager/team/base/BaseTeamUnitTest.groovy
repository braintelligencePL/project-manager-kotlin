package pl.braintelligence.projectmanager.team.base

import pl.braintelligence.projectmanager.base.BaseUnitTest
import pl.braintelligence.projectmanager.core.team.domain.configuration.TeamConfiguration
import pl.braintelligence.projectmanager.core.team.ports.incoming.TeamManager

class BaseTeamUnitTest extends BaseUnitTest {

    protected TeamManager teamService = new TeamConfiguration().teamManager()

}
