package pl.braintelligence.projectmanager.core.team.domain

import pl.braintelligence.projectmanager.shared.DomainException


internal class EntityAlreadyExistsException(message: String) : DomainException(message)

internal class MissingTeamException(message: String) : DomainException(message)

internal class InvalidTeamException(message: String) : DomainException(message)

internal class InvalidTeamMemberException(message: String) : DomainException(message)
