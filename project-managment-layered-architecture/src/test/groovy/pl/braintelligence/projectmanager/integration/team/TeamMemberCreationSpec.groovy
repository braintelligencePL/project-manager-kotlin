package pl.braintelligence.projectmanager.integration.team

import pl.braintelligence.projectmanager.integration.base.BaseIntegrationSpec
import pl.braintelligence.projectmanager.integration.team.base.OperatingOnTeamEndpoint
import spock.lang.Unroll

import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY
import static pl.braintelligence.projectmanager.integration.team.base.SampleNewTeamDto.sampleNewTeamDto

class TeamMemberCreationSpec extends BaseIntegrationSpec implements OperatingOnTeamEndpoint {

    def "Should not add new-member without first-name to a team"() {

    }

    def "Should not add new-member without last-name to a team"() {

    }

    def "Should not add new-member without valid job-description to a team"() {

    }

}
