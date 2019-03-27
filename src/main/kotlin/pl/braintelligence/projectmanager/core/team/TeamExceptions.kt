package pl.braintelligence.projectmanager.core.team

import pl.braintelligence.projectmanager.shared.DomainException


class EntityAlreadyExistsException(message: String) : DomainException(message)
