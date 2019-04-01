package pl.braintelligence.projectmanager.core.team

import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses
import com.tngtech.archunit.library.dependencies.SlicesRuleDefinition
import pl.braintelligence.projectmanager.Application

/**
 * Feel free to create PR with more rules :)
 */

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@AnalyzeClasses(packagesOf = [Application::class])
internal class HexagonalArchitectureTest {

    @ArchTest
    val `other domain features does dont depend on each other` =
            SlicesRuleDefinition.slices()
                    .matching("..core.(*)..")
                    .should()
                    .notDependOnEachOther()

    @ArchTest
    val `Core (domain) does not have infrastructure code` =
            noClasses()
                    .that()
                    .resideInAPackage("..core..")
                    .should()
                    .accessClassesThat()
                    .resideInAnyPackage("..infrastructure..")

    @ArchTest
    val `Controllers are in adapters` =
            classes()
                    .that()
                    .haveSimpleNameStartingWith("Controller")
                    .should()
                    .resideInAPackage("..adapter..")

}
