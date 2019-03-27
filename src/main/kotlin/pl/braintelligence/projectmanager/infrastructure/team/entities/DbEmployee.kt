package pl.braintelligence.projectmanager.infrastructure.team.entities

import pl.braintelligence.projectmanager.core.team.Employee
import pl.braintelligence.projectmanager.core.team.JobPosition

data class DbEmployee(
        private val firstName: String,
        private val lastName: String,
        private val position: JobPosition
) {
    companion object {
        fun toDbEmployee(employee: List<Employee>): List<DbEmployee> =
                employee.map { toDbEmployee(it) }

        private fun toDbEmployee(employee: Employee): DbEmployee =
                DbEmployee(
                        employee.firstName,
                        employee.lastName,
                        employee.position
                )

        fun toEmployee(dbEmployee: DbEmployee): Employee =
                Employee(
                        dbEmployee.firstName,
                        dbEmployee.lastName,
                        dbEmployee.position
                )
    }
}
