package pl.braintelligence.projectmanager.team

import pl.braintelligence.projectmanager.base.BaseIntegrationSpec
import pl.braintelligence.projectmanager.team.base.OperatingOnTeamEndpoint
import spock.lang.Unroll

import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY
import static pl.braintelligence.projectmanager.team.base.SampleNewTeamDto.sampleNewTeamDto
import static pl.braintelligence.projectmanager.team.base.SampleTeamMemberDto.sampleTeamMemberDto

class TeamEndpointSadPathSpec extends BaseIntegrationSpec implements OperatingOnTeamEndpoint {

    def "Should not create a team that already exists"() {
        given: "create new team"
        createNewTeam(sampleNewTeamDto())

        when: "create team with already existing team-name"
        def response = createNewTeam(sampleNewTeamDto())

        then: "system throws that team already exist"
        response.statusCode == UNPROCESSABLE_ENTITY
        response.body.message == "TEAM_ALREADY_EXISTS"
    }

    @Unroll
    def "Should not create unnamed new-team"() {
        when: "post new team with empty-name"
        def response = createNewTeam(sampleNewTeamDto(name: name))

        then: "system cannot create a team with empty team-name"
        response.statusCode == UNPROCESSABLE_ENTITY
        response.body.message == "EMPTY_TEAM_NAME"

        where:
        name << ['', '  ']
    }

    @Unroll
    def "Should not add new-member without first-name to a team"() {
        given: "new team is created"
        createNewTeam(sampleNewTeamDto())
        and: "member with empty first-name"
        def teamMember = sampleTeamMemberDto(firstName: firstName)

        when: "adding member to a team without first-name"
        def response = addMemberToTeam(teamMember, sampleNewTeamDto())

        then: "system response - invalid first-name"
        response.statusCode == UNPROCESSABLE_ENTITY
        response.body.message == 'EMPTY_MEMBER_FIRST_NAME'

        where:
        firstName << ['', '  ']
    }

    @Unroll
    def "Should not add new-member without last-name to a team"() {
        given: "new team is created"
        createNewTeam(sampleNewTeamDto())

        and: "member with empty last-name"
        def teamMember = sampleTeamMemberDto(lastName: lastName)

        when: "adding member to a team without last-name"
        def response = addMemberToTeam(teamMember, sampleNewTeamDto())

        then: "system response - empty last-name"
        response.statusCode == UNPROCESSABLE_ENTITY
        response.body.message == 'EMPTY_MEMBER_LAST_NAME'

        where:
        lastName << ['', '  ']
    }

    @Unroll
    def "Should not add new-member without valid job-description to a team"() {
        given: "new team is created"
        createNewTeam(sampleNewTeamDto())

        and: "member with empty last-name"
        def teamMember = sampleTeamMemberDto(jobPosition: jobPosition)

        when: "adding member to a team without last-name"
        def response = addMemberToTeam(teamMember, sampleNewTeamDto())

        then: "system response - empty last-name"
        response.statusCode == UNPROCESSABLE_ENTITY
        response.body.message == errorCode

        where:
        jobPosition             | errorCode
        ''                      | 'EMPTY_OR_INVALID_JOB_POSITION'
        '  '                    | 'EMPTY_OR_INVALID_JOB_POSITION'
        'invalid job position' | 'EMPTY_OR_INVALID_JOB_POSITION'
    }
}