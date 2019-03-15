package pl.braintelligence.projectmanager.infrastructure.persistence.team

import pl.braintelligence.projectmanager.domain.values.Employee
import pl.braintelligence.projectmanager.domain.values.JobPosition

data class DbEmployee(
        val firstName: String,
        val lastName: String,
        val jobPosition: String
) {
    companion object {
        fun toDbEmployee(employee: Employee): DbEmployee =
                DbEmployee(
                        employee.firstName,
                        employee.lastName,
                        employee.jobPosition.toString()
                )

        fun fromDbEmployee(dbEmployee: DbEmployee): Employee =
                Employee(
                        dbEmployee.firstName,
                        dbEmployee.lastName,
                        JobPosition.valueOf(dbEmployee.jobPosition)
                )
    }
}
