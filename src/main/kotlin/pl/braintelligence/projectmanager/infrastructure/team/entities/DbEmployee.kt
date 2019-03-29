package pl.braintelligence.projectmanager.infrastructure.team.entities

import pl.braintelligence.projectmanager.core.team.domain.Employee
import pl.braintelligence.projectmanager.core.team.domain.JobPosition

data class DbEmployee(
        private val firstName: String,
        private val lastName: String,
        private val position: String
) {
    companion object {
        fun toDbEmployee(employee: List<Employee>): List<DbEmployee> =
                employee.map { toDbEmployee(it) }

        private fun toDbEmployee(employee: Employee): DbEmployee =
                DbEmployee(
                        employee.firstName,
                        employee.lastName,
                        employee.position.toString()
                )

        fun toEmployee(dbEmployee: DbEmployee): Employee =

                Employee(
                        dbEmployee.firstName,
                        dbEmployee.lastName,
                        JobPosition.valueOf(dbEmployee.position)
                )
    }
}
