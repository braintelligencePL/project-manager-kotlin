package pl.braintelligence.projectmanager.core.projects.domain

class Feature(
        val name: String,
        val status: Status = Status.TO_DO,
        val priorityLevel: PriorityLevel = PriorityLevel.NOT_DEFINED
)
