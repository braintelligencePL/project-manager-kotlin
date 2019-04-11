package pl.braintelligence.projectmanager.core.projects.domain

import pl.braintelligence.projectmanager.shared.DomainException


internal class MissingProjectException(message: String) : DomainException(message)
