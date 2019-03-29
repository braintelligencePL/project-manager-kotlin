package pl.braintelligence.projectmanager.core.team.domain

import pl.braintelligence.projectmanager.shared.DomainException

class EntityAlreadyExistsException(message: String) : DomainException(message)

class MissingTeamException(message: String) : DomainException(message)

class InvalidTeamException(message: String) : DomainException(message)

class InvalidTeamMemberException(message: String) : DomainException(message)
