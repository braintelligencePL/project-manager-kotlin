package pl.braintelligence.projectmanager.projects.domain

import pl.braintelligence.projectmanager.base.BaseUnitSpec
import pl.braintelligence.projectmanager.domain.exceptions.InvalidEntityException
import pl.braintelligence.projectmanager.domain.project.Project
import pl.braintelligence.projectmanager.domain.values.Status
import spock.lang.Unroll

class ProjectCreationSpec extends BaseUnitSpec {

    @Unroll
    def "Project should have id"() {
        when:
        new Project("", "name", Status.TO_DO, "assigned team", null)

        then:
        thrown(InvalidEntityException)
    }

}
