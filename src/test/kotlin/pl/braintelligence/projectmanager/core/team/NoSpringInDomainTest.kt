package pl.braintelligence.projectmanager.core.team

import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses
import org.junit.jupiter.api.TestInstance

/**
 * Feel free to create PR with more rules :)
 */

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@AnalyzeClasses(packagesOf = [NoSpringInDomainTest::class])
internal class NoSpringInDomainTest {

    @ArchTest
    val `Core (domain) should not depend on spring` =
            noClasses()
                    .that()
                    .resideInAPackage("..pl.braintelligence.projectmanager.core..domain..")
                    .should()
                    .dependOnClassesThat()
                    .resideInAPackage("org.springframework..")
}
