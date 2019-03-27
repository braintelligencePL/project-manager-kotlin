package pl.braintelligence.projectmanager.core.team

import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses
import com.tngtech.archunit.library.dependencies.SlicesRuleDefinition
import org.junit.jupiter.api.TestInstance

/**
 *
 * Feel free to create PR with more rules :)
 *
 */

@TestInstance(TestInstance.Lifecycle.PER_CLASS) // new instance each time, basically
@AnalyzeClasses(packagesOf = [HexagonalArchitectureTest::class])
internal class HexagonalArchitectureTest {

    @ArchTest
    val `there are no package cycles` =
            SlicesRuleDefinition.slices()
                    .matching("$BASE_PACKAGE.(**)..")
                    .should()
                    .beFreeOfCycles()

    @ArchTest
    val `Core (domain) does not have infrastructure code` =
            noClasses()
                    .that()
                    .resideInAPackage("..core..")
                    .should()
                    .accessClassesThat()
                    .resideInAnyPackage("..infrastructure..")

    companion object {
        private val BASE_PACKAGE = HexagonalArchitectureTest::class.java.`package`.name
    }
}
