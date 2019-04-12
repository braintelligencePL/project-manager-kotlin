package pl.braintelligence.projectmanager.core.projects.domain

import pl.braintelligence.projectmanager.shared.DomainException


internal class MissingProjectException(message: String) : DomainException(message)

internal class InvalidProjectException(message: String) : DomainException(message)

internal class InvalidProjectFeatureException(message: String) : DomainException(message)
